package com.portalempleate.modelos;

import java.sql.Date;

public class Postulacion {

	private Integer id;
	private Integer idPublicacion;
	private String tipoId;
	private String idUsuario;
	private Date fechaPostulacion;
	
	
	public Postulacion(Integer id, Integer idPublicacion, String tipoId, String idUsuario, Date fechaPostulacion) {
		super();
		this.id = id;
		this.idPublicacion = idPublicacion;
		this.tipoId = tipoId;
		this.idUsuario = idUsuario;
		this.fechaPostulacion = fechaPostulacion;
	}
	
	
}
