package service;

import java.util.List;

import model.User;

public interface IUserService {
	public List<User> findAll();
	public User findById(Integer id);
	public void addUsers(User u);
	public void delUsers(User u);
	public void updateUsers(User u);
	public User login(String uname,String upass);
	public boolean CheckRegist(String uname);
	public User userInfo(String uname);


}
