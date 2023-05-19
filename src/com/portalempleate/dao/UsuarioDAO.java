package com.portalempleate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;

import com.portalempleate.modelos.Usuario;

public class UsuarioDAO {

	private Connection con;
	
	public UsuarioDAO(Connection con) {
		this.con = con;
	}

	public boolean login(String user, String password) {
		
		try {
			PreparedStatement statement = con.prepareStatement(
					"SELECT usu_correo, usu_contrasena, rol_id FROM usuario WHERE " + 
					"  usu_correo = ? and usu_contrasena = ? ", Statement.RETURN_GENERATED_KEYS);
			
			try (statement){
				statement.setString(1, user);
				statement.setString(2, password);
				
				//statement.execute();
				
				ResultSet resultSet = statement.executeQuery();
				
				if (resultSet.next()) {
					return true;
				} else {
					return false;	
				}
				
						
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String tipoUsuario(ResultSet resultSet) throws SQLException {
		if (resultSet.next()) {
			String rolId = resultSet.getString("rol_id");
			System.out.println(rolId);
			return rolId;
		} else {
			return "0";	
		}
	}
	
	/*
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

	public void guardarusuarioAspiranteV2(Usuario usuario) {
		try {
			
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO usuario (usu_correo, usu_contrasena, usu_hoja_de_vida, usu_fecha_nacimiento) " +
					"VALUES (?, ?, ?, ?) WHERE usu_id = ? ");
			
			try (statement) {
				statement.setString(1, usuario.getCorreo());
				statement.setString(2, usuario.getContrasena());
				statement.setString(3, usuario.getHojaDeVida());
				statement.setDate(4, usuario.getFechaNacimiento());
				statement.setString(5, usuario.getId());
				
				statement.execute();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	*/
	public void guardarAspirante(Usuario usuario) {
		try {
			
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO usuario "
					+ "(usu_tipo_id, usu_id, usu_primer_nombre, usu_segundo_nombre, "
					+ "usu_primer_apellido, usu_segundo_apellido, usu_telefono, usu_correo, "
					+ "usu_contrasena, usu_hoja_de_vida, usu_fecha_nacimiento, rol_id) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			try (statement) {
				statement.setString(1, usuario.getTipoId());
				statement.setString(2, usuario.getId());
				statement.setString(3, usuario.getPrimerNombre());
				statement.setString(4, usuario.getSegundoNombre());
				statement.setString(5, usuario.getPrimerApellido());
				statement.setString(6, usuario.getSegundoApellido());
				statement.setString(7, usuario.getTelefono());
				statement.setString(8, usuario.getCorreo());
				statement.setString(9, usuario.getContrasena());
				statement.setString(10, usuario.getHojaDeVida());
				statement.setDate(11, (java.sql.Date) usuario.getFechaNacimiento());
				statement.setInt(12, usuario.getRolId());
				
				
				
				statement.execute();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}

	public int tipoDeUsuairo(String user) {
		try {
			PreparedStatement statement = con.prepareStatement(
					"SELECT usu_correo, rol_id FROM usuario WHERE " + 
					"  usu_correo = ? ", Statement.RETURN_GENERATED_KEYS);
			
			try (statement){
				statement.setString(1, user);
				
				//statement.execute();
				
				ResultSet resultSet = statement.executeQuery();
				
				if (resultSet.next()) {
					String rolId = resultSet.getString("rol_id");
					return Integer.parseInt(rolId);
				} else {
					return 0;	
				}
				
						
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public String nombreUsuario(String username) {
		try {
			PreparedStatement statement = con.prepareStatement(
					"SELECT usu_correo, usu_primer_nombre FROM usuario WHERE " + 
					"  usu_correo = ? ", Statement.RETURN_GENERATED_KEYS);
			
			try (statement){
				statement.setString(1, username);
				
				//statement.execute();
				
				ResultSet resultSet = statement.executeQuery();
				
				if (resultSet.next()) {
					String user = resultSet.getString("usu_primer_nombre");
					return user;
				} else {
					return "";	
				}
				
						
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void guardarEmpleador(Usuario usuario) {
		try {
			
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO usuario "
					+ "(usu_tipo_id, usu_id, usu_primer_nombre, usu_segundo_nombre, "
					+ "usu_primer_apellido, usu_segundo_apellido, usu_telefono, usu_telefono_fijo, usu_correo, "
					+ "usu_contrasena, usu_nombre_comercial, usu_nit, usu_razon_social, usu_tiposervicio, usu_fecha_nacimiento, rol_id) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			try (statement) {
				statement.setString(1, usuario.getTipoId());
				statement.setString(2, usuario.getId());
				statement.setString(3, usuario.getPrimerNombre());
				statement.setString(4, usuario.getSegundoNombre());
				statement.setString(5, usuario.getPrimerApellido());
				statement.setString(6, usuario.getSegundoApellido());
				statement.setString(7, usuario.getTelefono());
				statement.setString(8, usuario.getTelefonoFijo());
				statement.setString(9, usuario.getCorreo());
				statement.setString(10, usuario.getContrasena());
				statement.setString(11, usuario.getNombreComercial());
				statement.setString(12, usuario.getNitEmpresa());
				statement.setString(13, usuario.getRazonSocial());
				statement.setString(14, usuario.getTipoServicio());
				statement.setDate(15, (java.sql.Date) usuario.getFechaNacimiento());
				statement.setInt(16, usuario.getRolId());
				
				statement.execute();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
		
	}

	public Usuario usuarioActualEmp(String correo) {
		try {
			PreparedStatement statement = con.prepareStatement(
					"SELECT usu_tipo_id, usu_id, usu_primer_nombre, usu_segundo_nombre, "
					+ "usu_primer_apellido, usu_segundo_apellido, usu_telefono, usu_telefono_fijo, usu_correo, "
					+ "usu_contrasena, usu_nombre_comercial, usu_nit, usu_razon_social, usu_tiposervicio, usu_fecha_nacimiento, rol_id"
					+ " FROM usuario WHERE usu_correo = ?");
			try (statement) {
				statement.setString(1, correo);
				//statement.execute();
				
				ResultSet resultSet = statement.executeQuery();
				
				if (resultSet.next()) {
					Usuario us = new Usuario(
							resultSet.getString(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getString(4),
							resultSet.getString(5),
							resultSet.getString(6),
							resultSet.getString(7),
							resultSet.getString(8),
							resultSet.getString(9),
							resultSet.getString(10),
							resultSet.getString(11),
							resultSet.getString(12),
							resultSet.getString(13),
							resultSet.getString(14),
							resultSet.getDate(15),
							resultSet.getInt(16)
							);
					return us;
				} else {
					return null;	
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}	
}
