package com.portalempleate.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.Format;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class VentanaEditarPublicacion extends JFrame {

	private JPanel contentPane;
	private JTextArea txtDescripcion;
	private String tipoexperienciastring;
	private JTextField 
		txtCargo, 
		txtNumeroVacantes, 
		txtExperiencia,
		txtNumcelular;
	private JDateChooser txtFechaExpiracion;
	private JComboBox<Format> 
		txtModalidad, 
		txtTipoEmpleo,
		txtTipoExperiencia,
		txtTipoJornada;
	int xMouse, yMouse, AliVertical1 = 65, AliVertical2 = 135, AliVertical3 = 205, AliVertical4 = 275;
	private JLabel labelExit;
	
	public JLabel labelAtras;
    public JPanel btnAtras;
    public JPanel btnActualizar;
	
	/**
	 *  Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					JFrame frame = new VentanaEditarPublicacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}
	
	/**
	 * Create the frame 
	 * @param id 
	 */
	public VentanaEditarPublicacion() {
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
		
		contentPane.add(panelMain());
				
		
	}
	
	public JPanel panelMain() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 788, 572);
		//panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel.add(panelHeader());
		panel.add(panelForm());
		
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
	
	public JPanel panelForm() {
		JPanel panelForm = new JPanel();
		panelForm.setBackground(new Color(255, 255, 255));
		panelForm.setBounds(0, 45, 788, 527);
		panelForm.setLayout(null);
		

		//TITULO DE LA VENTANA
		JLabel labelTitleLogin = new JLabel("Editar Publicacion");
		labelTitleLogin.setForeground(SystemColor.BLACK);
		labelTitleLogin.setBounds(0, 5, 788, 50);
		labelTitleLogin.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 40));
		labelTitleLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(labelTitleLogin);//Fin del titulo
		
		//CAMPO PARA CARGO DEL ASPIRANTE
		JLabel labelCargo = new JLabel("Cargo del Aspirante");//Titulo
		labelCargo.setForeground(Color.black);
		labelCargo.setBounds(100, AliVertical1, 400, 20);
		labelCargo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelCargo);//Fin del titulo
		txtCargo = new JTextField();
		txtCargo.setBorder(new EmptyBorder(0,10,0,10));
		txtCargo.setPreferredSize(new Dimension(10, 50));
		txtCargo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtCargo.setBackground(new Color(219, 233, 245));
		txtCargo.setForeground(Color.darkGray);
		txtCargo.setBounds(100, (AliVertical1+25), 360, 40);
		panelForm.add(txtCargo);
		//Fin del cargo de aspirante

		//CANTIDAD DE VACANTES
		JLabel labelCantidadVacantes = new JLabel("Cantidad de vacantes");//Titulo
		labelCantidadVacantes.setForeground(Color.black);
		labelCantidadVacantes.setBounds(500, AliVertical1, 400, 20);
		labelCantidadVacantes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelCantidadVacantes);//Fin del titulo
		txtNumeroVacantes = new JTextField();
		txtNumeroVacantes.setBorder(new EmptyBorder(0,10,0,10));
		txtNumeroVacantes.setPreferredSize(new Dimension(10, 50));
		txtNumeroVacantes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtNumeroVacantes.setBackground(new Color(219, 233, 245));
		txtNumeroVacantes.setForeground(Color.darkGray);
		txtNumeroVacantes.setBounds(500, (AliVertical1+25), 200, 40);
		panelForm.add(txtNumeroVacantes);

		//TIPO DE EMPLEO
		JLabel labelTipoEmpleo = new JLabel("Tipo de Empleo");//Titulo
		labelTipoEmpleo.setForeground(Color.black);
		labelTipoEmpleo.setBounds(100, AliVertical2, 200, 20);
		labelTipoEmpleo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelTipoEmpleo);//Fin del titulo
		txtTipoEmpleo = new JComboBox();
		txtTipoEmpleo.setBackground(new Color(219, 233, 245));
		txtTipoEmpleo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtTipoEmpleo.setModel(new DefaultComboBoxModel(new String[] { "Trabajo Común", "Pasantías", "Practicante" }));
		txtTipoEmpleo.setBounds(100, (AliVertical2+25), 150, 40);
		panelForm.add(txtTipoEmpleo);


		//TIPO DE JORNADA
		JLabel labelTipoJornada = new JLabel("Tipo de Jornada");//Titulo
		labelTipoJornada.setForeground(Color.black);
		labelTipoJornada.setBounds(275, AliVertical2, 200, 20);
		labelTipoJornada.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelTipoJornada);//Fin del titulo
		txtTipoJornada = new JComboBox();
		txtTipoJornada.setBounds(275, (AliVertical2+25), 200, 40);
		txtTipoJornada.setBackground(new Color(219, 233, 245));
		txtTipoJornada.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtTipoJornada.setModel(new DefaultComboBoxModel(new String[] { "Completa", "Medio Tiempo", "Sabatino", "Por Horas" }));
		panelForm.add(txtTipoJornada);

		//EXPERIENCIA
		JLabel labelExperiencia= new JLabel("Experiencia");//Titulo
		labelExperiencia.setForeground(Color.black);
		labelExperiencia.setBounds(500, AliVertical2, 300, 20);
		labelExperiencia.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelExperiencia);//Fin del titulo
		txtExperiencia = new JTextField();
		txtExperiencia.setBorder(new EmptyBorder(0,10,0,10));
		txtExperiencia.setPreferredSize(new Dimension(10, 50));
		txtExperiencia.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtExperiencia.setBackground(new Color(219, 233, 245));
		txtExperiencia.setForeground(Color.darkGray);
		txtExperiencia.setBounds(500, AliVertical2+25, 50, 40);
		panelForm.add(txtExperiencia);
		txtTipoExperiencia= new JComboBox();
		txtTipoExperiencia.setBounds(560, AliVertical2+25, 100, 40);
		txtTipoExperiencia.setBackground(new Color(219, 233, 245));
		txtTipoExperiencia.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtTipoExperiencia.setModel(new DefaultComboBoxModel(new String[] { "Ninguna","Meses", "Años"}));
		panelForm.add(txtTipoExperiencia);

		//MODALIDAD
		JLabel labelModalidad = new JLabel("Modalidad");//Titulo
		labelModalidad.setForeground(Color.black);
		labelModalidad.setBounds(100, AliVertical3, 200, 20);
		labelModalidad.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelModalidad);//Fin del titulo
		txtModalidad = new JComboBox();
		txtModalidad.setBackground(new Color(219, 233, 245));
		txtModalidad.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtModalidad.setModel(new DefaultComboBoxModel(new String[] { "Presencial", "Remoto", "Híbrido" }));
		txtModalidad.setBounds(100, (AliVertical3+25), 150, 40);
		panelForm.add(txtModalidad);
		
		//FECHA DE EXPIRACION DE LA PUBLICACION
		JLabel labelFechaExpiracion = new JLabel("Fecha de Expiracion");//Titulo
		labelFechaExpiracion.setForeground(Color.black);
		labelFechaExpiracion.setBounds(300, AliVertical3, 225, 20);
		labelFechaExpiracion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelFechaExpiracion);//Fin del titulo
		txtFechaExpiracion = new JDateChooser();
        txtFechaExpiracion.setBounds(300, AliVertical3+25, 400, 40);
        txtFechaExpiracion.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaExpiracion.setDateFormatString("yyyy-MM-dd");
		txtFechaExpiracion.setForeground(Color.darkGray);
		txtFechaExpiracion.setBackground(new Color(219, 233, 245));
		txtFechaExpiracion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtFechaExpiracion.setPreferredSize(new Dimension(10, 50));
		txtFechaExpiracion.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelForm.add(txtFechaExpiracion);//Fin del campo de texto
		
		//DECRIPCION DE LA PUBLICACION
		JLabel labelDescripcion= new JLabel("Descripción de la Oferta de Trabajo");//Titulo
		labelDescripcion.setForeground(Color.black);
		labelDescripcion.setBounds(100, AliVertical4, 300, 20);
		labelDescripcion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelDescripcion);//Fin del titulo
		txtDescripcion = new JTextArea();
		txtDescripcion.setBorder(new EmptyBorder(0,5,0,5));
		txtDescripcion.setPreferredSize(new Dimension(10, 50));
		txtDescripcion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtDescripcion.setBackground(new Color(219, 233, 245));
		txtDescripcion.setForeground(Color.darkGray);
		txtDescripcion.setBounds(100, AliVertical4+25, 600, 150);
		txtDescripcion.setLineWrap(true); // Habilita el salto de línea automático
        txtDescripcion.setWrapStyleWord(true);
		panelForm.add(txtDescripcion);


		//BOTON DE REGISTRAR
		JLabel lblRegistrar = new JLabel("Actualizar Publicacion");
		lblRegistrar.setBounds(0,0,230,50);
		lblRegistrar.setForeground(Color.white);
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 22));
		
		
		btnActualizar = new JPanel();
		btnActualizar.setBackground(new Color(50,89,119));
		btnActualizar.addMouseListener(
			new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnActualizar.setBackground(new Color(68,116,148));
				}
		
				@Override
				public void mouseExited(MouseEvent e) {
					btnActualizar.setBackground(new Color(50,89,119));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					//NO SE Q SE COLOCA AQUI JAJA
				}
		
			}
		);
		btnActualizar.setBounds(285, 460, 230, 50);
		btnActualizar.setLayout(null);
		btnActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnActualizar.add(lblRegistrar);	
		panelForm.add(btnActualizar);
		//fin del boton "siguiente"
			
		return panelForm;
	}

	//METODO PARA VALIDAR QUE LOS DATOS INGRESADOS SEAN CORRECTOS
	public boolean validarCampos() {
		
        if (!txtCargo.getText().equals("") && !txtDescripcion.getText().equals("")) {
				if(!txtTipoExperiencia.getSelectedItem().equals("Ninguna") && txtExperiencia.getText().matches("\\d+") & txtNumeroVacantes.getText().matches("\\d+")){
					return true;
				}
				else{
					JOptionPane.showMessageDialog(this, "Verifique los datos ingresados");
                	return false;
				}
            
            } else {
                JOptionPane.showMessageDialog(this, "Rellene todos los campos ");
                return false;
        }
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

	public JTextArea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(JTextArea txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public String getTipoexperienciastring() {
		return tipoexperienciastring;
	}

	public void setTipoexperienciastring(String tipoexperienciastring) {
		this.tipoexperienciastring = tipoexperienciastring;
	}

	public JTextField getTxtCargo() {
		return txtCargo;
	}

	public void setTxtCargo(JTextField txtCargo) {
		this.txtCargo = txtCargo;
	}

	public JTextField getTxtNumeroVacantes() {
		return txtNumeroVacantes;
	}

	public void setTxtNumeroVacantes(JTextField txtNumeroVacantes) {
		this.txtNumeroVacantes = txtNumeroVacantes;
	}

	public JTextField getTxtExperiencia() {
		return txtExperiencia;
	}

	public void setTxtExperiencia(JTextField txtExperiencia) {
		this.txtExperiencia = txtExperiencia;
	}

	public JTextField getTxtNumcelular() {
		return txtNumcelular;
	}

	public void setTxtNumcelular(JTextField txtNumcelular) {
		this.txtNumcelular = txtNumcelular;
	}

	public JDateChooser getTxtFechaExpiracion() {
		return txtFechaExpiracion;
	}

	public void setTxtFechaExpiracion(JDateChooser txtFechaExpiracion) {
		this.txtFechaExpiracion = txtFechaExpiracion;
	}

	public JComboBox<Format> getTxtModalidad() {
		return txtModalidad;
	}

	public void setTxtModalidad(JComboBox<Format> txtModalidad) {
		this.txtModalidad = txtModalidad;
	}

	public JComboBox<Format> getTxtTipoEmpleo() {
		return txtTipoEmpleo;
	}

	public void setTxtTipoEmpleo(JComboBox<Format> txtTipoEmpleo) {
		this.txtTipoEmpleo = txtTipoEmpleo;
	}

	public JComboBox<Format> getTxtTipoExperiencia() {
		return txtTipoExperiencia;
	}

	public void setTxtTipoExperiencia(JComboBox<Format> txtTipoExperiencia) {
		this.txtTipoExperiencia = txtTipoExperiencia;
	}

	public JComboBox<Format> getTxtTipoJornada() {
		return txtTipoJornada;
	}

	public void setTxtTipoJornada(JComboBox<Format> txtTipoJornada) {
		this.txtTipoJornada = txtTipoJornada;
	}

}
