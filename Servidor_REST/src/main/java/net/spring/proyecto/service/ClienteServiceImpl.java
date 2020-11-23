package net.spring.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.proyecto.dao.ClienteDAO;
import net.spring.proyecto.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Override
	public void save(Cliente bean) {
		clienteDAO.save(bean);
	}
	
	@Override
	public void update(Cliente bean) {
		clienteDAO.update(bean);
	}
	@Override
	public void delete(int id) {
		clienteDAO.delete(id);
		
	}

	@Override
	public Cliente findId(int id) {
		return clienteDAO.findId(id);
	}

	@Override
	public List<Cliente> listAll() {
		return clienteDAO.listAll();
	}


	

}
