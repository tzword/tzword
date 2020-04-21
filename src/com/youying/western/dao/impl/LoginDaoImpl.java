package com.youying.western.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.youying.western.dao.LoginDao;
import com.youying.western.entity.Menu;
import com.youying.western.entity.Permission;
@Repository
public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao{
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}
	//查询菜单
	@SuppressWarnings("unchecked")
	public List<Menu> searchMenu(){
		String hql="from Menu";
		return this.getHibernateTemplate().find(hql);
	}
	//根据用户名查询所具有的角色
	public List<Map<String, Object>> getRoleByname(String name){
		String sql="select c.id,c.name from t_user a left join t_us_ro b on a.id=b.user_id left join t_role c on b.role_id=c.id where a.name='"+name+"'";
		Query query=this.getSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list =query.list();
		return list;
	};
	//根据角色ID查询权限
	public List<Permission> searchPerByRoleId(Integer roleId){
		String sql="select c.id,c.name,c.url,c.menu_id from t_role a,t_ro_per b,t_permission c " +
				"where a.id=b.role_id and b.permission_id=c.id";
		if (roleId!=null&&roleId!=0) {
			sql+=" and a.id="+roleId+"";
		}
		Query query= this.getSession().createSQLQuery(sql).addEntity(Permission.class);
		@SuppressWarnings("unchecked")
		List<Permission> list =query.list();
		return list;
	};
	//根据角色ID查询菜单
	public List<Menu> searchMenuByRoleId(Integer roleId){
		String sql="select distinct d.id,d.name from t_role a,t_ro_per b,t_permission c,t_menu d where a.id=b.role_id AND " +
				" b.permission_id=c.id and c.menu_id=d.id";
		if (roleId!=null&&roleId!=0) {
			sql+=" and a.id="+roleId+"";
		}
		Query query= this.getSession().createSQLQuery(sql).addEntity(Menu.class);
		@SuppressWarnings("unchecked")
		List<Menu> list =query.list();
		return list;
	}
}
