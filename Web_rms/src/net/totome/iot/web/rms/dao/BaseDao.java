package net.totome.iot.web.rms.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import net.totome.iot.web.rms.model.Users;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


@SuppressWarnings("unchecked")
public class BaseDao extends HibernateDaoSupport {

	/**
	 * 登陆方法
	 */
	public Object Login(Object entity, String hql) {
		List<Object> objects = this.getHibernateTemplate().find(hql);
		if (objects.size() > 0) {
			return objects.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 保存方法
	 * @param entity
	 */
	public void Save(Object entity) {
		this.getHibernateTemplate().save(entity);
	}

	/**
	 * 删除方法
	 * @param entity
	 */
	public void Delete(Object entity) {

		this.getHibernateTemplate().delete(entity);

	}

	/**
	 * 修改方法
	 * @param entity
	 */
	public void Update(Object entity) {
		/*this.getHibernateTemplate().update(entity);*/
		this.getHibernateTemplate().merge(entity);
	}
	
	public void update(Object entity) {
		/*this.getHibernateTemplate().update(entity);*/
		this.getHibernateTemplate().update(entity);
	}

	/**
	 * 根据ID查找返回对象方法
	 * @param id
	 * @return
	 */
	public Object FindById(Class<?> clazz , Serializable id) {
		Object object = this.getHibernateTemplate().get(clazz, id);
		return object;
	}
	

	/**
	 * 查询返回得到整数方法
	 * @param hql
	 * @return
	 */
	public Object getCount(String hql) {
		List<Object> object = this.getHibernateTemplate().find(hql);
		Long obj = (Long) object.get(0);
		return obj;
	}
	
	/**
	 * 查询集合不分页方法
	 * @return
	 */
	public List<Object>getList(String hql){
		List<Object>objects=this.getHibernateTemplate().find(hql);
		return objects;
	}

	
	/**
	 * 查询集合分页方法
	 * @param index
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List  getList(int index, String hql) {
		final int limit = 10;

		final int start = (index - 1) * limit;

		final String bhql = hql;

		List<Object> list = null;

		list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List result = session.createQuery(bhql).setFirstResult(start)
						.setMaxResults(limit).list();
				/*if(session!=null){
					session.close();
				}*/
				return result;
			}

		});
		return list;
	}
	
	/**
	 * 查询某个字段属性
	 * @return
	 */
	public List<Object> FindByObject(String hql){
		List<Object>objects=this.getHibernateTemplate().find(hql);
		return objects;
	}
	
	
	public List  FindList(final String bhql,int pageIndex,int pageSize) {
		final int limit = pageSize;

		final int start = (pageIndex - 1) * limit;

		/*final String bhql = hql;*/

		List<Object> list = null;

		list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List result = session.createQuery(bhql).setFirstResult(start)
						.setMaxResults(limit).list();
				/*if(session!=null){
					session.close();
				}*/
				return result;
			}

		});
		return list;
	}
	
	
	public Object FindObject(final String hql){
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query=session.createQuery(hql);
				Object obj=query.uniqueResult();
				return obj;
			}
		});
	}
	
	
	/**
	 * 获得一个对象
	 * @param hql
	 * @param param
	 * @return
	 */
	public Object get(String hql, Object[] param){
		List<Object> objects = this.getHibernateTemplate().find(hql, param);  
        if (objects != null && objects.size() > 0) {  
            return objects.get(0);  
        } else {  
            return null;  
        }
	}
	/**
	 * 返回一个对象
	 * @param hql
	 * @param param
	 * @return
	 */
	public Object get(String hql, List<Object> param){
		List<Object> objects = this.getHibernateTemplate().find(hql, param);
        if (objects != null && objects.size() > 0) {  
            return objects.get(0);  
        } else {  
            return null;  
        }  
		
	}

}
