package com.aic.paas.wsso.svc;

import com.aic.paas.frame.cross.bean.SysOp;
import com.aic.paas.wsso.bean.WsMerchent;




public interface ExternalOperationSvc {

	
	
	
	
	/**
	 * 跟据登录代码获取用户信息
	 * @param loginCode
	 * @return 用户不存在则返回null
	 */
	public SysOp getSysOpByLoginCode(String loginCode);
	
	
	
	
	/**
	 * 注册用户
	 * @param mnt租户信息
	 * @return null||""表示注册成功, 否则为出错信息
	 */
	public String register(WsMerchent mnt);
	
	
	
	
	
	
	
}
