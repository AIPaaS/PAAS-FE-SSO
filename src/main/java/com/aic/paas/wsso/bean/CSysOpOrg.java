package com.aic.paas.wsso.bean;




import com.binary.framework.bean.Condition;


/**
 * condition-table: 操作员组织表[SYS_OP_ORG]
 */
public class CSysOpOrg implements Condition {
	private static final long serialVersionUID = 1L;


	/**
	 * condition-field: ID[ID] operate-Equal[=]
	 */
	private Long id;


	/**
	 * condition-field: ID[ID] operate-In[in]
	 */
	private Long[] ids;


	/**
	 * condition-field: ID[ID] operate-GTEqual[>=]
	 */
	private Long startId;

	/**
	 * condition-field: ID[ID] operate-LTEqual[<=]
	 */
	private Long endId;


	/**
	 * condition-field: 组织ID[ORG_ID] operate-Equal[=]
	 */
	private Long orgId;


	/**
	 * condition-field: 组织ID[ORG_ID] operate-In[in]
	 */
	private Long[] orgIds;


	/**
	 * condition-field: 组织ID[ORG_ID] operate-GTEqual[>=]
	 */
	private Long startOrgId;

	/**
	 * condition-field: 组织ID[ORG_ID] operate-LTEqual[<=]
	 */
	private Long endOrgId;


	/**
	 * condition-field: 操作员ID[OP_ID] operate-Equal[=]
	 */
	private Long opId;


	/**
	 * condition-field: 操作员ID[OP_ID] operate-In[in]
	 */
	private Long[] opIds;


	/**
	 * condition-field: 操作员ID[OP_ID] operate-GTEqual[>=]
	 */
	private Long startOpId;

	/**
	 * condition-field: 操作员ID[OP_ID] operate-LTEqual[<=]
	 */
	private Long endOpId;


	/**
	 * condition-field: 直属标志[DIRECT_FLAG] operate-Equal[=]
	 * 直属标志：1-直属 0-非直属
	 */
	private Integer directFlag;


	/**
	 * condition-field: 直属标志[DIRECT_FLAG] operate-In[in]
	 * 直属标志：1-直属 0-非直属
	 */
	private Integer[] directFlags;


	/**
	 * condition-field: 直属标志[DIRECT_FLAG] operate-GTEqual[>=]
	 * 直属标志：1-直属 0-非直属
	 */
	private Integer startDirectFlag;

	/**
	 * condition-field: 直属标志[DIRECT_FLAG] operate-LTEqual[<=]
	 * 直属标志：1-直属 0-非直属
	 */
	private Integer endDirectFlag;


	/**
	 * condition-field: 管理员标志[ADMIN_FLAG] operate-Equal[=]
	 * 管理员标志：1-是 0-否
	 */
	private Integer adminFlag;


	/**
	 * condition-field: 管理员标志[ADMIN_FLAG] operate-In[in]
	 * 管理员标志：1-是 0-否
	 */
	private Integer[] adminFlags;


	/**
	 * condition-field: 管理员标志[ADMIN_FLAG] operate-GTEqual[>=]
	 * 管理员标志：1-是 0-否
	 */
	private Integer startAdminFlag;

	/**
	 * condition-field: 管理员标志[ADMIN_FLAG] operate-LTEqual[<=]
	 * 管理员标志：1-是 0-否
	 */
	private Integer endAdminFlag;


	/**
	 * condition-field: 备注[NOTES] operate-Like[like]
	 */
	private String notes;


	/**
	 * condition-field: 状态[STATUS] operate-Equal[=]
	 * 状态：1-正常 0-停用
	 */
	private Integer status;


	/**
	 * condition-field: 状态[STATUS] operate-In[in]
	 * 状态：1-正常 0-停用
	 */
	private Integer[] statuss;


	/**
	 * condition-field: 状态[STATUS] operate-GTEqual[>=]
	 * 状态：1-正常 0-停用
	 */
	private Integer startStatus;

	/**
	 * condition-field: 状态[STATUS] operate-LTEqual[<=]
	 * 状态：1-正常 0-停用
	 */
	private Integer endStatus;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-Equal[=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer dataStatus;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-In[in]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer[] dataStatuss;


	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-GTEqual[>=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer startDataStatus;

	/**
	 * condition-field: 数据状态[DATA_STATUS] operate-LTEqual[<=]
	 * 数据状态：1-正常 0-删除
	 */
	private Integer endDataStatus;


	/**
	 * condition-field: 创建人[CREATOR] operate-Like[like]
	 */
	private String creator;


	/**
	 * condition-field: 创建人[CREATOR] operate-Equal[=]
	 */
	private String creatorEqual;


	/**
	 * condition-field: 创建人[CREATOR] operate-In[in]
	 */
	private String[] creators;


	/**
	 * condition-field: 修改人[MODIFIER] operate-Like[like]
	 */
	private String modifier;


	/**
	 * condition-field: 修改人[MODIFIER] operate-Equal[=]
	 */
	private String modifierEqual;


	/**
	 * condition-field: 修改人[MODIFIER] operate-In[in]
	 */
	private String[] modifiers;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long createTime;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] createTimes;


	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startCreateTime;

	/**
	 * condition-field: 创建时间[CREATE_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endCreateTime;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-Equal[=]
	 * yyyyMMddHHmmss
	 */
	private Long modifyTime;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-In[in]
	 * yyyyMMddHHmmss
	 */
	private Long[] modifyTimes;


	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-GTEqual[>=]
	 * yyyyMMddHHmmss
	 */
	private Long startModifyTime;

	/**
	 * condition-field: 修改时间[MODIFY_TIME] operate-LTEqual[<=]
	 * yyyyMMddHHmmss
	 */
	private Long endModifyTime;




	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public Long[] getIds() {
		return this.ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}


	public Long getStartId() {
		return this.startId;
	}
	public void setStartId(Long startId) {
		this.startId = startId;
	}


	public Long getEndId() {
		return this.endId;
	}
	public void setEndId(Long endId) {
		this.endId = endId;
	}


	public Long getOrgId() {
		return this.orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}


	public Long[] getOrgIds() {
		return this.orgIds;
	}
	public void setOrgIds(Long[] orgIds) {
		this.orgIds = orgIds;
	}


	public Long getStartOrgId() {
		return this.startOrgId;
	}
	public void setStartOrgId(Long startOrgId) {
		this.startOrgId = startOrgId;
	}


	public Long getEndOrgId() {
		return this.endOrgId;
	}
	public void setEndOrgId(Long endOrgId) {
		this.endOrgId = endOrgId;
	}


	public Long getOpId() {
		return this.opId;
	}
	public void setOpId(Long opId) {
		this.opId = opId;
	}


	public Long[] getOpIds() {
		return this.opIds;
	}
	public void setOpIds(Long[] opIds) {
		this.opIds = opIds;
	}


	public Long getStartOpId() {
		return this.startOpId;
	}
	public void setStartOpId(Long startOpId) {
		this.startOpId = startOpId;
	}


	public Long getEndOpId() {
		return this.endOpId;
	}
	public void setEndOpId(Long endOpId) {
		this.endOpId = endOpId;
	}


	public Integer getDirectFlag() {
		return this.directFlag;
	}
	public void setDirectFlag(Integer directFlag) {
		this.directFlag = directFlag;
	}


	public Integer[] getDirectFlags() {
		return this.directFlags;
	}
	public void setDirectFlags(Integer[] directFlags) {
		this.directFlags = directFlags;
	}


	public Integer getStartDirectFlag() {
		return this.startDirectFlag;
	}
	public void setStartDirectFlag(Integer startDirectFlag) {
		this.startDirectFlag = startDirectFlag;
	}


	public Integer getEndDirectFlag() {
		return this.endDirectFlag;
	}
	public void setEndDirectFlag(Integer endDirectFlag) {
		this.endDirectFlag = endDirectFlag;
	}


	public Integer getAdminFlag() {
		return this.adminFlag;
	}
	public void setAdminFlag(Integer adminFlag) {
		this.adminFlag = adminFlag;
	}


	public Integer[] getAdminFlags() {
		return this.adminFlags;
	}
	public void setAdminFlags(Integer[] adminFlags) {
		this.adminFlags = adminFlags;
	}


	public Integer getStartAdminFlag() {
		return this.startAdminFlag;
	}
	public void setStartAdminFlag(Integer startAdminFlag) {
		this.startAdminFlag = startAdminFlag;
	}


	public Integer getEndAdminFlag() {
		return this.endAdminFlag;
	}
	public void setEndAdminFlag(Integer endAdminFlag) {
		this.endAdminFlag = endAdminFlag;
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


	public Integer[] getStatuss() {
		return this.statuss;
	}
	public void setStatuss(Integer[] statuss) {
		this.statuss = statuss;
	}


	public Integer getStartStatus() {
		return this.startStatus;
	}
	public void setStartStatus(Integer startStatus) {
		this.startStatus = startStatus;
	}


	public Integer getEndStatus() {
		return this.endStatus;
	}
	public void setEndStatus(Integer endStatus) {
		this.endStatus = endStatus;
	}


	public Integer getDataStatus() {
		return this.dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}


	public Integer[] getDataStatuss() {
		return this.dataStatuss;
	}
	public void setDataStatuss(Integer[] dataStatuss) {
		this.dataStatuss = dataStatuss;
	}


	public Integer getStartDataStatus() {
		return this.startDataStatus;
	}
	public void setStartDataStatus(Integer startDataStatus) {
		this.startDataStatus = startDataStatus;
	}


	public Integer getEndDataStatus() {
		return this.endDataStatus;
	}
	public void setEndDataStatus(Integer endDataStatus) {
		this.endDataStatus = endDataStatus;
	}


	public String getCreator() {
		return this.creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}


	public String getCreatorEqual() {
		return this.creatorEqual;
	}
	public void setCreatorEqual(String creatorEqual) {
		this.creatorEqual = creatorEqual;
	}


	public String[] getCreators() {
		return this.creators;
	}
	public void setCreators(String[] creators) {
		this.creators = creators;
	}


	public String getModifier() {
		return this.modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}


	public String getModifierEqual() {
		return this.modifierEqual;
	}
	public void setModifierEqual(String modifierEqual) {
		this.modifierEqual = modifierEqual;
	}


	public String[] getModifiers() {
		return this.modifiers;
	}
	public void setModifiers(String[] modifiers) {
		this.modifiers = modifiers;
	}


	public Long getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}


	public Long[] getCreateTimes() {
		return this.createTimes;
	}
	public void setCreateTimes(Long[] createTimes) {
		this.createTimes = createTimes;
	}


	public Long getStartCreateTime() {
		return this.startCreateTime;
	}
	public void setStartCreateTime(Long startCreateTime) {
		this.startCreateTime = startCreateTime;
	}


	public Long getEndCreateTime() {
		return this.endCreateTime;
	}
	public void setEndCreateTime(Long endCreateTime) {
		this.endCreateTime = endCreateTime;
	}


	public Long getModifyTime() {
		return this.modifyTime;
	}
	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}


	public Long[] getModifyTimes() {
		return this.modifyTimes;
	}
	public void setModifyTimes(Long[] modifyTimes) {
		this.modifyTimes = modifyTimes;
	}


	public Long getStartModifyTime() {
		return this.startModifyTime;
	}
	public void setStartModifyTime(Long startModifyTime) {
		this.startModifyTime = startModifyTime;
	}


	public Long getEndModifyTime() {
		return this.endModifyTime;
	}
	public void setEndModifyTime(Long endModifyTime) {
		this.endModifyTime = endModifyTime;
	}


}


