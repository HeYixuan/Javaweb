package net.totome.iot.web.rms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.totome.iot.web.rms.biz.UserBiz;
import net.totome.iot.web.rms.model.Users;
import net.totome.iot.web.rms.util.MD5Util;
import net.totome.iot.web.rms.util.Page;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	HttpServletRequest requerst;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Users user;
	private UserBiz userBiz;
	private String result;
	private String format;
	private String loginName;
	private String sure_password;
	private String new_pass;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNew_pass() {
		return new_pass;
	}
	public void setNew_pass(String new_pass) {
		this.new_pass = new_pass;
	}
	public String getSure_password() {
		return sure_password;
	}
	public void setSure_password(String sure_password) {
		this.sure_password = sure_password;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public HttpServletRequest getRequerst() {
		return requerst;
	}
	public void setRequerst(HttpServletRequest requerst) {
		this.requerst = requerst;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public UserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	private Page<Users> pageList;
	public Page<Users> getPageList() {
		return pageList;
	}
	public void setPageList(Page<Users> pageList) {
		this.pageList = pageList;
	}
	private int pageIndex=1;
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	private int pageSize;
	private int pageCount;
	private int count;
	private String message;
	private String Password;

	
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//登陆
	public String Login(){
		Password=MD5Util.EncryptionMD5(user.getPassword());
		
		if(StringUtils.isNotBlank(Password)){
			Users u=userBiz.Login(user);
			
			if(u!=null){
				ActionContext.getContext().getSession().put("user", u);
				return SUCCESS;
			}else{
				message = "用户不存在";
				return ERROR;
			}
		}
		
		return INPUT;
		
	}
	
	// 查询所有数据
	public String getList() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		/*PrintWriter out = response.getWriter();*/

		
		 HttpServletRequest request = ServletActionContext.getRequest();
		 /*format = request.getParameter("format");*/
		try {
			
			user=(Users) ActionContext.getContext().getSession().get("user");
			Page<Users> pageList = userBiz.FindList(user, pageIndex, 12);
			if (format == null || format.equals("")){
				request.setAttribute("pageList", pageList);
				return "toListJsp";
			}
			String json = JSONObject.fromObject(pageList).toString();// 将数据对象转换成json类型数据
			//输出到浏览器
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//你的问题应该是没有将json扔到前台，想办法扔到前台 
		return null;
	}
	
	
	public String FindById(){
		Users use=(Users) ActionContext.getContext().getSession().get("user");
		id=use.getId();
		user=userBiz.FindById(id);
		if(user!=null){
			return SUCCESS;
		}
		return ERROR;
		
	}
	
	public String UpdateUser() throws IOException{
		//使用Ajax无刷新修改信息
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Users use=(Users) ActionContext.getContext().getSession().get("user");
		message="修改失败";
		Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		String CDate=dateFormat.format(date);
		
		try {
			//得到Session的对象
			
			id=use.getId();
			Users u=null;
			u=userBiz.FindById(id);
			boolean flag = false;
			
			if (u!= null) {
				String Pass=MD5Util.EncryptionMD5(user.getPassword());
				user.setPassword(Pass);
				user.setCDate(CDate);
				userBiz.Upadate(user);
				flag = true;
				
			}
			
			if (flag == true) {
				message = "修改成功";
				return SUCCESS;
			} else {
				message = "修改失败";
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.println(message);
		out.flush();
		out.close();
		return SUCCESS;
		
	}
	
	public String AjaxUpdate() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		try {
			/*user=(Users) ActionContext.getContext().getSession().get("user");*/
			user=userBiz.FindById(id);
			message="修改失败";
			boolean flag = false;
			if(user!=null){
				/*Users u=new Users();*/
				user.setLoginName(loginName);
				userBiz.Upadate(user);
				flag=true;
			}
			
			if (flag == true) {
				message = "修改成功";
				return SUCCESS;
			} else {
				message = "修改失败";
				return INPUT;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		out.println(message);
		out.flush();
		out.close();
		return SUCCESS;
		
	}
	
	public String AjaxRegister() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		message="保存失败";
		if(sure_password!=null){
			String SurePassword=MD5Util.EncryptionMD5(sure_password);
			Password=MD5Util.EncryptionMD5(user.getPassword());
			if(!SurePassword.equals(Password)){
				message="两次密码错误";
			}else{
				Date date=new Date();
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String newDate=dateFormat.format(date);
				loginName=user.getLoginName();
				user.setLoginName(loginName);
				user.setPassword(Password);
				user.setCDate(newDate);
				userBiz.Save(user);
				message="注册成功";
			}
		}else{
			message="注册失败";
		}
		out.print(message);
		out.flush();
		out.close();
		return SUCCESS;
	}
	
	public String UpdatePass() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		message = "修改失败";
		System.out.println(">>>>>>>>>>>>>>>>>" + user);
		Users user = (Users) ActionContext.getContext().getSession()
				.get("user");
		/* Users u = new Users(); */
		try {
			if (user != null) {

				String SessionUserPass = user.getPassword();// 这里的Session取的user.password
				String Pass = MD5Util.EncryptionMD5(Password);
				// 如果前台输入的密码和从Session取出来的Pass不一致操作
				String NewPass=MD5Util.EncryptionMD5(new_pass);
				String SurePass=MD5Util.EncryptionMD5(sure_password);
				if (!Pass.equals(SessionUserPass)) {
					message = "原密码错误";
				}
				else if (NewPass.equals(Pass)) {
					// 新密码如果和原密码相同的操作
					message = "新密码不能与原密码相同";
				}
				else if (SurePass.equals(NewPass)) {
					user.setPassword(SurePass);
					userBiz.Upadate(user);
					message = "修改成功";
				}else{
					message = "修改失败";
				}

			} else {
				message = "修改失败";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		out.print(message);
		out.flush();
		out.close();
		return SUCCESS;
	}
	
	public String checkEmail() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		message = "邮箱不存在";
		if(StringUtils.isNotBlank(email)){
			Integer count=userBiz.CheckEmail(email);
			if(count<=0){
				message="邮箱不存在";
			}else{
				message="";
			}
		}
		
		out.print(message);
		out.flush();
		out.close();
		
		return SUCCESS;
		
	}
	
	public String UpdatePassByEmail() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		message = "修改失败";
		boolean falg=false;
		
		if(StringUtils.isNotBlank(email)){
			if(StringUtils.isNotBlank(Password)){
				if(StringUtils.isNotBlank(sure_password)){
					if(!sure_password.equals(Password)){
						falg=false;
						message="密码不一致";
					}else{
						
						Users u=userBiz.FindByEmail(email);
						u.setPassword(MD5Util.EncryptionMD5(sure_password));
						userBiz.UpdatePassByEmail(u);
						falg=true;
						if(falg==true){
							message="修改成功";
						}else{
							message="修改失败";
						}
					}
				}
			}
		}
		out.print(message);
		out.flush();
		out.close();
		return SUCCESS;
		
	}
}
