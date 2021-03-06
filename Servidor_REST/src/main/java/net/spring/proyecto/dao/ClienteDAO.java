package net.spring.proyecto.dao;

import java.util.List;

import net.spring.proyecto.entity.Cliente;

public interface ClienteDAO {
	
	public void save(Cliente bean);
	public void update(Cliente bean);
	public void delete(int id);
	public Cliente findId(int id);
	public List<Cliente> listAll();

}
