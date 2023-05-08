package com.portalempleate.view;

import com.portalempleate.controller.UsuarioController;

public class LogicaAspirante {

	private MenuAspirante menuAspirante;
	private Login login;
	
	private UsuarioController usuarioController;
	
	public LogicaAspirante() {}
	
	public LogicaAspirante(Login login) {
		this.login = login;
		
		menuAspirante = new MenuAspirante();
		
		menuAspirante.bienvenidaUsuario.setText("! Bienvenido " + nombreUsuario() + " !");
		
		menuAspirante.setVisible(true);
		
		
	}
	
	public String nombreUsuario() {
		this.usuarioController = new UsuarioController();
		
		return usuarioController.nombreUsuario(login.getTxtUsuario().getText());
	}
	
	
	
}
