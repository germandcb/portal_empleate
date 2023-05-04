package com.portalempleate.conexion;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private DataSource dataSource;
	
	public ConnectionFactory() {
		var pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/empleate?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		//pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/curso_login");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("root");
		pooledDataSource.setMaxPoolSize(10);
		
		this.dataSource = pooledDataSource;
	}
	
	public Connection recuperarConexion() {
		try {
			return this.dataSource.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
