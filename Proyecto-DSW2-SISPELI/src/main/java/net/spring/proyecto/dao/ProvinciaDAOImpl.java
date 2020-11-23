package net.spring.proyecto.dao;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.proyecto.entity.Provincia;

@Repository
public class ProvinciaDAOImpl implements ProvinciaDAO{
	@Autowired
	private SessionFactory factory;

	@Transactional(readOnly = true)
	@Override
	public List<Provincia> listProvinciaAtRegion(int idRegion) {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			String hql="select p from Provincia p where p.region.idRegion=?1";
			query=session.createQuery(hql);
			query.setParameter(1, idRegion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
	
}
