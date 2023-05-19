package com.portalempleate.pruebas;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;

import com.portalempleate.conexion.ConnectionFactory;
import com.portalempleate.recursos.PanelAction;

public class Prueba {

	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().recuperarConexion();
		System.out.println("Conexion Abierta");
		con.close();
		System.out.println("Cerrando la Conexión");
		
		JFrame v1 = new JFrame();
		PanelAction pa = new PanelAction();
		
		v1.add(pa);
		v1.setVisible(true);
	}
}
