package com.aic.paas.wsso.bean;

import java.io.Serializable;

import com.aic.paas.frame.cross.bean.SysOp;

public class SysOpInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/** 用户信息 **/
	private SysOp op;
	
	
	/** 用户对应角色 **/
	private Long[] roleIds;

	

	public SysOp getOp() {
		return op;
	}


	public void setOp(SysOp op) {
		this.op = op;
	}


	public Long[] getRoleIds() {
		return roleIds;
	}


	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

	
	
	
	

}
