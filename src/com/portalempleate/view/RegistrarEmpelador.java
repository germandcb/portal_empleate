package com.portalempleate.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.Format;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.portalempleate.controller.UsuarioController;
import com.portalempleate.modelos.Usuario;

public class RegistrarEmpelador {

	private Ventana1SigninEmpleador vEmpleador1;
	private Ventana2SigninEmpleador vEmpleador2;
	private Ventana3SigninEmpleador vEmpleador3;
	
	private UsuarioController usuarioController;
	
	public RegistrarEmpelador() {
		vEmpleador1 = new Ventana1SigninEmpleador();
		vEmpleador2 = new Ventana2SigninEmpleador();
		vEmpleador3 = new Ventana3SigninEmpleador();
		
		vEmpleador1.setVisible(true);
		
		vEmpleador1.btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (vEmpleador1.validarCampos()) {
					vEmpleador1.dispose();
					vEmpleador2.setVisible(true);					
				} else {
					JOptionPane.showMessageDialog(vEmpleador1, "Complete todos los campos");
				}
			}
		});
		
		// Ventana 2
		vEmpleador2.btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vEmpleador1.setVisible(true);
				vEmpleador2.dispose();
			}
		});
		
		vEmpleador2.btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (vEmpleador2.validarCampos()) {
					vEmpleador2.dispose();
					vEmpleador3.setVisible(true);					
				} else {
					JOptionPane.showMessageDialog(vEmpleador1, "Complete todos los campos");
				}
			}
		});
		
		// Ventana 3 
		vEmpleador3.btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vEmpleador2.setVisible(true);
				vEmpleador3.dispose();
			}
		});
		
		vEmpleador3.registarEmpleador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (vEmpleador3.validarCampos()) {
					registrarUsuarioEmpleador();
					JOptionPane.showMessageDialog(vEmpleador3, "Registro exitoso");
             		Login frame = new Login();
					frame.setVisible(true);
					vEmpleador3.dispose();					
				} else {
					JOptionPane.showMessageDialog(vEmpleador3, "Complete todos los campos");
				}
			}
		});
	}
	
	public void registrarUsuarioEmpleador() {
		usuarioController = new UsuarioController();
		
		String telefono = vEmpleador1.getTxtExtensioncelular().getText() + 
				vEmpleador1.getTxtNumcelular().getText();
		
		String fechaN = ((JTextField)vEmpleador2.getTxtFechanac().getDateEditor().getUiComponent()).getText();
		
		String password = String.valueOf(vEmpleador2.getTxtContrasena().getPassword());
		
		Usuario usuario = new Usuario(
				vEmpleador1.getTxtTipoid().getSelectedItem().toString(),
				vEmpleador1.getTxtId().getText(),
				vEmpleador1.getTxtPrimernombre().getText(),
				vEmpleador1.getTxtSegundonombre().getText(),
				vEmpleador1.getTxtPrimerapellido().getText(),
				vEmpleador1.getTxtSegundoapellido().getText(),
				telefono,
				vEmpleador2.getTxtTelefonofijo().getText(),
				Date.valueOf(fechaN),
				vEmpleador2.getTxtCorreo().getText(),
				password,
				vEmpleador3.getTxtNombrecomercial().getText(),
				vEmpleador3.getTxtNit().getText(), 
				vEmpleador3.getTxtRazonsocial().getText(),
				vEmpleador3.getTxtTiposervicio().getText(),
				2
				);
		
		this.usuarioController.guardarEmpleador(usuario);
	
		
	}
}
