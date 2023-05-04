package com.portalempleate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.portalempleate.modelos.Usuario;

public class UsuarioDAO {

	private Connection con;
	
	public UsuarioDAO(Connection con) {
		this.con = con;
	}

	public boolean login(String user, String password) {
		
		try {
			PreparedStatement statement = con.prepareStatement(
					"SELECT usu_correo, usu_contrasena FROM usuario WHERE " + 
					"  usu_correo = ? and usu_contrasena = ? ");
			
			try (statement){
				statement.setString(1, user);
				statement.setString(2, password);
				
				statement.execute();
				
				ResultSet resultSet = statement.getGeneratedKeys();
						
				boolean usuarioValido = resultSet.next();
				
				return usuarioValido;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	public void guardarusuarioAspiranteV1(Usuario usuario) {
		try {
			
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO usuario (usu_tipo_id, usu_id, usu_primer_nombre, usu_segundo_nombre, usu_primer_apellido, usu_segundo_apellido, usu_telefono, rol_id) " +
					"VALUES (?, ?, ?, ?, ? , ?, ?, ?)");
			
			try (statement) {
				statement.setString(1, usuario.getTipoId());
				statement.setString(2, usuario.getId());
				statement.setString(3, usuario.getPrimerNombre());
				statement.setString(4, usuario.getSegundoNombre());
				statement.setString(5, usuario.getPrimerApellido());
				statement.setString(6, usuario.getSegundoApellido());
				statement.setString(7, usuario.getTelefono());
				statement.setInt(8, usuario.getRolId());
				
				statement.execute();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
