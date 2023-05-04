package com.portalempleate.modelos;

import java.sql.Date;

public class Publicacion {

	private Integer id;
	private String tipoId;
	private String cargo;
	private Integer vacantes;
	private String tipoEmpleo;
	private String tipoJornada;
	private String experiencia;
	private String modalidad;
	private Date fechaPublicacion;
	private String descripcion;
	private boolean estado;
	
	
	public Publicacion(Integer id, String tipoId, String cargo, Integer vacantes, String tipoEmpleo, String tipoJornada,
			String experiencia, String modalidad, Date fechaPublicacion, String descripcion, boolean estado) {
		super();
		this.id = id;
		this.tipoId = tipoId;
		this.cargo = cargo;
		this.vacantes = vacantes;
		this.tipoEmpleo = tipoEmpleo;
		this.tipoJornada = tipoJornada;
		this.experiencia = experiencia;
		this.modalidad = modalidad;
		this.fechaPublicacion = fechaPublicacion;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	
}
