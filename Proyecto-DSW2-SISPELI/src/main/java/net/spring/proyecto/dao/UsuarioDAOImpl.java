package net.spring.proyecto.dao;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import net.spring.proyecto.entity.Empleado;
import net.spring.proyecto.entity.Enlace;
import net.spring.proyecto.entity.Usuario;
@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
	@Autowired
	private SessionFactory factory;
	
	@Transactional(readOnly=true)
	@Override
	public Usuario iniciaSesion(String login, String clave) {
		Session session=factory.getCurrentSession();
		Usuario empleado=null;
		Query query=null;
		try {
			query=session.createQuery("select u from Usuario u where u.login=?1 and u.password=?2");
			query.setParameter(1, login);
			query.setParameter(2, clave);
			List<Empleado> o=query.getResultList();
			if(!o.isEmpty())
				empleado=(Usuario) query.getSingleResult();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empleado;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Enlace> traerPrivilegios(int rol) {
		Session session=factory.getCurrentSession();
		Query query=null;
		List<Enlace> lista=null;
		try {
			String hql="SELECT e from RolEnlace re join re.enlace e join re.rol r "+
					"where re.rol.idrol=?1";
			query=session.createQuery(hql);
			query.setParameter(1, rol);
			lista=query.getResultList();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
