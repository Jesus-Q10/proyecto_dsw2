package net.spring.proyecto.dao;
import java.util.List;
import net.spring.proyecto.entity.Provincia;

public interface ProvinciaDAO {
	public List<Provincia> listProvinciaAtRegion(int idRegion);
}
