package com.aic.paas.wsso.rest;

import java.util.List;

import com.aic.paas.wsso.bean.CSysOpOrg;
import com.aic.paas.wsso.bean.SysOpOrg;


public interface SysOpOrgSvc {
	
	
	
	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员角色表[SYS_OP_ROLE]查询列表
	 */
	public List<SysOpOrg> queryListByOpId(Long opId, CSysOpOrg cdt, String orders);


	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员角色表[SYS_OP_ROLE]查询列表
	 */
	public List<SysOpOrg> queryListByOrgId(Long orgId, CSysOpOrg cdt, String orders);
	
	
	
	
	/**
	 * 添加用户组织
	 * @param opId
	 * @param roleIds
	 */
	public void addOpOrgs(Long opId, Long[] orgIds);
	
	
	
	
	/**
	 * 删除用户所对应的组织
	 * @param opId
	 * @param orgIds
	 */
	public void removeOpOrgs(Long opId, Long[] orgIds);
	
	
	
	
	/**
	 * 设置用户直属组织
	 * @param opId
	 * @param orgId
	 * @return
	 */
	public Integer setDirectOrg(Long opId, Long orgId);
	
	
	
	/**
	 * 设置用户组织管理员
	 * @param opId
	 * @param orgId
	 * @return
	 */
	public Integer setAdminOrg(Long opId, Long orgId);
	
	
	
	
	
	
}
