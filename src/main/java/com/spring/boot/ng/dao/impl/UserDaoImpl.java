package com.spring.boot.ng.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.ng.dao.UserDao;
import com.spring.boot.ng.model.User;

@Repository
public class UserDaoImpl implements UserDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User data) {
		Session session = sessionFactory.getCurrentSession();
		session.save(data);
		session.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> getUsers() throws Exception {
		String queryString = "From User";
		Session session;
		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(queryString);
		return query.list();
	}
	
}
