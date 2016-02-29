package com.aic.paas.csso.svc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aic.paas.csso.rest.SysOpRoleSvc;
import com.aic.paas.csso.rest.SysOpSvc;
import com.aic.paas.csso.svc.ExternalOperationSvc;
import com.aic.paas.frame.cross.bean.CSysOp;
import com.aic.paas.frame.cross.bean.SysOp;
import com.binary.framework.exception.ServiceException;

public class ExternalOperationSvcImpl implements ExternalOperationSvc {

	
	@Autowired
	SysOpSvc sysOpSvc;
	
	@Autowired
	SysOpRoleSvc opRoleSvc;
	
	
	
	
	@Override
	public SysOp getSysOpByLoginCode(String loginCode) {
		CSysOp cdt = new CSysOp();
		cdt.setLoginCode(loginCode);
		List<SysOp> ls = sysOpSvc.queryList(cdt, null);
		if(ls.size() > 1) throw new ServiceException(" There are multiple the same loginCode '"+loginCode+"'! ");
		return ls.size()>0 ? ls.get(0) : null;
	}
	

	

}
