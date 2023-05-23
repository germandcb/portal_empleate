package com.portalempleate.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.portalempleate.controller.PublicacionController;
import com.portalempleate.modelos.Publicacion;
import com.portalempleate.recursos.PanelAction;
import com.portalempleate.recursos.RenderTable;
import com.portalempleate.recursos.TableActionCellEditor;
import com.portalempleate.recursos.TableActionCellRender;
import com.portalempleate.recursos.TableActionEvent;

public class VentanaPublicaciones extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse, AliVertical1 = 65, AliVertical2 = 135, AliVertical3 = 205, AliVertical4 = 275;
	private JLabel labelExit;
	public JTable tablaPublic;
	public DefaultTableModel modelo;
	public JScrollPane scrollPane;
	
	public JLabel labelAtras;
    public JPanel btnAtras;
    public JPanel btnRegistrar;
    public TableActionEvent event;
	
    public PublicacionController publicacionesController;
	/**
	 *  Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*
				try {
					JFrame frame = new VentanaPublicaciones("100000102");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} */
			}
		});
	}
	
	/**
	 * Create the frame 
	 */
	public VentanaPublicaciones(String id) {
		this.publicacionesController = new PublicacionController();
		setIconImage(new ImageIcon(getClass().getResource("/com/portalempleate/imgs/iconEmp.png")).getImage());
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 788, 572);
		
		contentPane = new JPanel(); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		contentPane.add(panelMain(id));
		
		
	}
	
	public JPanel panelMain(String id) {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 788, 572);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel.add(panelHeader());
		panel.add(panelContent(id));
		
		JPanel headerMove = new JPanel();
		headerMove.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		headerMove.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		headerMove.setBackground(SystemColor.window);
		headerMove.setBounds(0, 0, 784, 36);
		panel.add(headerMove);
		headerMove.setLayout(null);
		
		return panel;
	}
	
	public JPanel panelHeader() {
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 788, 45);
		panel_1.setLayout(null);
		
		JPanel btnexit = new JPanel();
		btnexit.setBounds(748, 0, 55, 45);
		panel_1.add(btnexit);
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(new Color(68, 116, 148));
				labelExit.setForeground(Color.white);
			}
		});
		btnexit.setBackground(new Color(68, 116, 148));
		btnexit.setLayout(null);
		btnexit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 40, 45);
		btnexit.add(labelExit);
		labelExit.setForeground(SystemColor.text);
		labelExit.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setVerticalAlignment(SwingConstants.CENTER);
		
		btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			/*
			@Override
			public void mouseClicked(MouseEvent e) {
				Home frame = new Home();
				frame.setVisible(true);
				dispose();
			}
			*/
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(68, 116, 148));
				labelAtras.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 55, 45);
		panel_1.add(btnAtras);

		labelAtras = new JLabel("<-");
		labelAtras.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		labelAtras.setBounds(0, 0, 55, 45);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setVerticalAlignment(SwingConstants.CENTER);
		
		return panel_1;
	}
	
	public JPanel panelContent(String id) {
		JPanel panelContent = new JPanel();
		panelContent.setBackground(new Color(255, 255, 255));
		panelContent.setBounds(0, 45, 788, 572);
		panelContent.setLayout(new FlowLayout());
		
		//TITULO DE LA VENTANA
		JLabel labelTitleLogin = new JLabel("Mis Publicaciones");
		labelTitleLogin.setForeground(SystemColor.BLACK);
		//labelTitleLogin.setBounds(0, 5, 788, 50);
		labelTitleLogin.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 40));
		labelTitleLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panelContent.add(labelTitleLogin);//Fin del titulo
		
		tablaPublic = new JTable();
		tablaPublic.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		//tablaPublic.setBounds(100,150,500,100);
				
		String[] columnas = {"ID", "Cargo", "Tipo", "Desde", "Hasta","Opciones"};
		
		modelo = (DefaultTableModel) tablaPublic.getModel();
		//modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(columnas);
		
		listarPublicaciones(id);
		
						
		this.tablaPublic.setDefaultRenderer(Object.class, new RenderTable());
		
		
		tablaPublic.setModel(modelo);
		tablaPublic.setBackground(Color.white);
		tablaPublic.setSelectionBackground(new Color(68, 116, 148));
		tablaPublic.setSelectionForeground(Color.white);;
		
		//Estilos Cabecera de la tabla
		tablaPublic.getTableHeader().setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		tablaPublic.getTableHeader().setForeground(Color.white);
		tablaPublic.getTableHeader().setBackground(Color.black);
		tablaPublic.getTableHeader().setAlignmentX(JTable.CENTER_ALIGNMENT);
		
		 // Personalizar el renderizado de celdas para centrar los registros
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tablaPublic.setDefaultRenderer(Object.class, centerRenderer);
		
		tablaPublic.setRowHeight(40);
		tablaPublic.setShowVerticalLines(false);
		/*
		TableColumn columna_aux = tablaPublic.getColumn("Opciones");
		columna_aux.setPreferredWidth(150);
		*/
		JScrollPane scrollPane = new JScrollPane(tablaPublic);
		scrollPane.setPreferredSize(new Dimension(700, 440));
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.white)); // Borde
        scrollPane.setBackground(Color.WHITE); // Color de fondo
        scrollPane.getViewport().setBackground(Color.white); // Color de fondo del área de vista

		
		panelContent.add(tablaPublic.getTableHeader());
		panelContent.add(scrollPane);
		scrollPane.revalidate();
		
		return panelContent;
	}
	

	public void listarPublicaciones(String id) {		
		List<Publicacion> listaPublicaciones = publicacionesController.listar(id);
		try {
			for(Publicacion publicacion : listaPublicaciones) {
				modelo.addRow(new Object[]{
						publicacion.getPublicacionId(),
						publicacion.getCargo(),  
						publicacion.getTipoEmpleo(),
						publicacion.getFechaPublicacion(), 
						publicacion.getFechaExpiracion()
						});
				tablaPublic.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
				tablaPublic.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(tableroEventos()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listarPublicaciones() {
		//ArrayList<Publicacion> listaPublicaciones = new ArrayList<Publicacion>();
		/*
		Date fecha = new Date();
		listaPublicaciones.add(new Publicacion("Tecnico", 10, "Practicas", fecha,  true));
		listaPublicaciones.add(new Publicacion("Tecnico", 10, "Practicas", fecha,  true));
		

		TableActionEvent event = new TableActionEvent() {
			@Override
			public void onView(int row) {
				System.out.println("Edit row : " + row);				
			}
			
			@Override
			public void onEdit(int row) {
				System.out.println("Delet row : " + row);
			}
			
			@Override
			public void onDelete(int row) {
				System.out.println("View row : " + row);
				if (tablaPublic.isEditing()) {
					tablaPublic.getCellEditor().stopCellEditing();
				}
				DefaultTableModel model = (DefaultTableModel) tablaPublic.getModel();
				model.removeRow(row);
			}
		};
		
		for(Publicacion item: listaPublicaciones) {
			modelo.addRow(new Object[]{item.getCargo(), item.getVacantes(), item.getTipoEmpleo(),
					item.getFechaPublicacion(), item.isEstado()});
			tablaPublic.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
			tablaPublic.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
		}
		
		*/
		
		List<Publicacion> listaPublicaciones = this.publicacionesController.listar();
		try {
			for(Publicacion publicacion : listaPublicaciones) {
				modelo.addRow(new Object[]{
						publicacion.getPublicacionId(),
						publicacion.getCargo(),  
						publicacion.getTipoEmpleo(),
						publicacion.getFechaPublicacion(), 
						publicacion.getFechaExpiracion()
						});
				tablaPublic.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
				tablaPublic.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(tableroEventos()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	
	public TableActionEvent tableroEventos() {
		
		/*
		event = new TableActionEvent() {
			@Override
			public void onView(int row) {
				System.out.println("View row : " + row);
				if (tablaPublic.isEditing()) {
					tablaPublic.getCellEditor().stopCellEditing();
				}
				obtenerDatosPublicacion(row);
			}
			
			@Override
			public void onEdit(int row) {}
			
			@Override
			public void onDelete(int row) {
				System.out.println("Delete row : " + row);
				if (tablaPublic.isEditing()) {
					tablaPublic.getCellEditor().stopCellEditing();
				}
				
				eliminarPublicacion(row);
				
			}
		}; */
		return event;
	}
	
	public void eliminarPublicacion(int row) {
		//DefaultTableModel model = (DefaultTableModel) tablaPublic.getModel();
		
		 int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas eleminar la publicacion?", "Confirmación", JOptionPane.YES_NO_OPTION);
	        
	     if (respuesta == JOptionPane.YES_OPTION) {
	         System.out.println("El usuario seleccionó 'Sí'");
	         Optional.ofNullable(modelo.getValueAt(tablaPublic.getSelectedRow(), tablaPublic.getSelectedColumn()))
	 		.ifPresentOrElse(fila -> {
	 			Integer id = Integer.valueOf(modelo.getValueAt(tablaPublic.getSelectedRow(), 0).toString());
	 			
	 			var filasModificadas =  this.publicacionesController.eliminar(id);
	 			
	 			modelo.removeRow(row);
	 			
	 			JOptionPane.showMessageDialog(this,
	                     String.format("%d item eliminado con éxito!", filasModificadas));
	 		}, null);;
	 		//model.removeRow(row);
	     } else {
	         System.out.println("El usuario seleccionó 'No'");
	     }
	}
	
	public void obtenerDatosPublicacion(int row) {
	    // DefaultTableModel model = (DefaultTableModel) tablaPublic.getModel();
		
		if(tieneFilaElegida(tablaPublic)) {
			JOptionPane.showMessageDialog(this, "Por favor, elije un registro");
			return;
		}
		
	    Optional.ofNullable(modelo.getValueAt(tablaPublic.getSelectedRow(), tablaPublic.getSelectedColumn()))
	            .ifPresentOrElse(fila -> {
	                Integer id = Integer.valueOf(modelo.getValueAt(tablaPublic.getSelectedRow(), 0).toString());

	                Publicacion pb = this.publicacionesController.mostrarPublicacion(id);

	                String mensaje =  "Cargo : " + pb.getCargo() + "\n"
	                        + "N° Vacantes : " + pb.getVacantes() + "\n"
	                        + "Contratante : " + pb.getContratante() + "\n"
	                        + "Tipo Empleo : " + pb.getTipoEmpleo() + "\n"
	                        + "Tipo Jornada : " + pb.getTipoJornada() + "\n"
	                        + "Experiencia : " + pb.getExperiencia() + "\n"
	                        + "Modalidad : " + pb.getModalidad() + "\n"
	                        + "Fecha Publicación " + pb.getFechaPublicacion() + "\n"
	                        + "Fecha Expiración: " + pb.getFechaExpiracion() + "\n"
	                        + "Descripción : " + pb.getDescripcion() + "\n";

	              JOptionPane.showMessageDialog(null, mensaje, "Datos de publicación", JOptionPane.INFORMATION_MESSAGE);
	      }, null);
	}
	
	

	
	
	private boolean tieneFilaElegida(JTable tb) {
		return tb.getSelectedRowCount() == 0 || tb.getSelectedColumnCount() == 0;
	}
	
	public JPanel panelActioin() {
		JPanel panelAction = new JPanel();
		return panelAction;
	}

	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
}

}
