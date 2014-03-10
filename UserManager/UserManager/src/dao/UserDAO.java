package dao;

import java.util.List;

import model.User;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see model.User
 * @author MyEclipse Persistence Tools
 */

public class UserDAO extends HibernateDaoSupport implements IUserDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#save(model.User)
	 */
	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#delete(model.User)
	 */
	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findById(java.lang.Integer)
	 */
	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getHibernateTemplate().get("model.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByExample(model.User)
	 */
	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByUsername(java.lang.Object)
	 */
	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByPassword(java.lang.Object)
	 */
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findBySex(java.lang.Object)
	 */
	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findByPhone(java.lang.Object)
	 */
	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#merge(model.User)
	 */
	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#attachDirty(model.User)
	 */
	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IUserDAO#attachClean(model.User)
	 */
	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IUserDAO) ctx.getBean("UserDAO");
	}
}