package com.portalempleate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.portalempleate.modelos.Publicacion;

public class PublicacionDAO {

	private Connection con;
	
	public PublicacionDAO (Connection con) {
		this.con = con;
	}

	public List<Publicacion> listar() {
		List<Publicacion> publicacion = new ArrayList<Publicacion>();
		
		try {
			PreparedStatement statement = con.prepareStatement(
					"SELECT pub_id, pub_cargo, pub_tipo_empleo, pub_fecha_publicacion, pub_fecha_expiracion FROM publicacion");
			
			try (statement) {
				statement.execute();
				
				buscarPublicaciones(publicacion, statement);
			}
			return publicacion;
			
		}  catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Publicacion> listar(String id) {
		List<Publicacion> publicacion = new ArrayList<Publicacion>();
		
		try {
			PreparedStatement statement = con.prepareStatement(
					"SELECT pub_id, pub_cargo, pub_tipo_empleo, pub_fecha_publicacion, pub_fecha_expiracion FROM publicacion "
					+ " WHERE usu_id = ?");
			
			try (statement) {
				statement.setString(1, id);
				statement.execute();
				
				buscarPublicaciones(publicacion, statement);
			}
			return publicacion;
			
		}  catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void buscarPublicaciones(List<Publicacion> publicacion, PreparedStatement statement) throws SQLException {
		ResultSet resultSet = statement.getResultSet();		
		try (resultSet) {
			while (resultSet.next()) {
				Publicacion pb = new Publicacion(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getDate(4),
						resultSet.getDate(5)
						);
				publicacion.add(pb);
			}
		}
		
	}

	public void guardarPublicacion(Publicacion publicacion) {
		try {
			
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO publicacion "
					+ "(usu_tipo_id, usu_id, pub_cargo, pub_vacantes, pub_contratante, pub_tipo_empleo, pub_tipo_jornada, "
					+ "pub_experiencia, pub_modalidad, pub_fecha_publicacion, pub_fecha_expiracion, pub_descripcion, pub_estado) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			try (statement) {
				statement.setString(1, publicacion.getTipoId());
				statement.setString(2, publicacion.getId());
				statement.setString(3, publicacion.getCargo());
				statement.setInt(4, publicacion.getVacantes());
				statement.setString(5, publicacion.getContratante());
				statement.setString(6, publicacion.getTipoEmpleo());
				statement.setString(7, publicacion.getTipoJornada());
				statement.setString(8, publicacion.getExperiencia());
				statement.setString(9, publicacion.getModalidad());
				statement.setDate(10, (Date) publicacion.getFechaPublicacion());
				statement.setDate(11, (Date) publicacion.getFechaExpiracion());
				statement.setString(12, publicacion.getDescripcion());
				statement.setBoolean(13, publicacion.isEstado());
				
								
				statement.execute();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}

	public int eliminar(Integer id) {
		try {
			PreparedStatement statement = con.prepareStatement(
					"DELETE FROM publicacion WHERE pub_id = ?");
			
			try(statement) {
				statement.setInt(1, id);
				statement.execute();
				
				int updateCount = statement.getUpdateCount();
				
				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Publicacion mostrarPublicacion(Integer id) {
		try {
			
			PreparedStatement statement = con.prepareStatement(
					"SELECT usu_tipo_id, usu_id, pub_cargo, pub_vacantes, pub_contratante, pub_tipo_empleo, pub_tipo_jornada, "
					+ "pub_experiencia, pub_modalidad, pub_fecha_publicacion, pub_fecha_expiracion, pub_descripcion, pub_estado " +
					"FROM publicacion WHERE pub_id  = ?");
			try (statement) {
				statement.setInt(1, id);				
				
				ResultSet resultSet = statement.executeQuery();
				
				if (resultSet.next()) {
					Publicacion pb = new Publicacion(
							resultSet.getString(1),
							resultSet.getString(2),
							resultSet.getString(3),
							resultSet.getInt(4),
							resultSet.getString(5),
							resultSet.getString(6),
							resultSet.getString(7),
							resultSet.getString(8),
							resultSet.getString(9),
							resultSet.getDate(10),
							resultSet.getDate(11),
							resultSet.getString(12),
							resultSet.getBoolean(13)
							);
					
					return pb;
				} else {
					return null;
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int actualizarPublicacion(Publicacion publicacion, Integer id) {
		try {
			
			final PreparedStatement statement = con.prepareStatement(
					"UPDATE publicacion SET pub_cargo = ?, pub_vacantes = ?, pub_tipo_empleo = ?, pub_tipo_jornada = ?, "
					+ " pub_experiencia = ?, pub_modalidad = ?, pub_fecha_expiracion = ?, pub_descripcion = ? "
					+ " WHERE pub_id = ?");
			
			try (statement) {
				statement.setString(1, publicacion.getCargo());
				statement.setInt(2, publicacion.getVacantes());
				statement.setString(3, publicacion.getTipoEmpleo());
				statement.setString(4, publicacion.getTipoJornada());
				statement.setString(5, publicacion.getExperiencia());
				statement.setString(6, publicacion.getModalidad());
				statement.setDate(7, (Date) publicacion.getFechaExpiracion());
				statement.setString(8, publicacion.getDescripcion());
				statement.setInt(9, id);
						
				statement.execute();
				
				int updateCount = statement.getUpdateCount();
				return updateCount;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}

	
}
