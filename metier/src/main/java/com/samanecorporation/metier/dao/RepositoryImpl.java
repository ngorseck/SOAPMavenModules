package com.samanecorporation.metier.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;

import com.samanecorporation.metier.config.HibernateUtil;

public class RepositoryImpl<T> implements Repository<T> {
	
	private final Session session = HibernateUtil.getSessionFactory().openSession();
	
	@Override
	@Transactional
	public boolean save(T t) {
		try {
			session.getTransaction().begin();
			session.save(t);
			session.getTransaction().commit();
			return true;
		} catch (Exception e2) {
			return false;
		}
	}

	@Override
	public boolean delete(long id,T t) {
				
		try {
			session.getTransaction().begin();
			session.delete(session.get(t.getClass(), id));
			session.getTransaction().commit();
			return true;
		} catch (Exception e2) {
			return false;
		}
	}

	@Override
	public boolean update(T t) {
		try {
			session.getTransaction().begin();
			session.merge(t);
			session.getTransaction().commit();
			return true;
		} catch (Exception e2) {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(T t) {
		
       CriteriaBuilder cb = session.getCriteriaBuilder();
      
       CriteriaQuery<T> cq = (CriteriaQuery<T>) cb.createQuery(t.getClass());
       Root<T> root = (Root<T>) cq.from(t.getClass());
       							cq.select(root);
              
       return session.createQuery(cq).getResultList();
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get (int id,T t) {
		
        return (T) session.get(t.getClass(), id);
	}

	
}