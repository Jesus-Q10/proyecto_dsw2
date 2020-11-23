package net.spring.proyecto.entity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "tb_region")
public class Region implements Serializable{
	@Id
	@Column(name="idRegion")
	private int idRegion;
	@Column(name = "region")
	private String region;
	
	//relación uno "Region" a muchos "Provincia"
	@JsonIgnore
	@OneToMany(mappedBy = "region")//ASOCIACIÓN
	private List<Provincia> listaProvincias;

	public int getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<Provincia> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<Provincia> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}
	
	
	
}
