package net.spring.proyecto.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_empleado")
public class Empleado implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_emp")
	private int codigoEmpleado;
	@Column(name = "nom_emp")
	private String nombres;
	@Column(name = "ape_emp")
	private String apellidos;
	@Column(name = "sex_emp")
	private String sexo;
	@Temporal(TemporalType.DATE)
	@Column(name = "fec_reg_emp")
	private Date fechaRegistro;
	@Temporal(TemporalType.DATE)
	@Column(name = "fec_nac_emp")
	private Date fechaNacimiento;
	@Column(name = "dir_emp")
	private String direccion;
	
	//relación muchos "Empleado" a uno "Distrito"
	@ManyToOne
	@JoinColumn(name = "cod_dis_emp")
	private Distrito distritoEmpleado;//ASOCIACIÖN.
	
		
	
	public int getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Distrito getDistritoEmpleado() {
		return distritoEmpleado;
	}

	public void setDistritoEmpleado(Distrito distritoEmpleado) {
		this.distritoEmpleado = distritoEmpleado;
	}

	


	
	
}








