package net.spring.proyecto.service;
import java.util.List;

import net.spring.proyecto.entity.Provincia;

public interface ProvinciaService {
	public List<Provincia> listProvinciaAtRegion(int idRegion);
}
