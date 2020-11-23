package net.spring.proyecto.service;

import java.util.List;

import net.spring.proyecto.entity.Distrito;

public interface DistritoService {
	public void save(Distrito bean);
	public void update(Distrito bean);
	public void delete(int id);
	public List<Distrito> listAll();
	public Distrito find(int id);
	public List<Distrito> listDistritosAtProvincia(int idProv);
}
