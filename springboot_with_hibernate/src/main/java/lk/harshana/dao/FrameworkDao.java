package lk.harshana.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class FrameworkDao<PK extends Serializable, T> {

	@Autowired
	private SessionFactory sessionFactory;
	
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
	
	public List<T> listAllEntity(String entity) {
		
		
		/*getSession().createQuery("from " + entity).list();*/
		return null;
	}
	
	public abstract void delete(String id);
}
