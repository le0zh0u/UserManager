package action;

import com.opensymphony.xwork2.ActionContext;

import model.User;
import service.IUserService;

public class UpdateAction {
	private User user;
	private IUserService userService;

	private String old_pass;
	private String new_pass1;
	private String new_pass2;
	private String sex;
	private String phone;
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOld_pass() {
		return old_pass;
	}

	public void setOld_pass(String old_pass) {
		this.old_pass = old_pass;
	}

	public String getNew_pass1() {
		return new_pass1;
	}

	public void setNew_pass1(String new_pass1) {
		this.new_pass1 = new_pass1;
	}

	public String getNew_pass2() {
		return new_pass2;
	}

	public void setNew_pass2(String new_pass2) {
		this.new_pass2 = new_pass2;
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

	public String UpdateElse() {
		String username = ActionContext.getContext().getSession()
				.get("username").toString();
		User u = userService.userInfo(username);
		if (u != null) {
			if(!sex.equals("")){
				u.setSex(sex);
				ActionContext.getContext().getSession().put("sex", sex);
			}
			if(!phone.equals("")){
				u.setPhone(phone);
				ActionContext.getContext().getSession().put("phone", phone);
			}
			
			userService.updateUsers(u);
			return "success";
		}
		return "fail";

	}

	public String UpdatePassword() {
		String username = ActionContext.getContext().getSession()
				.get("username").toString();
		User u = userService.userInfo(username);

			if (u != null) {
				if (u.getPassword().equals(old_pass))
				{
					if(new_pass1.equals(new_pass2)){
						u.setPassword(new_pass1);
						userService.updateUsers(u);
						return "success";
					}
				}
				
			}
		return "fail";

	}

}
