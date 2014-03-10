package action;

import com.opensymphony.xwork2.ActionContext;

import model.User;
import service.IUserService;

public class UserInfoAction {
	private User user;
	private IUserService userService;
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
	public String execute(){
		String username=ActionContext.getContext().getSession().get("username").toString();
		User u=userService.userInfo(username);
		if(u!=null){
			String phone=u.getPhone().toString();
			String sex=u.getSex().toString();
			// System.out.println(phone);
			// System.out.println(sex);
			ActionContext.getContext().getSession().put("phone", phone);
			ActionContext.getContext().getSession().put("sex", sex);
			return "success";
		}
		return "fail";
		
	}
}
