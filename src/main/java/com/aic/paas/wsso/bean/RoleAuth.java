package com.aic.paas.wsso.bean;

import java.io.Serializable;
import java.util.List;

import com.aic.paas.frame.cross.bean.SysRole;

public class RoleAuth implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/** 系统角色 **/
	private SysRole role;
	
	
	/** 权限菜单根节点 **/
	private List<MenuNode> roots;

	
	

	public SysRole getRole() {
		return role;
	}


	public void setRole(SysRole role) {
		this.role = role;
	}


	public List<MenuNode> getRoots() {
		return roots;
	}


	public void setRoots(List<MenuNode> roots) {
		this.roots = roots;
	}
	
	
	
	
	
	
	
	

}
