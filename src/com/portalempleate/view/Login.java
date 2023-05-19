package com.portalempleate.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.portalempleate.controller.UsuarioController;




public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	int xMouse, yMouse;
	private JLabel labelExit;
	public JLabel labelAtras;
	public JPanel btnAtras;
	
	private UsuarioController usuarioController;
	
	/**
	 *  Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(new ImageIcon(getClass().getResource("/com/portalempleate/imgs/iconEmp.png")).getImage());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
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
		panel.setLayout(null);
		
		panel.add(panelHeader());
		panel.add(panelForm());
		panel.add(panelCopyrigth());
		
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
		panelForm.setBounds(0, 45, 788, 482);
		panelForm.setLayout(null);
		
		JLabel labelTitleLogin = new JLabel("Iniciar Sesión");
		labelTitleLogin.setForeground(SystemColor.BLACK);
		labelTitleLogin.setBounds(0, 40, 788, 50);
		labelTitleLogin.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 40));
		labelTitleLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(labelTitleLogin);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setForeground(Color.black);
		labelUsuario.setBounds(200, 150, 400, 20);
		labelUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelUsuario);		
		
		JLabel imgUser = new JLabel();
		imgUser.setBounds(0, 0, 400, 50);
		imgUser.setLayout(null);
		setImageLabel(imgUser, "src/com/portalempleate/imgs/usuario.png");
		imgUser.setBorder(new EmptyBorder(20,10,20,15));
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(new EmptyBorder(0,40,0,10));
		txtUsuario.setPreferredSize(new Dimension(200, 50));
		txtUsuario.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtUsuario.getText().equals("Ingrese su usuario")) {
					txtUsuario.setText("");
					txtUsuario.setForeground(Color.black);
				
				} 
				
				if (String.valueOf(txtContrasena.getPassword()).isEmpty()) {
		        	txtContrasena.setText("*******************");
		        	txtContrasena.setForeground(Color.gray);
		        } 
			}
		});
		
		txtUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtUsuario.setText("Ingrese su usuario");
		txtUsuario.setBackground(new Color(219, 233, 245));
		txtUsuario.setForeground(Color.darkGray);
		txtUsuario.setBounds(200, 180, 400, 50);
		txtUsuario.add(imgUser);
		panelForm.add(txtUsuario);
		
		JLabel imgPassword = new JLabel();
		imgPassword.setBounds(0, 0, 50, 50);
		imgPassword.setLayout(null);
		setImageLabel(imgPassword, "src/com/portalempleate/imgs/cerrar.png");
		imgPassword.setBorder(new EmptyBorder(20,10,20,15));
		
		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setForeground(Color.black);
		labelPassword.setBounds(200, 250, 400, 20);
		labelPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelPassword);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setText("*******************");
		txtContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(txtContrasena.getPassword()).equals("*******************")) {
					txtContrasena.setText("");
					txtContrasena.setForeground(Color.black);
		        }
		        if (txtUsuario.getText().isEmpty()) {
		        	txtUsuario.setText("Ingrese su usuario");
		        	txtUsuario.setForeground(Color.gray);
		        }
			}
			});
		txtContrasena.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtContrasena.setBackground(new Color(219, 233, 245));
		txtContrasena.setForeground(Color.darkGray);
		txtContrasena.setBounds(200, 280, 400, 50);
		txtContrasena.setBorder(new EmptyBorder(0,40,0,10));
		txtContrasena.setPreferredSize(new Dimension(200, 50));
		txtContrasena.add(imgPassword);
		panelForm.add(txtContrasena);
		
		JLabel lblBtnLogin = new JLabel("Iniciar Sesión");
		lblBtnLogin.setBounds(0,0,400,50);
		lblBtnLogin.setForeground(Color.white);
		lblBtnLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnLogin.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 22));
		
		
		JPanel btnLogin = new JPanel();
		btnLogin.setBackground(new Color(50,89,119));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(68,116,148));
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(50,89,119));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Login();
			}
		
		});
		btnLogin.setBounds(200, 360, 400, 50);
		btnLogin.setLayout(null);
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogin.add(lblBtnLogin);	
		panelForm.add(btnLogin);
		
		JLabel lblResset = new JLabel("¿ Olvidaste tu contraseña ?");
		lblResset.setBounds(200, 435, 400, 20);
		lblResset.setForeground(Color.black);
		lblResset.setHorizontalAlignment(SwingConstants.CENTER);
		lblResset.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblResset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblResset.setForeground(new Color(68,116,148));
			} 
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblResset.setForeground(Color.black);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				resset();
			}
		});
		lblResset.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelForm.add(lblResset);
			
		return panelForm;
	}
	

	public JPanel panelCopyrigth() {
		JPanel panelCopyrigth = new JPanel();
		panelCopyrigth.setBackground(new Color(40, 40, 40));
		panelCopyrigth.setBounds(0, 527, 788, 45);
		panelCopyrigth.setLayout(null);
		
		JLabel labelCopyrigth = new JLabel("@santiagomoreno | @germandcb | @nicolaschilito");
		labelCopyrigth.setForeground(SystemColor.LIGHT_GRAY);
		labelCopyrigth.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		labelCopyrigth.setBounds(0, 0, 788, 45);
		labelCopyrigth.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelCopyrigth.add(labelCopyrigth);
		
		return panelCopyrigth;
	}
	
	public void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(
				image.getImage().getScaledInstance(
						22, 22, Image.SCALE_AREA_AVERAGING));
		labelName.setIcon(icon);
		this.repaint();
		
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

	

	private void Login() {		
		//System.out.println(txtUsuario.getText().equals("Ingrese su usuario"));
		//System.out.println(txtContrasena.getPassword().equals("*******************"));
		/*
		if (txtUsuario.getText() == "Ingrese su usuario" || txtContrasena.getText() == "*******************") {
			
			if(usuarioController.login(txtUsuario.getText(), txtContrasena.getText())) {
				
				JOptionPane.showMessageDialog(this, "Ingresaste :)");
			}
			
		} else {
			JOptionPane.showMessageDialog(this, "Por favor, rellenos los campos");
		}
		*/
		this.usuarioController = new UsuarioController();
		if(usuarioController.login(txtUsuario.getText(), txtContrasena.getPassword())) {
			
			if (usuarioController.tipoDeUsuairo(txtUsuario.getText()) == 1) {
				LogicaAspirante logicaAspiratne = new LogicaAspirante(this);
				dispose();
			} 
			else if (usuarioController.tipoDeUsuairo(txtUsuario.getText()) == 2) {
				LogicaEmpleador logicaEmpleador = new LogicaEmpleador(this);
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Ocurrio un Error inesperado");
			}			
			
		} else {
			JOptionPane.showMessageDialog(this, "Campos incorectos");
		}
	}
	
	protected void resset() {
		// TODO Auto-generated method stub
		
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}
	
	
	
}
