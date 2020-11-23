package net.spring.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.proyecto.dao.DistritoDAO;
import net.spring.proyecto.entity.Distrito;

@Service
public class DistritoServiceImpl implements DistritoService{
	
	@Autowired
	private DistritoDAO distritoDAO;
	
	@Override
	public void save(Distrito bean) {
		distritoDAO.save(bean);
		
	}

	@Override
	public void update(Distrito bean) {
		distritoDAO.update(bean);
		
	}

	@Override
	public void delete(int id) {
		distritoDAO.delete(id);
		
	}

	@Override
	public List<Distrito> listAll() {
		// TODO Auto-generated method stub
		return distritoDAO.listAll();
	}

	@Override
	public Distrito find(int id) {
		// TODO Auto-generated method stub
		return distritoDAO.find(id);
	}

	@Override
	public List<Distrito> listDistritosAtProvincia(int idProv) {
		// TODO Auto-generated method stub
		return distritoDAO.listDistritosAtProvincia(idProv);
	}

}
