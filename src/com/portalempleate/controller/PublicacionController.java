package com.portalempleate.controller;

import java.util.List;

import com.portalempleate.conexion.ConnectionFactory;
import com.portalempleate.dao.PublicacionDAO;
import com.portalempleate.dao.UsuarioDAO;
import com.portalempleate.modelos.Publicacion;

public class PublicacionController {
	
	private PublicacionDAO publicacionDAO;
	
	public PublicacionController() {
		publicacionDAO = new PublicacionDAO(new ConnectionFactory().recuperarConexion());
	}
	
	public List<Publicacion> listar() {
		return publicacionDAO.listar();
	}

	public void guardarPublicacion(Publicacion publicacion) {
		publicacionDAO.guardarPublicacion(publicacion);		
	}

	public int eliminar(Integer id) {
		return publicacionDAO.eliminar(id);
	}

	public Publicacion mostrarPublicacion(Integer id) {
		return publicacionDAO.mostrarPublicacion(id);
	}
}
