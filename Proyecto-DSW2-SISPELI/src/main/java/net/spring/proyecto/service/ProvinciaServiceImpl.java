package net.spring.proyecto.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.proyecto.dao.ProvinciaDAO;
import net.spring.proyecto.entity.Provincia;

@Service
public class ProvinciaServiceImpl implements ProvinciaService{

	@Autowired
	private ProvinciaDAO provinciaDAO;
	
	
	@Override
	public List<Provincia> listProvinciaAtRegion(int idRegion) {
		// TODO Auto-generated method stub
		return provinciaDAO.listProvinciaAtRegion(idRegion);
	}

}
