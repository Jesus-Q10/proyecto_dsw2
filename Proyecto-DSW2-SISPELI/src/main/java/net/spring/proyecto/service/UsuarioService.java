package net.spring.proyecto.service;
import java.util.List;
import net.spring.proyecto.entity.Empleado;
import net.spring.proyecto.entity.Enlace;
import net.spring.proyecto.entity.Usuario;

public interface UsuarioService {
	public Usuario iniciaSesion(String login, String clave);
	public List<Enlace> traerPrivilegios(int rol);
}
