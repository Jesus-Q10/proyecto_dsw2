package net.spring.proyecto.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.proyecto.dao.UsuarioDAO;
import net.spring.proyecto.entity.Enlace;
import net.spring.proyecto.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario iniciaSesion(String login, String clave) {
		// TODO Auto-generated method stub
		return usuarioDAO.iniciaSesion(login, clave);
	}

	@Override
	public List<Enlace> traerPrivilegios(int rol) {
		// TODO Auto-generated method stub
		return usuarioDAO.traerPrivilegios(rol);
	}

}
