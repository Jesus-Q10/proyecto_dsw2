package net.spring.proyecto.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.proyecto.dao.RegionDAO;
import net.spring.proyecto.entity.Region;

@Service
public class RegionServiceImpl implements RegionService{

	@Autowired
	private RegionDAO regionDAO;
	
	@Override
	public List<Region> listRegiones() {
		// TODO Auto-generated method stub
		return regionDAO.listRegiones();
	}

}
