package com.portalempleate.controller;

import java.util.Date;

import com.portalempleate.conexion.ConnectionFactory;
import com.portalempleate.dao.UsuarioDAO;
import com.portalempleate.modelos.Usuario;

public class UsuarioController {
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioController() {
		usuarioDAO = new UsuarioDAO(new ConnectionFactory().recuperarConexion());
	}

	public boolean login(String user, char[] pass) {
		String password = String.valueOf(pass);
		return usuarioDAO.login(user, password);
	}
	/*
	public void guardarusuarioAspiranteV1(Usuario usuario) {
		this.usuario = usuario;
		usuarioDAO.guardarusuarioAspiranteV1(usuario);
	}

	public void guardarusuarioAspiranteV2(String correo, String password, String hojaDeVida, Date fechaNacimiento) {
		usuario.setCorreo(correo);
		usuario.setContrasena(password);
		usuario.setHojaDeVida(hojaDeVida);
		usuario.setFechaNacimiento((java.sql.Date) fechaNacimiento);
		
		usuarioDAO.guardarusuarioAspiranteV2(usuario);
	}
	
	public void asignaUsuario(Usuario user) {
		usuario = user;
	}
	*/
	public void guardarAspirante(Usuario usuarioAspirante) {
		usuarioDAO.guardarAspirante(usuarioAspirante);
	}

	public int tipoDeUsuairo(String text) {
		return usuarioDAO.tipoDeUsuairo(text);
	}

	public String nombreUsuario(String username) {
		return usuarioDAO.nombreUsuario(username);
	}

	public void guardarEmpleador(Usuario usuario) {
		usuarioDAO.guardarEmpleador(usuario);
	}

	public Usuario usuarioActualEmp(String correo) {
		return usuarioDAO.usuarioActualEmp(correo);
	}
	
}
