package com.portalempleate.view;

import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuEmpleador extends JFrame{
	 private JPanel contentPane;
	    private JTextField txtTipoid;
	    
	    public JPanel btnPublicacion;
	    public JPanel btnCrearOferta;
	    
	    int xMouse, yMouse;
	    private JLabel labelExit;
	    public JLabel bienvenidaUsuario;
	    
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    JFrame frame = new MenuEmpleador();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });

	    }

	    public MenuEmpleador() {
	    	setIconImage(new ImageIcon(getClass().getResource("/com/portalempleate/imgs/iconEmp.png")).getImage());
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	        setResizable(false);
	        setUndecorated(true);
	        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	        contentPane.add(panel);
	        panel.setLayout(null);

	        panel.add(panelHeader());
	        panel.add(panelLeft());
	        panel.add(panelRigth());

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
	        panel_1.setBounds(262, 0, 526, 45);
	        panel_1.setLayout(null);

	        JPanel btnexit = new JPanel();
	        btnexit.setBounds(482, 0, 45, 45);
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

	    public JPanel panelLeft() {
	        JPanel panelLeft = new JPanel();
	        panelLeft.setBackground(new Color(61, 104, 136));
	        panelLeft.setBounds(0, 0, 262, 572);
	        panelLeft.setLayout(null);
	        
	        //ImageIcon icono = new ImageIcon("/com/portalempleate/imgs/iconEmp.png");
	        
	        JLabel iconoMenu = new JLabel();
	        iconoMenu.setBounds(50, 50, 150, 150);
	        setImageLabel(iconoMenu, "src/com/portalempleate/imgs/iconEmp.png");
	        iconoMenu.setLayout(null);
	        panelLeft.add(iconoMenu);
	        
	        // BOTON DE PERFIL
	        JLabel jlbPerfil = new JLabel("Perfil");
	        jlbPerfil.setBounds(0,0,180,45);
	        jlbPerfil.setForeground(Color.white);
	        jlbPerfil.setHorizontalAlignment(SwingConstants.CENTER);
	        jlbPerfil.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
	        
	        JPanel btnPerfil = new JPanel();
			btnPerfil.setBackground(new Color(25,44,60));
			btnPerfil.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnPerfil.setBackground(new Color(16,15,15));
				}
			
				@Override
				public void mouseExited(MouseEvent e) {
					btnPerfil.setBackground(new Color(25,44,60));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(btnPerfil, "Esta funcionalidad estara disponible proximamente");
				}
			
			});
			btnPerfil.setBounds(40, 240, 180, 45);
			btnPerfil.setLayout(null);
			btnPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnPerfil.add(jlbPerfil);	
			panelLeft.add(btnPerfil);
			
			// BOTON DE PUBLICACIONES
	        JLabel jlbPublicacion = new JLabel("Publicaciones");
	        jlbPublicacion.setBounds(0,0,180,45);
	        jlbPublicacion.setForeground(Color.white);
	        jlbPublicacion.setHorizontalAlignment(SwingConstants.CENTER);
	        jlbPublicacion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
	        
	        btnPublicacion = new JPanel();
	        btnPublicacion.setBackground(new Color(25,44,60));
	        btnPublicacion.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnPublicacion.setBackground(new Color(16,15,15));
				}
			
				@Override
				public void mouseExited(MouseEvent e) {
					btnPublicacion.setBackground(new Color(25,44,60));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					/*
					Login frame = new Login();
					frame.setVisible(true);
					dispose();
					*/
				}
			
			});
	        btnPublicacion.setBounds(40, 295, 180, 45);
	        btnPublicacion.setLayout(null);
	        btnPublicacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        btnPublicacion.add(jlbPublicacion);	
			panelLeft.add(btnPublicacion);
			
			// BOTON DE CREAR OFERTA
	        JLabel jlbCrearOferta = new JLabel("Crear Oferta");
	        jlbCrearOferta.setBounds(0,0,180,45);
	        jlbCrearOferta.setForeground(Color.white);
	        jlbCrearOferta.setHorizontalAlignment(SwingConstants.CENTER);
	        jlbCrearOferta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
	        
	        btnCrearOferta = new JPanel();
	        btnCrearOferta.setBackground(new Color(25,44,60));
	        btnCrearOferta.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnCrearOferta.setBackground(new Color(16,15,15));
				}
			
				@Override
				public void mouseExited(MouseEvent e) {
					btnCrearOferta.setBackground(new Color(25,44,60));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					/*
					Login frame = new Login();
					frame.setVisible(true);
					dispose();
					*/
				}
			
			});
	        btnCrearOferta.setBounds(40, 350, 180, 45);
	        btnCrearOferta.setLayout(null);
	        btnCrearOferta.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        btnCrearOferta.add(jlbCrearOferta);	
			panelLeft.add(btnCrearOferta);

	        return panelLeft;
	    }
	    
	    public JPanel panelRigth() {
	        JPanel panelRigth = new JPanel();
	        panelRigth.setBackground(new Color(255, 255, 255));
	        panelRigth.setBounds(260, 44, 530, 530);
	        panelRigth.setBorder(null);
	        panelRigth.setLayout(null);
	        
	        bienvenidaUsuario = new JLabel();
	        bienvenidaUsuario.setBackground(new Color(108, 148, 172));
	        bienvenidaUsuario.setForeground(SystemColor.white);
	        bienvenidaUsuario.setBounds(0, 0, 536, 100);
	        bienvenidaUsuario.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
	        bienvenidaUsuario.setHorizontalAlignment(SwingConstants.CENTER);
	        bienvenidaUsuario.setOpaque(true);
	        bienvenidaUsuario.setBorder(null);
	        panelRigth.add(bienvenidaUsuario);
	        
	        String textoDescripcion = "<html><body> <p center>Bienvenido al sistema EMPLEATE <br> Desde aquí usted podrá crear ofertas de trabajo para que algún aspirante se pueda postular.</p></html></body> ";
	        
	        JLabel jlDescripcion = new JLabel(textoDescripcion);
	        jlDescripcion.setForeground(SystemColor.black);
	        jlDescripcion.setBounds(40, 100, 460, 100);
	        jlDescripcion.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
	        jlDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
	        panelRigth.add(jlDescripcion);
	        
	        
	        String textoDescripcion_1 = "<html><body>  - Perfil: Es la informacion o datos  de la cuenta del empleador y de la emplesa. <br>"
	        		+ " - Publicaciones: Son las publicaciones que se han creado y publicado por parte del empleador <br>"
	        		+ " - crear oferta: Es la ventana donde se crean las ofertas y se describe el cargo que se va a necesitar en la empresa. <br> </html></body> ";
	        
	        JLabel jlDescripcion_1 = new JLabel(textoDescripcion_1);
	        jlDescripcion_1.setForeground(SystemColor.black);
	        jlDescripcion_1.setBounds(40, 100, 460, 400);
	        jlDescripcion_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
	        jlDescripcion_1.setHorizontalAlignment(SwingConstants.CENTER);
	        panelRigth.add(jlDescripcion_1);
	        
	        return panelRigth;
	    }

	    private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
	    }
	    
	    public void setImageLabel(JLabel labelName, String root) {
			ImageIcon image = new ImageIcon(root);
			Icon icon = new ImageIcon(
					image.getImage().getScaledInstance(
							labelName.getWidth(), labelName.getHeight(), Image.SCALE_AREA_AVERAGING));
			labelName.setIcon(icon);
			this.repaint();
			
		}
}
