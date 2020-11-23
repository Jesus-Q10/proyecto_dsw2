package net.spring.proyecto.dao;
import java.util.List;
import net.spring.proyecto.entity.Empleado;
import net.spring.proyecto.entity.Enlace;
import net.spring.proyecto.entity.Usuario;

public interface UsuarioDAO {
	public Usuario iniciaSesion(String login, String clave);
	public List<Enlace> traerPrivilegios(int rol);
}
