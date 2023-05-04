package com.portalempleate.modelos;

import java.sql.Date;

public class Usuario {

	private String tipoId;
	private String id;
	private String nombreComercial;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String telefono;
	private String telefonoFijo;
	private String correo;
	private String contrasena;
	private String direccion;
	private String descripcion;
	private String hojaDeVida;
	private Date fechaNacimiento;
	private String razonSocial;
	private String tipoServicio;
	private String numeroTrabajadores;
	private boolean estado;
	private String nitEmpresa;
	private Integer rolId;
	

	public Usuario() {
		super();
	}
	

	
	public Usuario(String tipoId, String id, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, String telefono, Integer rolId) {
		super();
		this.tipoId = tipoId;
		this.id = id;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.telefono = telefono;
		this.rolId = rolId;
	}



	public Usuario(String tipoId, String id, String nombreComercial, String primerNombre, String segundoNombre,
			String primerApellido, String segundoApellido, String telefono, String telefonoFijo, String correo,
			String contrasena, String direccion, String descripcion, String hojaDeVida, Date fechaNacimiento,
			String razonSocial, String tipoServicio, String numeroTrabajadores, boolean estado, String nitEmpresa) {
		super();
		this.tipoId = tipoId;
		this.id = id;
		this.nombreComercial = nombreComercial;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.telefono = telefono;
		this.telefonoFijo = telefonoFijo;
		this.correo = correo;
		this.contrasena = contrasena;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.hojaDeVida = hojaDeVida;
		this.fechaNacimiento = fechaNacimiento;
		this.razonSocial = razonSocial;
		this.tipoServicio = tipoServicio;
		this.numeroTrabajadores = numeroTrabajadores;
		this.estado = estado;
		this.nitEmpresa = nitEmpresa;
	}



	public String getTipoId() {
		return tipoId;
	}



	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNombreComercial() {
		return nombreComercial;
	}



	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}



	public String getPrimerNombre() {
		return primerNombre;
	}



	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}



	public String getSegundoNombre() {
		return segundoNombre;
	}



	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}



	public String getPrimerApellido() {
		return primerApellido;
	}



	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}



	public String getSegundoApellido() {
		return segundoApellido;
	}



	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getTelefonoFijo() {
		return telefonoFijo;
	}



	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getHojaDeVida() {
		return hojaDeVida;
	}



	public void setHojaDeVida(String hojaDeVida) {
		this.hojaDeVida = hojaDeVida;
	}



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public String getRazonSocial() {
		return razonSocial;
	}



	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}



	public String getTipoServicio() {
		return tipoServicio;
	}



	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}



	public String getNumeroTrabajadores() {
		return numeroTrabajadores;
	}



	public void setNumeroTrabajadores(String numeroTrabajadores) {
		this.numeroTrabajadores = numeroTrabajadores;
	}



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}



	public String getNitEmpresa() {
		return nitEmpresa;
	}



	public void setNitEmpresa(String nitEmpresa) {
		this.nitEmpresa = nitEmpresa;
	}
	
	public Integer getRolId() {
		return rolId;
	}



	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	
}
