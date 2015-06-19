package net.totome.iot.web.rms.bizImpl;

import java.util.List;

import net.totome.iot.web.rms.biz.UserBiz;
import net.totome.iot.web.rms.dao.UserDao;
import net.totome.iot.web.rms.model.Users;
import net.totome.iot.web.rms.util.Page;


public class UserBizImpl implements UserBiz {
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Users Login(Users user) {
		// TODO Auto-generated method stub
		return userDao.Login(user);
	}

	public List<Users> getList(Users user, int index) {
		// TODO Auto-generated method stub
		return userDao.getList(user, index);
	}

	public Integer getObject() {
		return userDao.getObject();
	}

	public Users FindById(Integer id) {
		return userDao.FindById(id);
	}

	public void Save(Users user) {
		// TODO Auto-generated method stub
		userDao.Save(user);
	}

	public void Upadate(Users user) {
		// TODO Auto-generated method stub
		userDao.Upadate(user);
	}

	public void Delete(Users user) {
		// TODO Auto-generated method stub
		userDao.Delete(user);

	}

	public List<Users> CheckObject(String object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Users> FindList(Users user,Integer pageIndex, Integer pageSize) {
		return userDao.FindList(user,pageIndex, pageSize);
	}

	public Integer CheckEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.CheckEmail(email);
	}
	
	public Users FindByEmail(String email){
		return userDao.FindByEmail(email);
	}

	public void UpdatePassByEmail(Users user) {
		// TODO Auto-generated method stub
		userDao.UpdatePassByEmail(user);
	}

}
