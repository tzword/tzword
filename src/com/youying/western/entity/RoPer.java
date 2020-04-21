package com.youying.western.entity;

import java.util.Date;

/**
 * TRoPer entity. @author MyEclipse Persistence Tools
 */

public class RoPer implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer roleId;
	private Integer permissionId;
	private Date createDt;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	

}