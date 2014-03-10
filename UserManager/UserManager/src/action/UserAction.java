package action;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.opensymphony.xwork2.ActionContext;

import model.User;
import service.IUserService;

public class UserAction {
	private User user;
	private IUserService userService;
	private List<User> users;
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
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
	public String execute(){
		System.out.println("µ÷ÓÃexecute");
		users=userService.findAll();
		if(users==null){
			return "fail";
		}else{
			System.out.println(users.isEmpty());
			
			return "success";
		}
		
		
	}
	
}
