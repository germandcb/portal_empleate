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
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;


public class Ventana3SigninEmpleador extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombrecomercial, txtNit, txtRazonsocial, txtTiposervicio;
	int xMouse, yMouse;
	private JLabel labelExit;
	
	public JLabel labelAtras;
	public JPanel btnAtras;
	
	public JPanel registarEmpleador;
	
	/**
	 *  Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new Ventana3SigninEmpleador();
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
	public Ventana3SigninEmpleador() {
		setIconImage(new ImageIcon(getClass().getResource("/com/portalempleate/imgs/iconEmp.png")).getImage());
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			@Override
			public void mouseClicked(MouseEvent e) {
				Home frame = new Home();
				frame.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(68, 116, 148));
				labelAtras.setForeground(Color.white);
			}
/*
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}*/
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
		
        //CAMPO PARA EL NOMBRE COMERCIAL
		JLabel labelNombrecomercial = new JLabel("Nombre Comercial de la Empresa");//Titulo
		labelNombrecomercial .setForeground(Color.black);
		labelNombrecomercial .setBounds(175, 65, 600, 20);
		labelNombrecomercial .setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelNombrecomercial );//Fin del titulo
		txtNombrecomercial = new JTextField();//Campo de texto
		txtNombrecomercial.setBorder(new EmptyBorder(0,10,0,10));
		txtNombrecomercial.setPreferredSize(new Dimension(10, 50));
		txtNombrecomercial.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtNombrecomercial.setBackground(new Color(219, 233, 245));
		txtNombrecomercial.setForeground(Color.darkGray);
		txtNombrecomercial.setBounds(175, 90, 450, 50);
		panelForm.add(txtNombrecomercial);//Fin del campo de texto
		//Fin de el nombre comercial

		//CAMPO PARA EL NIT
		JLabel LabelNit = new JLabel("NIT de la Empresa");//Titulo
		LabelNit.setForeground(Color.black);
		LabelNit.setBounds(175, 155, 225, 20);
		LabelNit.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(LabelNit);//Fin del titulo
		txtNit = new JTextField();//Campo de texto
		txtNit.setBorder(new EmptyBorder(0,10,0,10));
		txtNit.setPreferredSize(new Dimension(10, 50));
		txtNit.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtNit.setBackground(new Color(219, 233, 245));
		txtNit.setForeground(Color.darkGray);
		txtNit.setBounds(175, 180, 450, 50);
		panelForm.add(txtNit);//Fin del campo de texto
		//Fin de la nit

		//CAMPO PARA LA RAZON SOCIAL
		JLabel labelRazonsocial = new JLabel("Razón Social");//Titulo
		labelRazonsocial.setForeground(Color.black);
		labelRazonsocial.setBounds(175, 245, 225, 20);
		labelRazonsocial.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelRazonsocial);//Fin del titulo
		txtRazonsocial = new JTextField();//Campo de texto
		txtRazonsocial.setBorder(new EmptyBorder(0,10,0,10));
		txtRazonsocial.setPreferredSize(new Dimension(10, 50));
		txtRazonsocial.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtRazonsocial.setBackground(new Color(219, 233, 245));
		txtRazonsocial.setForeground(Color.darkGray);
		txtRazonsocial.setBounds(175, 270, 450, 50);
		panelForm.add(txtRazonsocial);//Fin del campo de texto
		//Fin de la razon social

        //CAMPO PARA EL TIPO DE SERVICIO
        JLabel labelTiposervicio = new JLabel("Tipo de Servicio");
		labelTiposervicio.setForeground(Color.black);
		labelTiposervicio.setBounds(175, 335, 400, 20);
		labelTiposervicio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelTiposervicio);
		
		txtTiposervicio = new JTextField();
		txtTiposervicio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtTiposervicio.setBackground(new Color(219, 233, 245));
		txtTiposervicio.setForeground(Color.darkGray);
		txtTiposervicio.setBounds(175, 360, 450, 50);
		txtTiposervicio.setBorder(new EmptyBorder(0,10,0,10));
		txtTiposervicio.setPreferredSize(new Dimension(200, 50));
		panelForm.add(txtTiposervicio);
        //fin de la contraseña

		//BOTON "SIGUIENTE"
		JLabel lblBtnNext = new JLabel("Registrarse");
		lblBtnNext.setBounds(0,0,200,50);
		lblBtnNext.setForeground(Color.white);
		lblBtnNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnNext.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 22));
		
		
		registarEmpleador = new JPanel();
		registarEmpleador.setBackground(new Color(50,89,119));
		registarEmpleador.addMouseListener(
			new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					registarEmpleador.setBackground(new Color(68,116,148));
				}
		
				@Override
				public void mouseExited(MouseEvent e) {
					registarEmpleador.setBackground(new Color(50,89,119));
				}
				/*
				@Override
				public void mouseClicked(MouseEvent e) {
					
				} */
		
			}
		);
		registarEmpleador.setBounds(300, 450, 200, 50);
		registarEmpleador.setLayout(null);
		registarEmpleador.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//btnLogin.setBorder(new LineBorder(Color.white, 10, true));
		registarEmpleador.add(lblBtnNext);	
		panelForm.add(registarEmpleador);
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
        if (!txtNombrecomercial.getText().equals("") && !txtNit.getText().equals("") && !txtRazonsocial.getText().equals("")
                && !txtTiposervicio.getText().equals("")) {
        	
        	System.out.println(txtNit.getText().matches("\\d+"));
        	
            if (txtNit.getText().matches("\\d+")) {
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Verifique el tipo de dato ingresado");
                return false;
            }
        }
        return false;
    }

	public JTextField getTxtNombrecomercial() {
		return txtNombrecomercial;
	}

	public void setTxtNombrecomercial(JTextField txtNombrecomercial) {
		this.txtNombrecomercial = txtNombrecomercial;
	}

	public JTextField getTxtNit() {
		return txtNit;
	}

	public void setTxtNit(JTextField txtNit) {
		this.txtNit = txtNit;
	}

	public JTextField getTxtRazonsocial() {
		return txtRazonsocial;
	}

	public void setTxtRazonsocial(JTextField txtRazonsocial) {
		this.txtRazonsocial = txtRazonsocial;
	}

	public JTextField getTxtTiposervicio() {
		return txtTiposervicio;
	}

	public void setTxtTiposervicio(JTextField txtTiposervicio) {
		this.txtTiposervicio = txtTiposervicio;
	}
    
    
	
}
