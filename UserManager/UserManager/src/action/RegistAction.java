package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.User;
import service.IUserService;

public class RegistAction extends ActionSupport{
	private User user;
	private IUserService userService;
	private String password2;
	private String error="";
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
//	@Override
//	public void validate() {
//		// TODO Auto-generated method stub
//		super.validate();
//		System.out.println("validate");
//		
//			
//		}
	
	public String execute(){
		if(userService.CheckRegist(user.getUsername().toString())){
//			addFieldError("user.username", "对不起，用户名已存在");
			error = getText("用户名已存在");
			System.out.println("用户名重复");
			return "input";

		}
		if(!user.getPassword().equals(password2)){
//			addFieldError("password2", "两次密码不一致");
			System.out.println("密码不一致");
			error = getText("密码不一致");
			return "input";
		}
		userService.addUsers(user);
		ActionContext.getContext().getSession().put("username", user.getUsername());
		
		return "success";
		
	}
}
