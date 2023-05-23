package com.portalempleate.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.portalempleate.controller.PublicacionController;
import com.portalempleate.controller.UsuarioController;
import com.portalempleate.modelos.Publicacion;
import com.portalempleate.modelos.Usuario;
import com.portalempleate.recursos.TableActionEvent;

public class LogicaEmpleador {

	private MenuEmpleador menuEmpleador;
	private VentanaCrearPublicacion crearPublicacion;
	private VentanaPublicaciones ventanaPublicaciones;
	private VentanaEditarPublicacion vEditarPublicacion;
	private Login login;
	public Date fechaActual;
	
	private UsuarioController usuarioController;
	private PublicacionController pbController;
	
	private Usuario ususarioActual;
	
	public LogicaEmpleador(Login login) {
		this.login = login;
		this.pbController = new PublicacionController();
		
		// INICIALIZAR VENTANAS 
		menuEmpleador = new MenuEmpleador();
		crearPublicacion = new VentanaCrearPublicacion();
		vEditarPublicacion = new VentanaEditarPublicacion();
		
		// MENU PRINCIPAL
		menuEmpleador.bienvenidaUsuario.setText("! Bienvenido " + nombreUsuario() + " !");
		ususarioActual = usuarioController.usuarioActualEmp(login.getTxtUsuario().getText());
		
		ventanaPublicaciones = new VentanaPublicaciones(ususarioActual.getId());
		
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
				limpiarTabla(ventanaPublicaciones.tablaPublic);
				ventanaPublicaciones.listarPublicaciones(ususarioActual.getId());
				ventanaPublicaciones.setVisible(true);					
			}
		}
		);
		
		
		
		// CREAR PUBLICACIONES 
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
					limpiarTabla(ventanaPublicaciones.tablaPublic);
					ventanaPublicaciones.listarPublicaciones(ususarioActual.getId());
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
		
		ventanaPublicaciones.event = new TableActionEvent() {
			@Override
			public void onView(int row) {
				System.out.println("View row : " + row);
				if (ventanaPublicaciones.tablaPublic.isEditing()) {
					ventanaPublicaciones.tablaPublic.getCellEditor().stopCellEditing();
				}
				ventanaPublicaciones.obtenerDatosPublicacion(row);
			}
			
			@Override
			public void onEdit(int row) {
				System.out.println("Edit row : " + row);	
				if (ventanaPublicaciones.tablaPublic.isEditing()) {
					ventanaPublicaciones.tablaPublic.getCellEditor().stopCellEditing();
				}
				cargarInformacion();
				ventanaPublicaciones.dispose();
				vEditarPublicacion.setVisible(true);
			}			
			
			@Override
			public void onDelete(int row) {
				System.out.println("Delete row : " + row);
				if (ventanaPublicaciones.tablaPublic.isEditing()) {
					ventanaPublicaciones.tablaPublic.getCellEditor().stopCellEditing();
				}
				
				ventanaPublicaciones.eliminarPublicacion(row);
				
			}
		}; 
		
		// VENTANA EDITAR PUBLICACION
		
		vEditarPublicacion.btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (vEditarPublicacion.validarCampos()) {
					editarPublicacion();
					JOptionPane.showMessageDialog(crearPublicacion, "Actualizacion Exitosa");
					vEditarPublicacion.dispose();
					limpiarTabla(ventanaPublicaciones.tablaPublic);
					ventanaPublicaciones.listarPublicaciones(ususarioActual.getId());
					ventanaPublicaciones.setVisible(true);
				}
			}
		}
		);
		
		vEditarPublicacion.btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vEditarPublicacion.dispose();
				ventanaPublicaciones.setVisible(true);
				
			}
		}
		);
		
	}
	
	public String nombreUsuario() {
		this.usuarioController = new UsuarioController();
		
		return usuarioController.nombreUsuario(login.getTxtUsuario().getText());
	}
	
	public void registrarPublicacion() {
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
	
	protected void limpiarTabla(JTable tb) {		
		((DefaultTableModel) tb.getModel()).setRowCount(0);
	}
	
	public void editarPublicacion() {
		
         Optional.ofNullable(ventanaPublicaciones.modelo.getValueAt(ventanaPublicaciones.tablaPublic.getSelectedRow(), ventanaPublicaciones.tablaPublic.getSelectedColumn()))
 		.ifPresentOrElse(fila -> {
 			Integer id = Integer.valueOf(ventanaPublicaciones.modelo.getValueAt(ventanaPublicaciones.tablaPublic.getSelectedRow(), 0).toString());
 		 			
 			String fechaExpiracion = ((JTextField)vEditarPublicacion.getTxtFechaExpiracion().getDateEditor().getUiComponent()).getText();
 			String experiencia = vEditarPublicacion.getTxtExperiencia().getText() + " " + vEditarPublicacion.getTxtTipoExperiencia().getSelectedItem().toString();
 			
 			Publicacion publicacion = new Publicacion(
 					ususarioActual.getTipoId(),
 					ususarioActual.getId(),
 					vEditarPublicacion.getTxtCargo().getText(),
 					Integer.parseInt(vEditarPublicacion.getTxtNumeroVacantes().getText()),
 					ususarioActual.getNombreComercial(),
 					vEditarPublicacion.getTxtTipoEmpleo().getSelectedItem().toString(),
 					vEditarPublicacion.getTxtTipoJornada().getSelectedItem().toString(),
 					experiencia,
 					vEditarPublicacion.getTxtModalidad().getSelectedItem().toString(),
 					Date.valueOf(fechaExpiracion),
 					vEditarPublicacion.getTxtDescripcion().getText(),
 					true
 					);
 			var filaModificada  =pbController.actualizarPublicacion(publicacion, id);
 			
 			
			JOptionPane.showMessageDialog(null,
					String.format("%d Registro modificado con éxito!", filaModificada));
 		}, null);;
	}
	
	public void cargarInformacion() {
		
		Optional.ofNullable(ventanaPublicaciones.modelo.getValueAt(ventanaPublicaciones.tablaPublic.getSelectedRow(), ventanaPublicaciones.tablaPublic.getSelectedColumn()))
        .ifPresentOrElse(fila -> {
            Integer id = Integer.valueOf(ventanaPublicaciones.modelo.getValueAt(ventanaPublicaciones.tablaPublic.getSelectedRow(), 0).toString());

            Publicacion pb = ventanaPublicaciones.publicacionesController.mostrarPublicacion(id);
            vEditarPublicacion.getTxtCargo().setText(pb.getCargo());
 			vEditarPublicacion.getTxtNumeroVacantes().setText(pb.getVacantes().toString());
 			vEditarPublicacion.getTxtTipoEmpleo().setSelectedItem(pb.getTipoEmpleo());
 			vEditarPublicacion.getTxtTipoJornada().setSelectedItem(pb.getTipoJornada());
 			vEditarPublicacion.getTxtExperiencia().setText("1");
 			vEditarPublicacion.getTxtTipoExperiencia().setSelectedItem("Año");
 			vEditarPublicacion.getTxtModalidad().setSelectedItem(pb.getModalidad());	
 			vEditarPublicacion.getTxtFechaExpiracion().setDate(pb.getFechaExpiracion());
 			vEditarPublicacion.getTxtDescripcion().setText(pb.getDescripcion());
        }, null);
	}
}