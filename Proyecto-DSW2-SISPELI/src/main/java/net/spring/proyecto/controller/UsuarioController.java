package net.spring.proyecto.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.spring.proyecto.entity.Enlace;
import net.spring.proyecto.entity.Usuario;
import net.spring.proyecto.service.UsuarioService;

@Controller
@RequestMapping(value = "/session")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/")
	public String index() {
		return "session";
	}
	@RequestMapping(value = "/iniciar")
	public String iniciar(@RequestParam("login") String vlogin,
						  @RequestParam("clave") String vclave,
						  RedirectAttributes redirectAtt, HttpServletRequest request) {
		//invocar a iniciaSesion
		Usuario bean=usuarioService.iniciaSesion(vlogin, vclave);
		//validar
		if(bean==null){
			redirectAtt.addFlashAttribute("MENSAJE","Usuario y/o Clave incorrectos");
			return "redirect:/session/";
		}
		else {
			//obtener rol del usuario actual
			int idRol;
			idRol=bean.getRol().getIdrol();
			//traer los enlaces
			List<Enlace> lista=usuarioService.traerPrivilegios(idRol);
			//crear sesiòn
			HttpSession session=request.getSession();
			//atributos de tipo sesiòn
			session.setAttribute("enlaces",lista);
			session.setAttribute("datos","Bienvenido: " + bean.getEmpleado().getApellidos()+" "+bean.getEmpleado().getNombres());
			return "menu";
		}
		
		
	}
	@RequestMapping(value = "/cerrar")
	public String cerrar(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:/session/";
	}
	
	
	
}
