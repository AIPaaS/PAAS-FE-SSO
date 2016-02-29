package com.aic.paas.csso;

import java.util.List;

import com.aic.paas.frame.cross.bean.SysFrameUser;
import com.aic.paas.frame.cross.bean.SysOp;
import com.aic.paas.frame.cross.bean.SysRole;
import com.binary.core.util.BinaryUtils;



/**
 * 登录用户信息
 * @author wanwb
 */
public class LoginUser extends SysFrameUser {
	private static final long serialVersionUID = 1L;
	
	
	/** 登录用户信息 **/
	private SysOp op;
	
		
	/** 登录用户主角色信息 **/
	private SysRole majorRole;
	
	/** 登录用户次要角色信息 **/
	private List<SysRole> minorRoles;
	
	
	
	
	public LoginUser(SysOp op, SysRole majorRole, List<SysRole> minorRoles, Boolean openAuthMgr, Long[] authModuIds) {
		this.op = op;
		this.majorRole = majorRole;
		this.minorRoles = minorRoles;
		
		this.setAuthCode(BinaryUtils.getUUID());
		this.setOpenAuthMgr(openAuthMgr);
		this.setAuthModuIds(authModuIds);
		
		this.setId(this.op.getId());
		this.setUserId(String.valueOf(this.op.getId()));
		this.setUserCode(this.op.getOpCode());
		this.setUserName(this.op.getOpName());
		this.setLoginCode(this.op.getLoginCode());
	}
	
	
	
	public SysOp getOp() {
		return op;
	}
	
	
	public SysRole getMajorRole() {
		return majorRole;
	}
	
	
	public List<SysRole> getMinorRoles() {
		return minorRoles;
	}


	



	
	
	
	
	
	
	
}






