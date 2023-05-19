package com.portalempleate.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;

import com.toedter.calendar.JDateChooser;


public class Ventana2SigninEmpleador extends JFrame {

	private JPanel contentPane;
	private JTextField txtTelefonofijo, txtCorreo;
	private JDateChooser txtFechanac;
    private JPasswordField txtContrasena;
	int xMouse, yMouse;
	private JLabel labelExit;
	
	public JLabel labelAtras;
	public JPanel btnAtras;
	
	public JPanel btnNext;
	
	/**
	 *  Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new Ventana2SigninEmpleador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame 
	 */
	public Ventana2SigninEmpleador() {
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
		headerMove.setBounds(0, 0, 788, 36);
		panel.add(headerMove);
		headerMove.setLayout(null);
		
		return panel;
	}
	
	public JPanel panelHeader() {
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 788, 60);
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
		panelForm.setBounds(0, 45, 788, 525);
		panelForm.setLayout(null);
		

		//TITULO DE LA VENTANA
		JLabel labelTitleLogin = new JLabel("Registrarse Como Empleador");
		labelTitleLogin.setForeground(SystemColor.BLACK);
		labelTitleLogin.setBounds(0, 5, 788, 50);
		labelTitleLogin.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 40));
		labelTitleLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(labelTitleLogin);//Fin del titulo
		
        //CAMPO PARA LA EXTENSION DE NUMERO FIJO
		JLabel labelExtensioncelular = new JLabel("+601");
		labelExtensioncelular.setBackground(new Color(219, 233, 245));
		labelExtensioncelular.setForeground(Color.darkGray);
		labelExtensioncelular.setBounds(0, 105, 400, 20);
		labelExtensioncelular.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		labelExtensioncelular.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(labelExtensioncelular);//Fin de la extension de fijo
		
		//CAMPO PARA EL NUMERO FIJO
		JLabel labelTelfijo = new JLabel("Teléfono Fijo");//Titulo
		labelTelfijo.setForeground(Color.black);
		labelTelfijo.setBounds(250, 65, 375, 20);
		labelTelfijo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelTelfijo);//Fin del titulo
		txtTelefonofijo = new JTextField();//Campo de texto
		txtTelefonofijo.setBorder(new EmptyBorder(0,10,0,10));
		txtTelefonofijo.setPreferredSize(new Dimension(10, 50));
		txtTelefonofijo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtTelefonofijo.setBackground(new Color(219, 233, 245));
		txtTelefonofijo.setForeground(Color.darkGray);
		txtTelefonofijo.setBounds(250, 90, 375, 50);
		panelForm.add(txtTelefonofijo);//Fin del campo de texto
		//Fin del numero fijo

		//CAMPO PARA LA FECHA DE NACIMIENTO
		JLabel labelFechanacimiento = new JLabel("Fecha de Nacimiento");//Titulo
		labelFechanacimiento .setForeground(Color.black);
		labelFechanacimiento .setBounds(175, 155, 225, 20);
		labelFechanacimiento .setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelFechanacimiento );//Fin del titulo
		txtFechanac = new JDateChooser();
		txtFechanac.setBounds(175, 185, 450, 50);
		txtFechanac.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechanac.setDateFormatString("yyyy-MM-dd");
		txtFechanac.setForeground(Color.darkGray);
		txtFechanac.setBackground(new Color(219, 233, 245));
		txtFechanac.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtFechanac.setPreferredSize(new Dimension(10, 50));
		txtFechanac.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelForm.add(txtFechanac);//Fin del campo de texto
		//Fin de la fecha de nacimiento

		//CAMPO PARA EL CORREO
		JLabel labelCorreo = new JLabel("Correo Electrónico");//Titulo
		labelCorreo.setForeground(Color.black);
		labelCorreo.setBounds(175, 245, 225, 20);
		labelCorreo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelCorreo);//Fin del titulo
		txtCorreo = new JTextField();//Campo de texto
		txtCorreo.setBorder(new EmptyBorder(0,10,0,10));
		txtCorreo.setPreferredSize(new Dimension(10, 50));
		txtCorreo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtCorreo.setBackground(new Color(219, 233, 245));
		txtCorreo.setForeground(Color.darkGray);
		txtCorreo.setBounds(175, 270, 450, 50);
		panelForm.add(txtCorreo);//Fin del campo de texto
		//Fin del correo

        //CAMPO PARA LA CONTRASEÑA
        JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setForeground(Color.black);
		labelPassword.setBounds(175, 335, 400, 20);
		labelPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelPassword);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtContrasena.setBackground(new Color(219, 233, 245));
		txtContrasena.setForeground(Color.darkGray);
		txtContrasena.setBounds(175, 360, 450, 50);
		txtContrasena.setBorder(new EmptyBorder(0,10,0,10));
		txtContrasena.setPreferredSize(new Dimension(200, 50));
		panelForm.add(txtContrasena);
        //fin de la contraseña

		//BOTON "SIGUIENTE"
		JLabel lblBtnNext = new JLabel("Siguiente");
		lblBtnNext.setBounds(0,0,200,50);
		lblBtnNext.setForeground(Color.white);
		lblBtnNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnNext.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 22));
		
		
		btnNext = new JPanel();
		btnNext.setBackground(new Color(50,89,119));
		btnNext.addMouseListener(
			new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnNext.setBackground(new Color(68,116,148));
				}
		
				@Override
				public void mouseExited(MouseEvent e) {
					btnNext.setBackground(new Color(50,89,119));
				}
				/*
				@Override
				public void mouseClicked(MouseEvent e) {
					Ventana3SigninEmpleador frame = new Ventana3SigninEmpleador();
					frame.setVisible(true);
					dispose();
				}
				*/
			}
		);
		btnNext.setBounds(300, 450, 200, 50);
		btnNext.setLayout(null);
		btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//btnLogin.setBorder(new LineBorder(Color.white, 10, true));
		btnNext.add(lblBtnNext);	
		panelForm.add(btnNext);
		//fin del boton "siguiente"
			
		return panelForm;
	}
	
	/*public void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(
				image.getImage().getScaledInstance(
						22, 22, Image.SCALE_AREA_AVERAGING));
		labelName.setIcon(icon);
		this.repaint();
		
	}*/
	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }

    public boolean validarCampos() {
        if (!txtTelefonofijo.getText().equals("") && !txtCorreo.getText().equals("") && txtFechanac.getDate() != null
                && !txtContrasena.getText().equals("")) {

            if (esCorreoElectronicoValido(txtCorreo.getText()) && txtTelefonofijo.getText().matches("\\d+")) {
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Verifique el tipo de dato ingresado");
                return false;
            }
        }
        return false;
    }
    
    public boolean esCorreoElectronicoValido(String correo) {
        // La expresión regular para validar correos electrónicos
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        
        // Compilar la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);
        
        // Crear un objeto Matcher para la cadena de texto
        Matcher matcher = pattern.matcher(correo);
        
        // Devolver true si la cadena coincide con la expresión regular
        return matcher.matches();
    }

	public JTextField getTxtTelefonofijo() {
		return txtTelefonofijo;
	}

	public void setTxtTelefonofijo(JTextField txtTelefonofijo) {
		this.txtTelefonofijo = txtTelefonofijo;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JDateChooser getTxtFechanac() {
		return txtFechanac;
	}

	public void setTxtFechanac(JDateChooser txtFechanac) {
		this.txtFechanac = txtFechanac;
	}

	public JPasswordField getTxtContrasena() {
		return txtContrasena;
	}

	public void setTxtContrasena(JPasswordField txtContrasena) {
		this.txtContrasena = txtContrasena;
	}
    
}
