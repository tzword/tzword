package com.youying.western.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.youying.western.dao.UserDao;
import com.youying.western.entity.User;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	// 添加用户
	public void addUser(User user) {
		this.getHibernateTemplate().save(user);
	}
	// 修改用户
	public void updUser(User user) {
		this.getHibernateTemplate().update(user);
	}
	//查询用户
	@SuppressWarnings("unchecked")
	public List<User> searchUser(){
		String hql="from User";
		return this.getHibernateTemplate().find(hql);
	}
	//根据用户名得到用户
	@SuppressWarnings("unchecked")
	public User queryByName(String name){
		String hql="from User where name='"+name+"'";
		List<User> list = this.getHibernateTemplate().find(hql);
		if (list!=null&&list.size()!=0) {
			User user =new User();
			user=list.get(0);
			return user;
		}
		return null;
	}
	//根据ID得到用户
	@SuppressWarnings("unchecked")
	public User queryByID(String id){
		String hql="from User where id="+id;
		List<User> list = this.getHibernateTemplate().find(hql);
		if (list!=null&&list.size()!=0) {
			User user =new User();
			user=list.get(0);
			return user;
		}
		return null;
	}
}
