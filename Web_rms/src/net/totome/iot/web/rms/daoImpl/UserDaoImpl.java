package net.totome.iot.web.rms.daoImpl;

import java.util.ArrayList;
import java.util.List;

import net.totome.iot.web.rms.dao.BaseDao;
import net.totome.iot.web.rms.dao.UserDao;
import net.totome.iot.web.rms.model.Users;
import net.totome.iot.web.rms.util.MD5Util;
import net.totome.iot.web.rms.util.Page;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("unchecked")
public class UserDaoImpl extends BaseDao implements UserDao {

	public Users Login(Users user) {
		StringBuilder sb = new StringBuilder();
		sb.append("From Users where loginName='");
		sb.append(user.getLoginName());
		sb.append("' And password='");
		sb.append(MD5Util.EncryptionMD5(user.getPassword()));
		sb.append("' ");

		return (Users) super.Login(user, sb.toString());

		/*
		 * List<Admin>adminList=new ArrayList<Admin>(); if(adminList.size()!=0){
		 * return adminList.get(0); }else{ return null; }
		 */
	}

	public List<Users> getList(Users user, int index) {
		StringBuilder sb = new StringBuilder();
		sb.append("From Users Where 1=1");
		List<Users> object = super.getList(index, sb.toString());
		return object;
	}

	public Users FindById(Integer id) {
		return (Users) super.FindById(Users.class, id);
	}

	public void Save(Users user) {
		super.Save(user);
	}

	public void Upadate(Users user) {
		super.Update(user);
	}

	public void Delete(Users user) {
		super.Delete(user);
	}

	public Integer getObject() {
		String hql = "Select Count(*) From Users";
		Long s = (Long) super.getCount(hql);
		return s.intValue();
	}

	public List<Users> CheckObject(String object) {
		StringBuilder sb = new StringBuilder();
		sb.append("From Users where mobile='");
		if (StringUtils.isNotBlank(object)) {
			sb.append(object);
			sb.append("'");
		}
		List<Object> objects = super.FindByObject(sb.toString());
		List<Users> users = new ArrayList<Users>();

		/*if(objects==null||objects.size()<=0){
			return null;
		}*/
		for (int i = 0; i < objects.size(); i++) {
			Users user = (Users) objects.get(i);
			users.add(user);
		}
		return users;
	}

	public Page<Users> FindList(Users user,Integer pageIndex, Integer pageSize) {
		String hql="Select count(*) From Users";
		String selectHql="From Users where 1=1";
		
		List<Users>userList=super.FindList(selectHql, pageIndex, pageSize);
		
		Long s=(Long)super.getCount(hql);
		int count=s.intValue();
		
		
		Page<Users> page= new Page<Users>(pageIndex, pageSize);
		page.setList(userList);
		page.setCount(count);
		return page;
	}

	/**
	 * 查找邮箱返回数量
	 */
	public Integer CheckEmail(String email) {
		StringBuilder sb=new StringBuilder();
		sb.append("Select count(*) From Users where email='");
		if(StringUtils.isNotBlank(email)){
			sb.append(email);
		}
		sb.append("'");
		Long s=(Long) super.getCount(sb.toString());
		return s.intValue();
	}
	
	/**
	 * 根据邮箱查看返回一个对象
	 */
	public Users FindByEmail(String email) {
		String hql = "From Users where email =?";
		return (Users) super.get(hql, new Object[]{email});
	}

	
	/**
	 * 修改密码
	 */
	public void UpdatePassByEmail(Users user) {
		super.Update(user);
		
	}
	
	

}
