package com.portalempleate.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.portalempleate.controller.PublicacionController;
import com.portalempleate.controller.UsuarioController;
import com.portalempleate.modelos.Publicacion;
import com.portalempleate.modelos.Usuario;

public class LogicaEmpleador {

	private MenuEmpleador menuEmpleador;
	private VentanaCrearPublicacion crearPublicacion;
	private VentanaPublicaciones ventanaPublicaciones;
	private Login login;
	public Date fechaActual;
	
	private UsuarioController usuarioController;
	private PublicacionController pbController;
	
	private Usuario ususarioActual;
	
	public LogicaEmpleador(Login login) {
		this.login = login;
		
		// INICIALIZAR VENTANAS 
		ventanaPublicaciones = new VentanaPublicaciones();
		menuEmpleador = new MenuEmpleador();
		crearPublicacion = new VentanaCrearPublicacion();
		
		// MENU PRINCIPAL
		menuEmpleador.bienvenidaUsuario.setText("! Bienvenido " + nombreUsuario() + " !");
		this.ususarioActual = usuarioController.usuarioActualEmp(login.getTxtUsuario().getText());
		menuEmpleador.setVisible(true);
		
		menuEmpleador.btnCrearOferta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuEmpleador.dispose();
				limpiarCamposPublicacion();
				crearPublicacion.setVisible(true);					
			}
		}
		);
		
		menuEmpleador.btnPublicacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuEmpleador.dispose();
				ventanaPublicaciones.setVisible(true);					
			}
		}
		);
		
		
		
		// PUBLICACIONES 
		crearPublicacion.btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crearPublicacion.dispose();
				menuEmpleador.setVisible(true);	
			}
		}
		);
	
				
		crearPublicacion.btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (crearPublicacion.validarCampos()) {
					registrarPublicacion();
					JOptionPane.showMessageDialog(crearPublicacion, "Exitoso");
					crearPublicacion.dispose();
					ventanaPublicaciones.setVisible(true);
				}
			}
		}
		);
		
		// VENTANA PUBLICACION
		ventanaPublicaciones.btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaPublicaciones.dispose();
				menuEmpleador.setVisible(true);	
			}
		}
		);
		
		
	}
	
	public String nombreUsuario() {
		this.usuarioController = new UsuarioController();
		
		return usuarioController.nombreUsuario(login.getTxtUsuario().getText());
	}
	
	public void registrarPublicacion() {
		this.pbController = new PublicacionController();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		String experiencia = crearPublicacion.getTxtExperiencia().getText() + " " + crearPublicacion.getTxtTipoExperiencia().getSelectedItem().toString();
		
		String fechaExpiracion = ((JTextField)crearPublicacion.getTxtFechaExpiracion().getDateEditor().getUiComponent()).getText();
		
		// Obtén la fecha actual del sistema
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();

        // Convierte la fecha actual a java.sql.Date
        Date fechaActual = new Date(currentDate.getTime());
		String fechaPublicacion = formato.format(fechaActual);
		
		Publicacion publicacion = new Publicacion(
				ususarioActual.getTipoId(),
				ususarioActual.getId(),
				crearPublicacion.getTxtCargo().getText(),
				Integer.parseInt(crearPublicacion.getTxtNumeroVacantes().getText()),
				ususarioActual.getNombreComercial(),
				crearPublicacion.getTxtTipoEmpleo().getSelectedItem().toString(),
				crearPublicacion.getTxtTipoJornada().getSelectedItem().toString(),
				experiencia,
				crearPublicacion.getTxtModalidad().getSelectedItem().toString(),
				Date.valueOf(fechaPublicacion),
				Date.valueOf(fechaExpiracion),
				crearPublicacion.getTxtDescripcion().getText(),
				true
				);
		
		pbController.guardarPublicacion(publicacion);
	}
	
	public void limpiarCamposPublicacion() {
		crearPublicacion.getTxtCargo().setText("");
		crearPublicacion.getTxtNumeroVacantes().setText("");
		crearPublicacion.getTxtTipoEmpleo().setSelectedItem("");
		crearPublicacion.getTxtTipoJornada().setSelectedItem("");
		crearPublicacion.getTxtExperiencia().setText("");
		crearPublicacion.getTxtTipoExperiencia().setSelectedItem("");
		crearPublicacion.getTxtModalidad().setSelectedItem("");
		crearPublicacion.getTxtFechaExpiracion().setDate(fechaActual);
		crearPublicacion.getTxtDescripcion().setText("");
		
	}
	
	
	
}