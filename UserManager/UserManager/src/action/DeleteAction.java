package action;

import com.opensymphony.xwork2.ActionContext;

import freemarker.template.utility.Execute;
import model.User;
import service.IUserService;

public class DeleteAction {
	private User user;
	private IUserService userService;
	private String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute(){
		String username=ActionContext.getContext().getSession().get("username").toString();
		User u=userService.login(username, password);
		if(u!=null){
			userService.delUsers(u);
			return "success";
		}
		return "fail";
		
		
	}
}
