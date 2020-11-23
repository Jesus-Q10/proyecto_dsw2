package net.spring.proyecto.dao;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import net.spring.proyecto.entity.Region;
@Repository
public class RegionDAOImpl implements RegionDAO{

	@Autowired
	private SessionFactory factory;
	
	@Transactional(readOnly = true)
	@Override
	public List<Region> listRegiones() {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			String hql="select r from Region r";
			query=session.createQuery(hql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
