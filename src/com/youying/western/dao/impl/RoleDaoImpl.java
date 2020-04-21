package com.youying.western.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.youying.western.dao.RoleDao;
import com.youying.western.entity.Role;
import com.youying.western.entity.UsRo;
@Repository
public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao{
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	// 添加角色
	public void addRole(Role role) {
		this.getHibernateTemplate().save(role);
	}
	// 修改角色
	public void updRole(Role role) {
		this.getHibernateTemplate().update(role);
	}
	//查询角色
	@SuppressWarnings("unchecked")
	public List<Role> searchRole(){
		String hql="from Role";
		return this.getHibernateTemplate().find(hql);
	}
	//根据ID查询角色
	@SuppressWarnings("unchecked")
	public Role queryByID(String id){
		String hql="from Role where id="+id;
		List<Role> list= this.getHibernateTemplate().find(hql);
		if (list!=null&&list.size()!=0) {
			Role role=new Role();
			role=list.get(0);
			return role;
		}
		return null;
	}
	//给用户绑定角色
	public void addUsro(UsRo usRo){
		this.getHibernateTemplate().save(usRo);
	};
}
