package dao;

import java.util.List;

import model.User;

public interface IUserDAO {

	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String SEX = "sex";
	public static final String PHONE = "phone";

	public abstract void save(User transientInstance);

	public abstract void delete(User persistentInstance);

	public abstract User findById(java.lang.Integer id);

	public abstract List findByExample(User instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUsername(Object username);

	public abstract List findByPassword(Object password);

	public abstract List findBySex(Object sex);

	public abstract List findByPhone(Object phone);

	public abstract List findAll();

	public abstract User merge(User detachedInstance);

	public abstract void attachDirty(User instance);

	public abstract void attachClean(User instance);

}