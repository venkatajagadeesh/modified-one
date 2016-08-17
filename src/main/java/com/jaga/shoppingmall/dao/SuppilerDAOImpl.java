package com.jaga.shoppingmall.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jaga.shoppingmall.model.Suppiler;

@Repository(value="suppilerDAO")
@SuppressWarnings("deprecation")
public class SuppilerDAOImpl implements SuppilerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public SuppilerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean save(Suppiler suppiler){
		try {
			sessionFactory.getCurrentSession().save(suppiler);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean update(Suppiler suppiler){
		try {
			sessionFactory.getCurrentSession().update(suppiler);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(Suppiler suppiler){
		try {
			sessionFactory.getCurrentSession().delete(suppiler);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Suppiler get(String id){
		
		String hql = "from Supplier where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Suppiler>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  List<Suppiler> list(){
		
		String hql ="from Suppiler";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
	}
		
	
}
