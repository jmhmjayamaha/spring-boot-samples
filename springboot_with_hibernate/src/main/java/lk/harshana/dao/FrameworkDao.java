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
	
	public void update(T entity) {
		getSession().update(entity);
	}
	
	public List<T> listAllEntity() throws HibernateException {
		List<T> list = new ArrayList<T>();
		list = getSession().createQuery("from " +  className ).list();
		return list;
	}
	
	public void delete(String id) {
		
	}
	
	public T findById(int id) throws HibernateException {
		return (T) getSession().get(className, id);
	}
}
