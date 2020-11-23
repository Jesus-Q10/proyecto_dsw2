package net.spring.proyecto.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.proyecto.entity.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO{

	@Autowired
	private SessionFactory factory;

	@Transactional
	@Override
	public void save(Cliente bean) {
		Session session=factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	@Override
	public void update(Cliente bean) {
		Session session=factory.getCurrentSession();
		try {
			session.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Transactional
	@Override
	public void delete(int id) {
		Session session=factory.getCurrentSession();
		try {
			Cliente bean=session.get(Cliente.class, id);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(readOnly = true)
	@Override
	public Cliente findId(int id) {
		Cliente bean=null;
		Session session=factory.getCurrentSession();
		try {
			bean=session.get(Cliente.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> listAll() {
		List<Cliente> lista=null;
		Query query=null;
		Session session=factory.getCurrentSession();
		try {
			String hql="select c from Cliente c";
			query=session.createQuery(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	
}
