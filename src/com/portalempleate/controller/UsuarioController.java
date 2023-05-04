package com.portalempleate.controller;

import com.portalempleate.conexion.ConnectionFactory;
import com.portalempleate.dao.UsuarioDAO;
import com.portalempleate.modelos.Usuario;

public class UsuarioController {
	
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;
	
	public UsuarioController() {
		usuarioDAO = new UsuarioDAO(new ConnectionFactory().recuperarConexion());
	}

	public boolean login(String user, char[] pass) {
		String password = String.valueOf(pass);
		return usuarioDAO.login(user, password);
	}
	
	public void guardarusuarioAspiranteV1(Usuario usuario) {
		this.usuario = usuario;
		usuarioDAO.guardarusuarioAspiranteV1(usuario);
	}
	
}
