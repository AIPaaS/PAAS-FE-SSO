package com.aic.paas.wsso.bean;

import java.io.Serializable;
import java.util.List;

import com.aic.paas.frame.cross.bean.SysMenu;

public class MenuNode implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/** 系统菜单 **/
	private SysMenu menu;
	
	
	/** 子节点菜单 **/
	private List<MenuNode> children;


	
	public SysMenu getMenu() {
		return menu;
	}


	public void setMenu(SysMenu menu) {
		this.menu = menu;
	}


	public List<MenuNode> getChildren() {
		return children;
	}


	public void setChildren(List<MenuNode> children) {
		this.children = children;
	}
	
	
	
	
	

}
