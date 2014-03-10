package action;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.User;
import service.IUserService;

public class LoginAction extends ActionSupport {
	private User user;
	private IUserService userService;
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
		// if ("".equals(user.getUsername())) {
		// this.addFieldError("user.username", "�Բ����û�������Ϊ��");
		// }
		// if ("".equals(user.getPassword())) {
		// this.addFieldError("user.password", "�Բ������벻����Ϊ��");
		// }
		if (user.getUsername().equals("") || user.getPassword().equals("")) {
		}

	}

	public String execute() {
		if (userService.login(user.getUsername(), user.getPassword()) == null) {
			error=getText("�û������������");
			return "false";

		}
		// HttpSession session = null;
		// session.setAttribute("username", user.getUsername());
		ActionContext.getContext().getSession()
				.put("username", user.getUsername());
		// ActionContext.getContext().getSession().put("userid", user.getId());

		return "success";
	}
}
