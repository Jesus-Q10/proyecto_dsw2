package net.spring.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.spring.proyecto.entity.Distrito;
import net.spring.proyecto.service.DistritoService;

@Controller
@RequestMapping(value = "/distrito")
public class DistritoController {
	
	@Autowired
	private DistritoService distritoService;
	
	
	/*Action(value="/lista",results={@Result(name="ok",type="json")})
	  //
	   public String lista(){
	  
	  		return "ok";
	  }
	*/
	
	@RequestMapping(value = "/lista")
	public String lista() {
		List<Distrito> lista=distritoService.listAll();
		for(Distrito bean:lista)
			System.out.println(bean.getIdDistrito()+"---"+bean.getNombreDistrito()+"---");
		return "";
	}
	@RequestMapping(value = "/registrar")
	public String registrar() {
		Distrito bean=new Distrito();	
		bean.setIdDistrito(2000);
		bean.setNombreDistrito("Prueba");
		//bean.setIdProvincia(193);
		distritoService.save(bean);
		return "";
	}
	@RequestMapping(value = "/actualizar")
	public String actualizar() {
		Distrito bean=new Distrito();	
		bean.setIdDistrito(2000);
		bean.setNombreDistrito("actualizar");
		//bean.setIdProvincia(192);
		distritoService.update(bean);
		return "";
	}
	@RequestMapping(value = "/eliminar")
	public String eliminar() {
		
		distritoService.delete(2000);
		return "";
	}
	@RequestMapping(value = "/buscar")
	public String buscar() {
		Distrito bean=distritoService.find(1831);
		System.out.println(bean.getIdDistrito()+"---"+bean.getNombreDistrito()+"---");
		
		return "";
	}
	
}
