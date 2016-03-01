package com.aic.paas.wsso.bean;




import com.binary.framework.bean.EntityBean;


/**
 * mapping-table: 操作员组织表[SYS_OP_ORG]
 */
public class SysOpOrg implements EntityBean {
	private static final long serialVersionUID = 1L;


	/**
	 * mapping-field: ID[ID]
	 */
	private Long id;


	/**
	 * mapping-field: 组织ID[ORG_ID]
	 */
	private Long orgId;


	/**
	 * mapping-field: 操作员ID[OP_ID]
	 */
	private Long opId;


	/**
	 * mapping-field: 直属标志[DIRECT_FLAG]
	 * 直属标志：1-直属 0-非直属
	 */
	private Integer directFlag;


	/**
	 * mapping-field: 管理员标志[ADMIN_FLAG]
	 * 管理员标志：1-是 0-否
	 */
	private Integer adminFlag;


	/**
	 * mapping-field: 备注[NOTES]
	 */
	private String notes;


	/**
	 * mapping-field: 状态[STATUS]
	 * 状态：1-正常 0-停用
	 */
	private Integer status;


	/**
	 * mapping-field: 数据状态[DATA_STATUS]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer dataStatus;


	/**
	 * mapping-field: 创建人[CREATOR]
	 */
	private String creator;


	/**
	 * mapping-field: 修改人[MODIFIER]
	 */
	private String modifier;


	/**
	 * mapping-field: 创建时间[CREATE_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long createTime;


	/**
	 * mapping-field: 修改时间[MODIFY_TIME]
	 * yyyyMMddHHmmss
	 */
	private Long modifyTime;




	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public Long getOrgId() {
		return this.orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}


	public Long getOpId() {
		return this.opId;
	}
	public void setOpId(Long opId) {
		this.opId = opId;
	}


	public Integer getDirectFlag() {
		return this.directFlag;
	}
	public void setDirectFlag(Integer directFlag) {
		this.directFlag = directFlag;
	}


	public Integer getAdminFlag() {
		return this.adminFlag;
	}
	public void setAdminFlag(Integer adminFlag) {
		this.adminFlag = adminFlag;
	}


	public String getNotes() {
		return this.notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getDataStatus() {
		return this.dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}


	public String getCreator() {
		return this.creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}


	public String getModifier() {
		return this.modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}


	public Long getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}


	public Long getModifyTime() {
		return this.modifyTime;
	}
	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}


}


