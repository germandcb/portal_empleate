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
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;

public class VentanaAspirant1 extends JFrame {

    private JPanel contentPane;
    private JTextField 
			txtTipoid, 
			txtId, 
			txtPrimernombre, 
			txtSegundonombre, 
			txtPrimerapellido, 
			txtSegundoapellido, 
			txtExtensioncelular, 
			txtNumcelular;
    int xMouse, yMouse;
    private JLabel labelExit;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new VentanaAspirant1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public VentanaAspirant1() {
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

        return panel_1;
    }

    public JPanel panelForm() {
		JPanel panelForm = new JPanel();
		panelForm.setBackground(new Color(255, 255, 255));
		panelForm.setBounds(0, 45, 788, 527);
		panelForm.setLayout(null);
		

		//TITULO DE LA VENTANA
		JLabel labelTitleLogin = new JLabel("Registrarse Como Aspirante");
		labelTitleLogin.setForeground(SystemColor.BLACK);
		labelTitleLogin.setBounds(0, 15, 788, 50);
		labelTitleLogin.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 40));
		labelTitleLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(labelTitleLogin);//Fin del titulo
		
		//CAMPO PARA EL TIPO DE IDENTIFICACION DEL USUARIO
		JLabel labelTipoid = new JLabel("Tipo ID");//Titulo
		labelTipoid.setForeground(Color.black);
		labelTipoid.setBounds(150, 85, 400, 20);
		labelTipoid.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelTipoid);//Fin del titulo
		txtTipoid = new JTextField();//Campo de texto
		txtTipoid.setBorder(new EmptyBorder(0,10,0,10));
		txtTipoid.setPreferredSize(new Dimension(10, 50));
		txtTipoid.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtTipoid.setBackground(new Color(219, 233, 245));
		txtTipoid.setForeground(Color.darkGray);
		txtTipoid.setBounds(150, 110, 65, 50);
		panelForm.add(txtTipoid);//Fin del campo de texto
		//Fin del tipo de identificacion
		
		//CAMPO PARA EL NUMERO DE IDENTIFICACION
		JLabel labelId = new JLabel("ID");//Titulo
		labelId.setForeground(Color.black);
		labelId.setBounds(250, 85, 400, 20);
		labelId.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelId);//Fin del titulo
		txtId = new JTextField();//Campo de texto
		txtId.setBorder(new EmptyBorder(0,10,0,10));
		txtId.setPreferredSize(new Dimension(10, 50));
		txtId.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtId.setBackground(new Color(219, 233, 245));
		txtId.setForeground(Color.darkGray);
		txtId.setBounds(250, 110, 400, 50);
		panelForm.add(txtId);//Fin del campo de texto
		//Fin del numero de identificacion

		//CAMPO PARA EL PRIMER NOMBRE
		JLabel labelPrimernombre = new JLabel("Primer Nombre");//Titulo
		labelPrimernombre.setForeground(Color.black);
		labelPrimernombre.setBounds(170, 175, 225, 20);
		labelPrimernombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelPrimernombre);//Fin del titulo
		txtPrimernombre = new JTextField();//Campo de texto
		txtPrimernombre.setBorder(new EmptyBorder(0,10,0,10));
		txtPrimernombre.setPreferredSize(new Dimension(10, 50));
		txtPrimernombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtPrimernombre.setBackground(new Color(219, 233, 245));
		txtPrimernombre.setForeground(Color.darkGray);
		txtPrimernombre.setBounds(150, 200, 225, 50);
		panelForm.add(txtPrimernombre);//Fin del campo de texto
		//Fin del primer nombre

		//CAMPO PARA EL SEGUNDO NOMBRE
		JLabel labelSegundonombre = new JLabel("Segundo Nombre");//Titulo
		labelSegundonombre.setForeground(Color.black);
		labelSegundonombre.setBounds(425, 175, 225, 20);
		labelSegundonombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelSegundonombre);//Fin del titulo
		txtSegundonombre = new JTextField();//Campo de texto
		txtSegundonombre.setBorder(new EmptyBorder(0,10,0,10));
		txtSegundonombre.setPreferredSize(new Dimension(10, 50));
		txtSegundonombre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtSegundonombre.setBackground(new Color(219, 233, 245));
		txtSegundonombre.setForeground(Color.darkGray);
		txtSegundonombre.setBounds(425, 200, 225, 50);
		panelForm.add(txtSegundonombre);//Fin del campo de texto
		//Fin del segundo nombre

		//CAMPO PARA EL PRIMER APELLIDO
		JLabel labelPrimerapellido = new JLabel("Primer Apellido");//Titulo
		labelPrimerapellido.setForeground(Color.black);
		labelPrimerapellido.setBounds(150, 265, 225, 20);
		labelPrimerapellido.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelPrimerapellido);//Fin del titulo
		txtPrimerapellido = new JTextField();//Campo de texto
		txtPrimerapellido.setBorder(new EmptyBorder(0,10,0,10));
		txtPrimerapellido.setPreferredSize(new Dimension(10, 50));
		txtPrimerapellido.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtPrimerapellido.setBackground(new Color(219, 233, 245));
		txtPrimerapellido.setForeground(Color.darkGray);
		txtPrimerapellido.setBounds(150, 290, 225, 50);
		panelForm.add(txtPrimerapellido);//Fin del campo de texto
		//Fin del primer apellido

		//CAMPO PARA EL SEGUNDO APELLIDO
		JLabel labelSegundoapellido = new JLabel("Segundo Apellido");//Titulo
		labelSegundoapellido.setForeground(Color.black);
		labelSegundoapellido.setBounds(425, 265, 225, 20);
		labelSegundoapellido.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelSegundoapellido);//Fin del titulo
		txtSegundoapellido = new JTextField();//Campo de texto
		txtSegundoapellido.setBorder(new EmptyBorder(0,10,0,10));
		txtSegundoapellido.setPreferredSize(new Dimension(10, 50));
		txtSegundoapellido.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtSegundoapellido.setBackground(new Color(219, 233, 245));
		txtSegundoapellido.setForeground(Color.darkGray);
		txtSegundoapellido.setBounds(425, 290, 225, 50);
		panelForm.add(txtSegundoapellido);//Fin del campo de texto
		//Fin del segundo apellido

		//CAMPO PARA LA EXTENSION DE NUMERO DE CELULAR
		txtExtensioncelular = new JTextField();//Campo de texto
		txtExtensioncelular.setBorder(new EmptyBorder(0,10,0,10));
		txtExtensioncelular.setPreferredSize(new Dimension(10, 50));
		txtExtensioncelular.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtExtensioncelular.setText("+57");
		txtExtensioncelular.setBackground(new Color(219, 233, 245));
		txtExtensioncelular.setForeground(Color.darkGray);
		txtExtensioncelular.setBounds(150, 380, 65, 50);
		panelForm.add(txtExtensioncelular);//Fin del campo de texto
		//Fin de la extension de celular

		//CAMPO PARA EL NUMERO DE CELULAR
		JLabel labelNumcelular = new JLabel("Número de Celular");//Titulo
		labelNumcelular.setForeground(Color.black);
		labelNumcelular.setBounds(250, 355, 400, 20);
		labelNumcelular.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		panelForm.add(labelNumcelular);//Fin del titulo
		txtNumcelular = new JTextField();//Campo de texto
		txtNumcelular.setBorder(new EmptyBorder(0,10,0,10));
		txtNumcelular.setPreferredSize(new Dimension(10, 50));
		txtNumcelular.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtNumcelular.setBackground(new Color(219, 233, 245));
		txtNumcelular.setForeground(Color.darkGray);
		txtNumcelular.setBounds(250, 380, 400, 50);
		panelForm.add(txtNumcelular);//Fin del campo de texto
		//Fin del numero de identificacion

		//BOTON "SIGUIENTE"
		JLabel lblBtnNext = new JLabel("Siguiente");
		lblBtnNext.setBounds(0,0,200,50);
		lblBtnNext.setForeground(Color.white);
		lblBtnNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnNext.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 22));
		
		
		JPanel btnNext = new JPanel();
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
				@Override
				public void mouseClicked(MouseEvent e) {
					VentanaAspirante2 frame = new VentanaAspirante2();
					frame.setVisible(true);
					dispose();
				}
		
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
    
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }

}
