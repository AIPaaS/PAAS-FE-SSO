package com.aic.paas.csso;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.csso.rest.SysOpSvc;
import com.aic.paas.frame.cross.bean.CSysOp;
import com.aic.paas.frame.cross.bean.CSysRole;
import com.aic.paas.frame.cross.bean.SysOp;
import com.aic.paas.frame.cross.bean.SysOpRole;
import com.aic.paas.frame.cross.bean.SysRole;
import com.aic.paas.frame.cross.peer.SysFramePeer;
import com.aic.paas.frame.util.SysFrameUtil;
import com.binary.core.encrypt.Encrypt;
import com.binary.framework.bean.User;
import com.binary.framework.exception.ServiceException;
import com.binary.sso.server.auth.UserLoginListener;
import com.binary.sso.server.exception.SsoVerifyException;

public class SysUserLoginListener implements UserLoginListener {
	private static Logger logger = LoggerFactory.getLogger(SysUserLoginListener.class);

	
	private static enum VerifyErrorCode {
		LOGIN_LOGINCODE_ERROR,			//登录 - 登录代码输入错误
		LOGIN_PASSWORD_ERROR,			//登录 - 登录密码输入错误
		LOGIN_LOGINCODE_MULTI,			//登录 - 登录代码查询多个用户
		LOGIN_OP_INVALID,				//登录 - 用户已失效
		LOGIN_OP_LOCKED,				//登录 - 用户已被锁定
		
		LOGIN_ROLE_EMPTY,				//登录 - 用户所属主角色不存在
		LOGIN_ROLE_MULTI,				//登录 - 用户所属主角色存在多个
		LOGIN_ROLE_INVALID				//登录 - 用户所属主角色已失效
	}
	
	@Autowired
	SysOpSvc sysOpSvc;
		
	@Autowired
	SysFramePeer sysFramePeer;
	
	
	private Boolean openAuthMgr;
	
	
	
	public void setOpenAuthMgr(Boolean openAuthMgr) {
		this.openAuthMgr = openAuthMgr;
	}

	

	@Override
	public User verify(String loginCode, String password) throws SsoVerifyException {
		CSysOp cdt = new CSysOp();
		cdt.setLoginCode(loginCode);
		cdt.setOpKind(1);		//1=平台用户    2=租户用户
		List<SysOp> ls = sysOpSvc.queryList(cdt, null);
		if(ls.size() > 1) throw new ServiceException(" There are multiple the same loginCode '"+loginCode+"'! ");
		
		SysOp op = null;
		if(ls.size() > 0) op = ls.get(0);
		
		//认证用户
		if(op == null) throw new SsoVerifyException(VerifyErrorCode.LOGIN_LOGINCODE_ERROR.toString(), "登录名输入错误!");
		
		String dbpwd = op.getLoginPasswd();
		String pwd = Encrypt.encrypt(password);
		if(!pwd.equals(dbpwd)) throw new SsoVerifyException(VerifyErrorCode.LOGIN_PASSWORD_ERROR.toString(), "登录密码输入错误!");
		
		Integer status = op.getStatus();
		Integer lock = op.getLockFlag();
		if(status==null || status.intValue()!=1) throw new SsoVerifyException(VerifyErrorCode.LOGIN_OP_INVALID.toString(), "用户未激活!");
		if(lock==null || lock.intValue()!=0) throw new SsoVerifyException(VerifyErrorCode.LOGIN_OP_LOCKED.toString(), "用户已被锁定!");
		
		
		//认证用户角色
		List<SysOpRole> rltls = sysFramePeer.getOpRoles(op.getId(), null, null);
		
		Long masterRoleId = null;
		List<Long> allRoleIds = new ArrayList<Long>();
		for(int i=0; i<rltls.size(); i++) {
			SysOpRole rlt = rltls.get(i);
			Long roleId = rlt.getRoleId();
			Integer ismaster = rlt.getIsMaster();
			if(ismaster!=null && ismaster.intValue()==1) {
				if(masterRoleId!=null) throw new SsoVerifyException(VerifyErrorCode.LOGIN_ROLE_MULTI.toString(), "用户所属主角色存在多个!");
				masterRoleId = roleId;
			}
			allRoleIds.add(roleId);
		}
		
		if(masterRoleId == null) throw new SsoVerifyException(VerifyErrorCode.LOGIN_ROLE_EMPTY.toString(), "用户所属主角色不存在!");
		
		CSysRole rolecdt = new CSysRole();
		rolecdt.setIds(allRoleIds.toArray(new Long[0]));
		rolecdt.setRoleType(1);			//1=平台角色    2=租户角色
		List<SysRole> roles = sysFramePeer.getRoleList(rolecdt, null);
		
		SysRole masterRole = null;
		List<SysRole> slaveRoles = new ArrayList<SysRole>();
		for(int i=0; i<roles.size(); i++) {
			SysRole r = roles.get(i);
			if(masterRole==null && r.getId().equals(masterRoleId)) {
				masterRole = r;
			}else {
				slaveRoles.add(r);
			}
		}
		
		if(masterRole == null) throw new SsoVerifyException(VerifyErrorCode.LOGIN_ROLE_EMPTY.toString(), "用户所属主角色不存在!");
				
		//认证资源
		Long[] moduIds = sysFramePeer.getAllModuIds(op.getId(), null, null, this.openAuthMgr);
		
		return new LoginUser(op, masterRole, slaveRoles, this.openAuthMgr, moduIds);
	}


	
	
	@Override
	public void onLoginSuccess(HttpServletRequest request, HttpServletResponse response, User user, String sessionId) {
		LoginUser loginUser = (LoginUser)user;
		SysOp op = loginUser.getOp();
		sysFramePeer.setOpLoginLog(op, user.getAuthCode(), sessionId);
		SysFrameUtil.refreshLogin(request);
	}
	
	
	
	

	
	@Override
	public void onLoginFailed(HttpServletRequest request, HttpServletResponse response, String loginCode, String password, Exception e) {
		logger.info(" user ["+loginCode+"] login failed : " + e.getMessage());
	}
	
	
	
	@Override
	public void onLogout(HttpServletRequest request, HttpServletResponse response, User user, String sessionId) {
		sysFramePeer.setOpLogoutLog(user.getId(), sessionId);
	}
	
	
	

}
