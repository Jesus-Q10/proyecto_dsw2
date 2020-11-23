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
@Table(name = "tb_distrito")
public class Distrito implements Serializable{
	@Id
	@Column(name="idDist")
	private int idDistrito;
	@Column(name = "distrito")
	private String nombreDistrito;

	
	//relación muchos "Distrito" a uno "Provincia" 
	@ManyToOne
	@JoinColumn(name = "idProv")
	private Provincia provincia;//ASOC
	
	
	//relación uno "Distrito" a muchos "Empleado"
	@JsonIgnore
	@OneToMany(mappedBy = "distritoEmpleado")//ASOCIACIÓN
	private List<Empleado> listaEmpleados;
	
	public int getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}
	public String getNombreDistrito() {
		return nombreDistrito;
	}
	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	
}
