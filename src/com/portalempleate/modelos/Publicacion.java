package com.portalempleate.modelos;

import java.util.Date;

public class Publicacion {

	private String idUsuario;
	private String tipoId;
	private String cargo;
	private Integer vacantes;
	private String contratante;
	private String tipoEmpleo;
	private String tipoJornada;
	private String experiencia;
	private String modalidad;
	private Date fechaPublicacion;
	private Date fechaExpiracion;
	private String descripcion;
	private boolean estado;
	private Integer publicacionId;
	
	
	
	public Publicacion(Integer publicacionId, String cargo, String tipoEmpleo, Date fechaPublicacion, Date fechaExpiracion) {
		super();
		this.publicacionId = publicacionId;
		this.cargo = cargo;
		this.tipoEmpleo = tipoEmpleo;
		this.fechaPublicacion = fechaPublicacion;
		this.fechaExpiracion = fechaExpiracion;
	}
	
	

	public Publicacion(String tipoId, String idUsuario,String cargo, Integer vacantes, String contratante, String tipoEmpleo, String tipoJornada,
			String experiencia, String modalidad, Date fechaPublicacion, Date fechaExpiracion, String descripcion,
			boolean estado) {
		super();
		this.tipoId = tipoId;
		this.idUsuario = idUsuario;
		this.cargo = cargo;
		this.vacantes = vacantes;
		this.contratante = contratante;
		this.tipoEmpleo = tipoEmpleo;
		this.tipoJornada = tipoJornada;
		this.experiencia = experiencia;
		this.modalidad = modalidad;
		this.fechaPublicacion = fechaPublicacion;
		this.fechaExpiracion = fechaExpiracion;
		this.descripcion = descripcion;
		this.estado = estado;
	}





	public String getId() {
		return idUsuario;
	}



	public void setId(String id) {
		this.idUsuario = id;
	}



	public String getTipoId() {
		return tipoId;
	}



	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}



	public String getCargo() {
		return cargo;
	}



	public void setCargo(String cargo) {
		this.cargo = cargo;
	}



	public Integer getVacantes() {
		return vacantes;
	}



	public void setVacantes(Integer vacantes) {
		this.vacantes = vacantes;
	}



	public String getTipoEmpleo() {
		return tipoEmpleo;
	}



	public void setTipoEmpleo(String tipoEmpleo) {
		this.tipoEmpleo = tipoEmpleo;
	}



	public String getTipoJornada() {
		return tipoJornada;
	}



	public void setTipoJornada(String tipoJornada) {
		this.tipoJornada = tipoJornada;
	}



	public String getExperiencia() {
		return experiencia;
	}



	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}



	public String getModalidad() {
		return modalidad;
	}



	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}



	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}



	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}



	public String getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getContratante() {
		return contratante;
	}



	public void setContratante(String contratante) {
		this.contratante = contratante;
	}



	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}



	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}



	public Integer getPublicacionId() {
		return publicacionId;
	}



	public void setPublicacionId(Integer publicacionId) {
		this.publicacionId = publicacionId;
	}
	
	
}
