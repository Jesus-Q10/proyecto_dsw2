package net.spring.proyecto.controller;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import net.spring.proyecto.entity.Cliente;
@Controller
@RequestMapping(value = "/mantenimientoCliente")
public class ClienteController {
	private String URL="http://localhost:8080/WS_Servidor_REST/cliente";

		
	@RequestMapping(value = "/")
	public String principal(Model model) {
		try {
			RestTemplate rt=new RestTemplate();
			ResponseEntity<Cliente[]> response=rt.getForEntity(URL+"/listAllCliente", Cliente[].class);
			Cliente[] lista=response.getBody();
			model.addAttribute("dataClientes",lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Mancliente";
	}

	@RequestMapping(value = "/buscarCliente")
	@ResponseBody
	public Cliente buscarCliente(@RequestParam("idcliente") int id) {
		Cliente bean=null;
		try {
			RestTemplate rt=new RestTemplate();
			ResponseEntity<Cliente> response=rt.getForEntity(URL+"/findCliente/"+id,
					Cliente.class);
			bean=response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}	

	
	@RequestMapping(value = "/save")
	public String save(@RequestParam("idcliente") int id,
								@RequestParam("dni") int dni,
								@RequestParam("nombre") String nom,
								@RequestParam("apellido") String ape,
								@RequestParam("correo") String cor,
								@RequestParam("password") String pas,
								@RequestParam("celular") int cel,
								  RedirectAttributes model) {
		try {
			Cliente bean=new Cliente();
			bean.setIdcliente(id);
			bean.setDni(dni);
			bean.setNombre(nom);
			bean.setApellido(ape);
			bean.setCorreo(cor);
			bean.setPassword(pas);
			bean.setCelular(cel);
			Gson gson=new Gson();
			String json=gson.toJson(bean);
			RestTemplate rt=new RestTemplate();
			if(id==0) {
				HttpHeaders header=new HttpHeaders();
				header.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<String> request=new HttpEntity<String>(json,header);
				rt.postForObject(URL+"/saveCliente", request, String.class);
				model.addFlashAttribute("MENSAJE","Registro Exitoso!!");
			}
			else {
				HttpHeaders header=new HttpHeaders();
				header.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<String> request=new HttpEntity<String>(json,header);
				rt.put(URL+"/updateCliente", request, String.class);
				model.addFlashAttribute("MENSAJE","Actualización Exitosa!!");
								
			}		
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/mantenimientoCliente/";
	}
		
	
	
	

	

}
