package net.spring.proyecto.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_provincia")
public class Provincia implements Serializable{
	@Id
	@Column(name="idProv")
	private int idProvincia;
	@Column(name = "provincia")
	private String nombreProvincia;

	//relación muchos "Provincia" a uno "Region" 
	@ManyToOne
	@JoinColumn(name="idRegion")
	private Region region;//Asociaciòn
	
	//relación uno "Provincia" a muchos "Distrito"
	@JsonIgnore
	@OneToMany(mappedBy = "provincia")
	private List<Distrito> listaDistritos;

	
	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

}
