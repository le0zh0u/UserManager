package service;

import java.util.List;

import model.User;
import dao.IUserDAO;

public class UserService implements IUserService {
	private IUserDAO userDao = null;

	public IUserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	public List<User> findAll() {

		return userDao.findAll();
	}

	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUsers(User u) {
		// TODO Auto-generated method stub
		userDao.save(u);
	}

	public void delUsers(User u) {
		// TODO Auto-generated method stub
		try {
			userDao.delete(u);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateUsers(User u) {
		// TODO Auto-generated method stub
		userDao.attachDirty(u);
	}

	public User login(String uname, String upass) {
		// TODO Auto-generated method stub
		List users = userDao.findByUsername(uname);
		if (users.size() > 0) {
			for (int i = 0; i < users.size(); i++) {
				User u = (User) users.get(i);
				if (u.getPassword().equals(upass)) {
					return u;
				}
			}
		}
		return null;
	}

	public boolean CheckRegist(String uname) {
		// TODO Auto-generated method stub
		List users = userDao.findByUsername(uname);
		if (users.size() > 0) {
			return true;
		}
		return false;
	}

	public User userInfo(String uname) {
		// TODO Auto-generated method stub
		List users = userDao.findByUsername(uname);
		if (users.size() > 0) {
			for (int i = 0; i < users.size(); i++) {
				User u = (User) users.get(i);
				return u;
			}
		}

		return null;
	}

}
