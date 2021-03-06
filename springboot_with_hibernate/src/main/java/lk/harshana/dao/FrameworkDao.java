package lk.harshana.dao;

import java.lang.reflect.ParameterizedType;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class FrameworkDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private String className = ((Class<?>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getName();;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void persist(T entity) {
		getSession().persist(entity);
	}
	
	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	public boolean update(int id, T entity) {
		T obj = findById(id);
		if(obj == null) {
			return false;
		}
		else {
			getSession().merge(entity);
			return true;
		}
	}
	
	public List<T> listAllEntity() throws HibernateException {
		List<T> list = new ArrayList<T>();
		list = getSession().createQuery("from " +  className ).list();
		return list;
	}
	
	public boolean delete(int id) {
		T entity = findById(id);
		if(entity == null) {
			return false;
		}
		else {
			delete(entity);
			return true;
		}
	}
	
	public T findById(int id) throws HibernateException {
		return (T) getSession().get(className, id);
	}
}
