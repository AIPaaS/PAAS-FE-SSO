package com.aic.paas.csso.svc;

import com.aic.paas.frame.cross.bean.SysOp;




public interface ExternalOperationSvc {

	
	
	
	
	/**
	 * 跟据登录代码获取用户信息
	 * @param loginCode
	 * @return 用户不存在则返回null
	 */
	public SysOp getSysOpByLoginCode(String loginCode);
	
	
	
	
	
}
