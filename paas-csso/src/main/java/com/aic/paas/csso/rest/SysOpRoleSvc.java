package com.aic.paas.csso.rest;


import java.util.List;

import com.aic.paas.frame.cross.bean.CSysOpRole;
import com.aic.paas.frame.cross.bean.SysOpRole;


/**
 * SysOpRole服务
 */
public interface SysOpRoleSvc {


	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员角色表[SYS_OP_ROLE]查询列表
	 */
	public List<SysOpRole> queryListByOpId(Long opId, CSysOpRole cdt, String orders);


	
	
	
	/**
	 * 添加用户角色
	 * @param opId
	 * @param roleIds
	 */
	public void addOpRoles(Long opId, Long[] roleIds);
	
	
	
	
	/**
	 * 删除用户所对应的角色
	 * @param opId
	 * @param roleIds
	 */
	public void removeOpRoles(Long opId, Long[] roleIds);
	
	
	
	
	/**
	 * 设置主角色
	 * @param opId
	 * @param roleId
	 * @return
	 */
	public Integer setMasterRole(Long opId, Long roleId);
	
	
	
	
	

}


