package net.spring.proyecto.dao;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.proyecto.entity.Distrito;

@Repository
public class DistritoDAOImpl implements DistritoDAO{
	
	@Autowired
	private SessionFactory factory;
	
	
	@Transactional
	@Override
	public void save(Distrito bean) {
		Session session=factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Transactional
	@Override
	public void update(Distrito bean) {
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
			//buscar
			Distrito bean=session.get(Distrito.class, id);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Distrito> listAll() {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			//String sql="select *from tb_distrito";
			String hql="select d from Distrito d";
			query=session.createQuery(hql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Distrito find(int id) {
		Session session=factory.getCurrentSession();
		Distrito bean=null;
		try {
			bean=session.get(Distrito.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Distrito> listDistritosAtProvincia(int idProv) {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			String hql="select d from Distrito d where d.provincia.idProvincia=?1";
			query=session.createQuery(hql);
			query.setParameter(1, idProv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
