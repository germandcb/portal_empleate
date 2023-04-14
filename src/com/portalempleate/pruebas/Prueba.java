package com.portalempleate.pruebas;

import java.sql.Connection;
import java.sql.SQLException;

import com.portalempleate.conexion.ConnectionFactory;

public class Prueba {

	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().recuperarConexion();
		System.out.println("Conexion Abierta");
		con.close();
		System.out.println("Cerrando la Conexión");
	}
}
