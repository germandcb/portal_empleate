package com.portalempleate.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.portalempleate.controller.UsuarioController;
import com.portalempleate.modelos.Usuario;

public class RegistrarAspirante {

	private VentanaAspirant1 vAspirante1;
	private VentanaAspirante2 vAspirante2;
	
	private UsuarioController usuarioController;
	
	public RegistrarAspirante() {
		vAspirante1 = new VentanaAspirant1();
		vAspirante2 = new VentanaAspirante2();
		vAspirante1.setVisible(true);
		
		vAspirante1.btnNext.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
						
					if (vAspirante1.registrarAspiranteV1()) {
						vAspirante1.dispose();
						
						vAspirante2.setVisible(true);
												
					} else {
						JOptionPane.showInputDialog(this, "Complete todos los campos");
					}
						
						
				}
			
			}
		);
		
		vAspirante2.btnGuardarAspirante.addMouseListener(new MouseAdapter() {
            @Override
             public void mouseClicked(MouseEvent e) {
             	if (vAspirante2.registrarAspiranteV2()) {
             		
             		registrarUsuarioAspirante();
             		JOptionPane.showInputDialog(this, "Registro exitoso");
             		
					} else {
						JOptionPane.showInputDialog(this, "Ocurrio un error");
					}
             }

         });
		
	}
	
	public void registrarUsuarioAspirante() {
		usuarioController = new UsuarioController();
		
		String password = String.valueOf(vAspirante2.getTxtContrasena().getPassword());
		String telefono = vAspirante1.getTxtExtensioncelular().getText() + 
				vAspirante1.getTxtNumcelular().getText();
		String fechaN = ((JTextField)vAspirante2.getTxtFechanac().getDateEditor().getUiComponent()).getText();
		
		Usuario usuario = new Usuario(
				vAspirante1.getTxtTipoid().getSelectedItem().toString(),
				vAspirante1.getTxtId().getText(),
				vAspirante1.getTxtPrimernombre().getText(),
				vAspirante1.getTxtSegundonombre().getText(),
				vAspirante1.getTxtPrimerapellido().getText(),
				vAspirante1.getTxtSegundoapellido().getText(),
				telefono,
				vAspirante2.getTxtCorreo().getText(),
				password,
				vAspirante2.getTxthojavida().getText(),
				Date.valueOf(fechaN),	
				1
				);
		
		
		this.usuarioController.guardarAspirante(usuario);
	}
	
}


