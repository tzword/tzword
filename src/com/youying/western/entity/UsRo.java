package com.youying.western.entity;

import java.util.Date;

public class UsRo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userId;
	private Integer roleId;
	private Date createDt;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
	

}