package com.youying.western.entity;

import java.util.ArrayList;
import java.util.List;


public class Menu implements java.io.Serializable{

	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private List<Permission> list=new ArrayList<Permission>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Permission> getList() {
		return list;
	}
	public void setList(List<Permission> list) {
		this.list = list;
	}
	
}
