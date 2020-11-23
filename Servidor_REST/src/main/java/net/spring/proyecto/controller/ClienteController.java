package net.spring.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.spring.proyecto.entity.Cliente;
import net.spring.proyecto.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	
	@GetMapping(path ="/listAllCliente" )
	@ResponseBody
	public List<Cliente> listAllCliente(){
		return clienteService.listAll();
	}

	
		
	@GetMapping(path ="/findCliente/{idcliente}" )
	@ResponseBody
	public Cliente findCliente(@PathVariable("idcliente") int id) {
		return clienteService.findId(id);
	}

	
		@PostMapping(path = "/saveCliente")
		public void saveCliente(@RequestBody Cliente bean) {
			clienteService.save(bean);		
		}
	
		
		@PutMapping(path = "/updateCliente")
		public void updateCliente(@RequestBody Cliente bean) {
			clienteService.update(bean);		
		}	
	
		
		@DeleteMapping(path = "/deleteCliente/{idcliente}")
		public void deleteCliente(@PathVariable("idcliente") int id) {
			clienteService.delete(id);
		}


}
