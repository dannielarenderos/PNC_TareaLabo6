package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public", name="contribuyente")
public class Contribuyente{
	
	@Id
	@GeneratedValue(generator="contribuyente_c_contribuyente_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "contribuyente_c_contribuyente_seq", sequenceName = "public.contribuyente_c_contribuyente_seq", allocationSize = 1)
	@Column(name="c_contribuyente")
	private Integer c_contribuyente;
	
	
	@Size(message="El nombre no debe tener mas de 30 caracteres", max=30)
	@NotEmpty(message="No puede estar vacio")
	@Column(name="s_nombre")
	private String s_nombre;
	
	@Size(message="El apellido no debe tener mas de 30 caracteres", max=30)
	@NotEmpty(message="No puede estar vacio")
	@Column(name="s_apellido")
	private String s_apellido;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "f_fecha_ingreso")
	private Date f_fecha_ingreso;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_importancia")
	private Importancia c_importancia;
	
	@Size(message="El nit no debe tener mas de 14 caracteres", max=14)
	@NotEmpty(message="No puede estar vacio")
	@Column(name="s_nit")
	private String s_nit;
	
	@Transient
	private Integer cimportancia;
	
	public Integer getCimportancia() {
		return cimportancia;
	}

	public void setCimportancia(Integer cimportancia) {
		this.cimportancia = cimportancia;
	}

	public Contribuyente() {

	}

	public Integer getC_contribuyente() {
		return c_contribuyente;
	}

	public void setC_contribuyente(Integer c_contribuyente) {
		this.c_contribuyente = c_contribuyente;
	}

	public String getS_nombre() {
		return s_nombre;
	}

	public void setS_nombre(String s_nombre) {
		this.s_nombre = s_nombre;
	}

	public String getS_apellido() {
		return s_apellido;
	}

	public void setS_apellido(String s_apellido) {
		this.s_apellido = s_apellido;
	}

	public Date getF_fecha_ingreso() {
		return f_fecha_ingreso;
	}

	public String getFingresoDelegate() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(f_fecha_ingreso);
		
	}

	public void setF_fecha_ingreso(Date f_fecha_ingreso) {
		this.f_fecha_ingreso = f_fecha_ingreso;
	}

	public Importancia getC_importancia() {
		return c_importancia;
	}

	public void setC_importancia(Importancia c_importancia) {
		this.c_importancia = c_importancia;
	}

	public String getS_nit() {
		return s_nit;
	}

	public void setS_nit(String s_nit) {
		this.s_nit = s_nit;
	}

	
	

	
	
}
	