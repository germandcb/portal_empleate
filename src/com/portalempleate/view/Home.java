package com.portalempleate.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame{

	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel labelExit;
	
	/**
	 * Launch the aplication
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		// Propiedades de la ventana
		setIconImage(new ImageIcon(getClass().getResource("/com/portalempleate/imgs/iconEmp.png")).getImage());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		setBounds(100, 100, 788, 572);
		
		// Contenedor 
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
		panel.setLayout(null);
		
		panel.add(panelHeader());
		panel.add(panelBody());
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
		return panel_1;
	}
	
	private JPanel panelBody() {
		JPanel panelBody = new JPanel();
		panelBody.setBackground(new Color(255, 255, 255));
		panelBody.setBounds(0, 45, 788, 482);
		panelBody.setLayout(null);
		
		JLabel imgIcon = new JLabel();
		imgIcon.setBounds(330, 20, 100, 100);
		imgIcon.setLayout(null);
		setImageLabel(imgIcon, "src/com/portalempleate/imgs/iconEp.png");
		panelBody.add(imgIcon);
		
		JLabel labelTitleLogin = new JLabel("¡ Bienvenido a Empleate !");
		labelTitleLogin.setForeground(SystemColor.BLACK);
		labelTitleLogin.setBounds(0, 130, 788, 50);
		labelTitleLogin.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 40));
		labelTitleLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panelBody.add(labelTitleLogin);
		
		// Iniciar Sesion
		JLabel lblBtnIniciarSesion = new JLabel("Iniciar Sesión");
		lblBtnIniciarSesion.setBounds(0,0,400,50);
		lblBtnIniciarSesion.setForeground(Color.white);
		lblBtnIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnIniciarSesion.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 22));
		
		JPanel btnIniciarSesion = new JPanel();
		btnIniciarSesion.setBackground(new Color(50,89,119));
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIniciarSesion.setBackground(new Color(68,116,148));
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				btnIniciarSesion.setBackground(new Color(50,89,119));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				dispose();
			}
		
		});
		btnIniciarSesion.setBounds(200, 220, 400, 50);
		btnIniciarSesion.setLayout(null);
		btnIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnIniciarSesion.add(lblBtnIniciarSesion);	
		panelBody.add(btnIniciarSesion);
		
		// Registrarse como aspirante
		JLabel lblBtnRegistrarAspirante = new JLabel("Registrarse como Aspirante");
		lblBtnRegistrarAspirante.setBounds(0,0,400,50);
		lblBtnRegistrarAspirante.setForeground(Color.white);
		lblBtnRegistrarAspirante.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnRegistrarAspirante.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 22));
		
		JPanel btnRegistrarAspirante = new JPanel();
		btnRegistrarAspirante.setBackground(new Color(50,89,119));
		btnRegistrarAspirante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistrarAspirante.setBackground(new Color(68,116,148));
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistrarAspirante.setBackground(new Color(50,89,119));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaAspirant1 frame = new VentanaAspirant1();
				frame.setVisible(true);
				dispose();
			}
		
		});
		btnRegistrarAspirante.setBounds(200, 290, 400, 50);
		btnRegistrarAspirante.setLayout(null);
		btnRegistrarAspirante.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRegistrarAspirante.add(lblBtnRegistrarAspirante);	
		panelBody.add(btnRegistrarAspirante);
		
		// Registrarse como empleador
		JLabel lblBtnRegistrarEmpleador = new JLabel("Registrarse como Empleador");
		lblBtnRegistrarEmpleador.setBounds(0,0,400,50);
		lblBtnRegistrarEmpleador.setForeground(Color.white);
		lblBtnRegistrarEmpleador.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnRegistrarEmpleador.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 22));
		
		JPanel btnRegistrarEmpleador = new JPanel();
		btnRegistrarEmpleador.setBackground(new Color(50,89,119));
		btnRegistrarEmpleador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistrarEmpleador.setBackground(new Color(68,116,148));
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistrarEmpleador.setBackground(new Color(50,89,119));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Ventana1SigninEmpleador frame = new Ventana1SigninEmpleador();
				frame.setVisible(true);
				dispose();
			}
		
		});
		btnRegistrarEmpleador.setBounds(200, 360, 400, 50);
		btnRegistrarEmpleador.setLayout(null);
		btnRegistrarEmpleador.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRegistrarEmpleador.add(lblBtnRegistrarEmpleador);	
		panelBody.add(btnRegistrarEmpleador);
		
		return panelBody;
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
	
	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
	}
	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed
	
	public void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(
				image.getImage().getScaledInstance(
						labelName.getWidth(), labelName.getHeight(), Image.SCALE_AREA_AVERAGING));
		labelName.setIcon(icon);
		this.repaint();
		
	}
}
