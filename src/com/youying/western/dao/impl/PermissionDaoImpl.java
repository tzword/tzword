package com.youying.western.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.youying.western.dao.PermissionDao;
import com.youying.western.entity.Permission;
import com.youying.western.entity.RoPer;
@Repository
public class PermissionDaoImpl extends HibernateDaoSupport implements PermissionDao{
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	// 添加权限
	public void addPermission(Permission permission) {
		this.getHibernateTemplate().save(permission);
	}
	// 修改权限
	public void updPermission(Permission permission) {
		this.getHibernateTemplate().update(permission);
	}
	//查询权限
	@SuppressWarnings("unchecked")
	public List<Permission> searchPermission(){
		String hql="from Permission";
		return this.getHibernateTemplate().find(hql);
	}
	//根据ID得到权限
	@SuppressWarnings("unchecked")
	public Permission queryByID(String id){
		String hql="from Permission where id="+id;
		List<Permission> list = this.getHibernateTemplate().find(hql);
		if (list!=null&&list.size()!=0) {
			Permission permission =new Permission();
			permission=list.get(0);
			return permission;
		}
		return null;
	}
	//为角色分配权限
	public void addRoper(RoPer roPer){
		this.getHibernateTemplate().save(roPer);
	};
}
