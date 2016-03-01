package com.aic.paas.wsso.rest;

import java.util.List;

import com.aic.paas.frame.cross.bean.CSysOp;
import com.aic.paas.frame.cross.bean.CSysRole;
import com.aic.paas.frame.cross.bean.SysOp;
import com.aic.paas.frame.cross.bean.SysRole;
import com.aic.paas.wsso.bean.CWsMerchent;
import com.aic.paas.wsso.bean.RoleAuth;
import com.aic.paas.wsso.bean.SysOpInfo;
import com.aic.paas.wsso.bean.WsMerchent;
import com.binary.jdbc.Page;

public interface MerchentSvc {
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public Page<WsMerchent> queryPage(Integer pageNum, Integer pageSize, CWsMerchent cdt, String orders);


	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 
	 */
	public List<WsMerchent> queryList(CWsMerchent cdt, String orders);


	
	/**
	 * 跟据主键查询
	 * @param id : 主键ID
	 * @return 
	 */
	public WsMerchent queryById(Long id);
	
	
	
	/**
	 * 查询个数
	 * @param cdt
	 * @return
	 */
	public Long queryCount(CWsMerchent cdt);
	
	
	
	
	/**
	 * 保存获更新，判断主键ID[id]是否存在, 存在则更新, 不存在则插入
	 * @param record : WsMerchent数据记录
	 * @return 当前记录主键[id]值
	 */
	public Long saveOrUpdate(WsMerchent record);
	
	
	
	
	/**
	 * 审核租户
	 * @param id
	 * @param checkType 1=通过    2=退回
	 * @param checkDesc
	 */
	public void checkMnt(Long id, Integer checkType, String checkDesc);
	
	
	
	
	/**
	 * 跟据产品ID删除产品 (会级连删除产品下的应用、附件、任务)
	 * @param classId
	 * @return
	 */
	public int removeById(Long id);
	
	
	
	
	/**
	 * 保存租户下的用户
	 * @param mntId 指定用户在哪个租户下
	 * @param record
	 * @return
	 */
	public Long saveOrUpdateUser(Long mntId, SysOp record);
	
	
	
	/**
	 * 删除用户
	 * @param opId
	 * @return 返回删除记录数
	 */
	public int removeUser(Long opId);
	
	
	
	/**
	 * 查询用户对应角色
	 * @param opId
	 * @return
	 */
	public List<SysRole> queryOpRoles(Long opId);
	
	
	
	
	/**
	 * 分页查询
	 * @param pageNum : 指定页码
	 * @param pageSize : 指定页行数
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员表[SYS_OP]分页列表对象
	 */
	public Page<SysOpInfo> queryOpInfoPage(Integer pageNum, Integer pageSize, CSysOp cdt, String orders);


	
	/**
	 * 不分页查询
	 * @param cdt : 条件对象
	 * @param orders : 排序字段, 多字段以逗号分隔
	 * @return 操作员表[SYS_OP]查询列表
	 */
	public List<SysOpInfo> queryOpInfoList(CSysOp cdt, String orders);
	
	
	
	
	/**
	 * 跟据opId查询详情
	 * @param opId
	 * @return
	 */
	public SysOpInfo queryOpInfoById(Long opId);
	
	
	
	
	/**
	 * 设置用户角色
	 * @param opId
	 * @param roleIds
	 */
	public void setUserRoles(Long opId, Long[] roleIds);
	
	
	
	
	/**
	 * 查询角色权限清单
	 * @param cdt
	 * @param orders
	 * @return
	 */
	public List<RoleAuth> queryRoleAuthView(CSysRole cdt, String orders);
	
	
	
	

}
