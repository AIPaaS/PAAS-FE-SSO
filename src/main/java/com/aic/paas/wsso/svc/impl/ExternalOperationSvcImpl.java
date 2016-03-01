package com.aic.paas.wsso.svc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.frame.cross.bean.CSysOp;
import com.aic.paas.frame.cross.bean.SysOp;
import com.aic.paas.wsso.bean.CWsMerchent;
import com.aic.paas.wsso.bean.WsMerchent;
import com.aic.paas.wsso.rest.MerchentSvc;
import com.aic.paas.wsso.rest.SysOpRoleSvc;
import com.aic.paas.wsso.rest.SysOpSvc;
import com.aic.paas.wsso.svc.ExternalOperationSvc;
import com.binary.core.util.BinaryUtils;
import com.binary.framework.exception.ServiceException;

public class ExternalOperationSvcImpl implements ExternalOperationSvc {

	
	@Autowired
	SysOpSvc sysOpSvc;
	
	@Autowired
	SysOpRoleSvc opRoleSvc;
	
		
	
	@Autowired
	private MerchentSvc merchentSvc;	
	
	
	
	
	
	
	@Override
	public SysOp getSysOpByLoginCode(String loginCode) {
		CSysOp cdt = new CSysOp();
		cdt.setLoginCode(loginCode);
		List<SysOp> ls = sysOpSvc.queryList(cdt, null);
		if(ls.size() > 1) throw new ServiceException(" There are multiple the same loginCode '"+loginCode+"'! ");
		return ls.size()>0 ? ls.get(0) : null;
	}
	

	
	@Override
	public String register(WsMerchent mnt) {
		BinaryUtils.checkEmpty(mnt, "mnt");
		
		if(BinaryUtils.isEmpty(mnt.getMntCode())) {
			return "租户代码为空";
		}
		if(BinaryUtils.isEmpty(mnt.getMntName())) {
			return "租户名称为空";
		}
		if(BinaryUtils.isEmpty(mnt.getMntPwd())) {
			return "登录密码为空";
		}
		
		if(BinaryUtils.isEmpty(mnt.getContactEmail())) {
			return "邮箱地址为空";
		}
		if(BinaryUtils.isEmpty(mnt.getCcCode())) {
			return "成本中心为空";
		}
		if(BinaryUtils.isEmpty(mnt.getContactName())) {
			return "联系人员为空";
		}
		if(BinaryUtils.isEmpty(mnt.getContactPhone())) {
			return "联系电话为空";
		}
		
		if(mnt.getMntPwd().length() < 6) {
			return "密码长度不可小于6位";
		}
		if(!mnt.getMntCode().matches("([0-9]|[a-zA-Z]){1,32}")) {
			return "租户代码为1-32位字母或数字组合";
		}
		if(!mnt.getContactEmail().matches("([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9_\\-])+\\.)+([a-zA-Z0-9]{2,8})+")) {
			return "邮箱地址不合法";
		}
		
		CWsMerchent cdt = new CWsMerchent();
		cdt.setMntCode(mnt.getMntCode());
		long count = merchentSvc.queryCount(cdt);
		if(count > 0) {
			return "租户代码["+mnt.getMntCode()+"]已存在!";
		}
		
		merchentSvc.saveOrUpdate(mnt);
		return null;
	}
	
	
	
	

}
