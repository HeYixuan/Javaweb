package net.totome.iot.web.rms.dao;

import java.util.List;

import net.totome.iot.web.rms.model.Users;
import net.totome.iot.web.rms.util.Page;

public interface UserDao {

	/**
	 * 登陆方法
	 * @param admin
	 * @return
	 */
	public Users Login(Users user);

	/**
	 * 查询集合分页方法
	 * @param admin
	 * @param index
	 * @return
	 */
	public List<Users> getList(Users user, int index);
	
	/**
	 * 查询返回一个整数方法
	 * @return
	 */
	public Integer getObject();
	
	/**
	 * 根据ID查找返回一个对象方法
	 * @param id
	 * @return
	 */
	public Users FindById(Integer id);

	/**
	 * 保存方法
	 * @param admin
	 */
	public void Save(Users user);

	/**
	 * 修改方法
	 * @param admin
	 */
	public void Upadate(Users user);

	/**
	 * 删除方法
	 * @param admin
	 */
	public void Delete(Users user);
	
	/**
	 * 根据参数查询方法
	 * @param Admin
	 * @return
	 */
	public List<Users>CheckObject(String object);
	
	public Page<Users> FindList(Users user,Integer pageIndex, Integer pageSize);
	
	/**
	 * 检查邮箱
	 * @param email
	 * @return
	 */
	public Integer CheckEmail(String email);
	
	/**
	 * 根据邮箱修改密码
	 * @param Password
	 * @param email
	 * @return
	 */
	public void UpdatePassByEmail(Users user);
	
	public Users FindByEmail(String email);
	
}
