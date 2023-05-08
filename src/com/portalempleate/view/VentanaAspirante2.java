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

import com.portalempleate.controller.UsuarioController;
import com.portalempleate.modelos.Usuario;
import com.toedter.calendar.JDateChooser;


public class VentanaAspirante2 extends JFrame {

    private JPanel contentPane;
    private JFileChooser bpdfHojaVida;
    private JTextField txthojavida,
            txtCorreo;
    private JDateChooser txtFechanac;
    private JPasswordField txtContrasena;
    int xMouse, yMouse;
    private JLabel labelExit;
    //private String idUsuario;
    
    public JPanel btnGuardarAspirante;
    
    
    //private UsuarioController usuarioController;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new VentanaAspirante2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public VentanaAspirante2() {
    	//this.usuarioController = new UsuarioController();
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

    public JPanel panelForm() {

        JPanel panelForm = new JPanel();
        panelForm.setBackground(new Color(255, 255, 255));
        panelForm.setBounds(0, 45, 788, 527);
        panelForm.setLayout(null);

        JLabel labelTitleLogin = new JLabel("Registrarse Como Aspirante");
        labelTitleLogin.setForeground(SystemColor.BLACK);
        labelTitleLogin.setBounds(0, 15, 788, 50);
        labelTitleLogin.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 40));
        labelTitleLogin.setHorizontalAlignment(SwingConstants.CENTER);
        panelForm.add(labelTitleLogin);

        JLabel labelhojavida = new JLabel("Hoja de vida");
        labelhojavida.setForeground(Color.black);
        labelhojavida.setBounds(150, 85, 400, 20);
        labelhojavida.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        panelForm.add(labelhojavida);
        txthojavida = new JTextField();
        txthojavida.setBorder(new EmptyBorder(0, 10, 0, 10));
        txthojavida.setPreferredSize(new Dimension(10, 50));
        txthojavida.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        txthojavida.setBackground(new Color(219, 233, 245));
        txthojavida.setForeground(Color.darkGray);
        txthojavida.setBounds(150, 110, 300, 50);
        panelForm.add(txthojavida);

        JLabel lblBtnHojaArch = new JLabel("Subir Archivo");
        lblBtnHojaArch.setBounds(0, 10, 200, 25);
        lblBtnHojaArch.setForeground(Color.white);
        lblBtnHojaArch.setHorizontalAlignment(SwingConstants.CENTER);
        lblBtnHojaArch.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 22));

        JPanel btnHojaArch = new JPanel();
        btnHojaArch.setBackground(new Color(50, 89, 119));
        btnHojaArch.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnHojaArch.setBackground(new Color(68, 116, 148));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnHojaArch.setBackground(new Color(50, 89, 119));
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                    	seleccionarPDF();
                    	String rutaArchivo = bpdfHojaVida.getSelectedFile().getPath();
                    	txthojavida.setText(rutaArchivo);
                    }

                });
        btnHojaArch.setBounds(455, 110, 200, 50);
        btnHojaArch.setLayout(null);
        btnHojaArch.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnHojaArch.add(lblBtnHojaArch);
        panelForm.add(btnHojaArch);

        JLabel labelFechanac = new JLabel("Fecha de Nacimiento");
        labelFechanac.setForeground(Color.black);
        labelFechanac.setBounds(150, 175, 225, 20);
        labelFechanac.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        panelForm.add(labelFechanac);
        
        txtFechanac = new JDateChooser();
        txtFechanac.setBounds(150, 200, 500, 50);
        /*
        txtFechanac.getCalendarButton()
				.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/icon-reservas.png")));
				*/
        txtFechanac.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechanac.setDateFormatString("yyyy-MM-dd");
		txtFechanac.setForeground(Color.darkGray);
		txtFechanac.setBackground(new Color(219, 233, 245));
		txtFechanac.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtFechanac.setPreferredSize(new Dimension(10, 50));
		txtFechanac.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelForm.add(txtFechanac);
        
        /*
        txtFechanac = new JTextField();
        txtFechanac.setBorder(new EmptyBorder(0, 40, 0, 10));
        txtFechanac.setPreferredSize(new Dimension(10, 50));
        txtFechanac.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        txtFechanac.setBackground(new Color(219, 233, 245));
        txtFechanac.setForeground(Color.darkGray);
        txtFechanac.setBounds(150, 200, 500, 50);
        panelForm.add(txtFechanac);
		*/
        
        JLabel labelCorreo = new JLabel("Correo");
        labelCorreo.setForeground(Color.black);
        labelCorreo.setBounds(150, 265, 225, 20);
        labelCorreo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        panelForm.add(labelCorreo);
        txtCorreo = new JTextField();
        txtCorreo.setBorder(new EmptyBorder(0, 10, 0, 10));
        txtCorreo.setPreferredSize(new Dimension(10, 50));
        txtCorreo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        txtCorreo.setBackground(new Color(219, 233, 245));
        txtCorreo.setForeground(Color.darkGray);
        txtCorreo.setBounds(150, 290, 500, 50);
        panelForm.add(txtCorreo);

        JLabel labelContraseña = new JLabel("Contraseña");
        labelContraseña.setForeground(Color.black);
        labelContraseña.setBounds(150, 353, 225, 20);
        labelContraseña.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        panelForm.add(labelContraseña);
        txtContrasena = new JPasswordField();
        txtContrasena.setBorder(new EmptyBorder(0, 10, 0, 10));
        txtContrasena.setPreferredSize(new Dimension(10, 50));
        txtContrasena.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        txtContrasena.setBackground(new Color(219, 233, 245));
        txtContrasena.setForeground(Color.darkGray);
        txtContrasena.setBounds(150, 380, 500, 50);
        panelForm.add(txtContrasena);

        JLabel lblBtnNext = new JLabel("Registrarse");
        lblBtnNext.setBounds(0, 0, 200, 50);
        lblBtnNext.setForeground(Color.white);
        lblBtnNext.setHorizontalAlignment(SwingConstants.CENTER);
        lblBtnNext.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 22));

        btnGuardarAspirante = new JPanel();
        btnGuardarAspirante.setBackground(new Color(50, 89, 119));
        btnGuardarAspirante.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnGuardarAspirante.setBackground(new Color(68, 116, 148));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnGuardarAspirante.setBackground(new Color(50, 89, 119));
                    }
                    /*
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    	if (registrarAspiranteV2()) {
                    		JOptionPane.showMessageDialog(btnGuardarAspirante, "Registro exitoso");
                    		
                    		
                    		
    					} else {
    						JOptionPane.showMessageDialog(btnGuardarAspirante, "Ocurrio un error");
    					}
                    }
					*/
                });
        btnGuardarAspirante.setBounds(300, 450, 200, 50);
        btnGuardarAspirante.setLayout(null);
        btnGuardarAspirante.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnGuardarAspirante.add(lblBtnNext);
        panelForm.add(btnGuardarAspirante);

        return panelForm;
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

    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
    
    private void seleccionarPDF() {
        bpdfHojaVida = new JFileChooser();
        int resultado = bpdfHojaVida.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Se ha seleccionado un archivo PDF
            String rutaArchivo = bpdfHojaVida.getSelectedFile().getPath();
            // Aquí puedes guardar la ruta del archivo o realizar otras operaciones
            System.out.println("Archivo seleccionado: " + rutaArchivo);
        }
    }
    
    public boolean registrarAspiranteV2() {
    	
    	if(!txthojavida.getText().equals("") && !txtCorreo.getText().equals("") 
    			&& txtFechanac.getDate() != null && !txtContrasena.getText().equals("")) {
    		
    		if (esCorreoElectronicoValido(txtCorreo.getText())) {
    			/*
    			String password = String.valueOf(txtContrasena.getPassword());
    			String telefono = ventanaAspirant1.getTxtExtensioncelular().getText() + 
    					ventanaAspirant1.getTxtNumcelular().getText();
    			Usuario usuario = new Usuario(
    					ventanaAspirant1.getTxtTipoid().getSelectedItem().toString(),
    					ventanaAspirant1.getTxtId().getText(),
    					ventanaAspirant1.getTxtPrimernombre().getText(),
    					ventanaAspirant1.getTxtSegundonombre() .getText(),
    					ventanaAspirant1.getTxtPrimerapellido().getText(),
    					ventanaAspirant1.getTxtSegundoapellido().getText(),
    					telefono,
    					1
    					);
    			
    			this.usuarioController.asignaUsuario(usuario);
    			this.usuarioController.guardarusuarioAspiranteV1(usuario);
    			
    			
    			   		
    			this.usuarioController.guardarusuarioAspiranteV2(
    					//idUsuario,
    					txtCorreo.getText(),
    					password,
    					txthojavida.getText(),
    					txtFechanac.getDate()
    					);
    			*/
    			return true;
    		} else {
    			JOptionPane.showMessageDialog(this, "Debe colocar un correo valido");
    			return false;
    		}
    		    		   		
    	} else {
    		JOptionPane.showMessageDialog(this, "Complete todos los campos");
    		return false;
    	}
    	
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

	public JFileChooser getBpdfHojaVida() {
		return bpdfHojaVida;
	}

	public void setBpdfHojaVida(JFileChooser bpdfHojaVida) {
		this.bpdfHojaVida = bpdfHojaVida;
	}

	public JTextField getTxthojavida() {
		return txthojavida;
	}

	public void setTxthojavida(JTextField txthojavida) {
		this.txthojavida = txthojavida;
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
