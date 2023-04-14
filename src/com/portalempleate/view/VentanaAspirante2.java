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

public class VentanaAspirante2 extends JFrame {

    private JPanel contentPane;
    private JTextField txthojavida,
            txtFechanac,
            txtCorreo,
            txtContraseña;

    int xMouse, yMouse;
    private JLabel labelExit;

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
        txthojavida.setBorder(new EmptyBorder(0, 40, 0, 10));
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
                        /* Login(); */
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
        txtFechanac = new JTextField();
        txtFechanac.setBorder(new EmptyBorder(0, 40, 0, 10));
        txtFechanac.setPreferredSize(new Dimension(10, 50));
        txtFechanac.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        txtFechanac.setBackground(new Color(219, 233, 245));
        txtFechanac.setForeground(Color.darkGray);
        txtFechanac.setBounds(150, 200, 500, 50);
        panelForm.add(txtFechanac);

        JLabel labelCorreo = new JLabel("Correo");
        labelCorreo.setForeground(Color.black);
        labelCorreo.setBounds(150, 265, 225, 20);
        labelCorreo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        panelForm.add(labelCorreo);
        txtCorreo = new JTextField();
        txtCorreo.setBorder(new EmptyBorder(0, 40, 0, 10));
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
        txtContraseña = new JTextField();
        txtContraseña.setBorder(new EmptyBorder(0, 40, 0, 10));
        txtContraseña.setPreferredSize(new Dimension(10, 50));
        txtContraseña.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        txtContraseña.setBackground(new Color(219, 233, 245));
        txtContraseña.setForeground(Color.darkGray);
        txtContraseña.setBounds(150, 380, 500, 50);
        panelForm.add(txtContraseña);

        JLabel lblBtnNext = new JLabel("Registrarse");
        lblBtnNext.setBounds(0, 0, 200, 50);
        lblBtnNext.setForeground(Color.white);
        lblBtnNext.setHorizontalAlignment(SwingConstants.CENTER);
        lblBtnNext.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 22));

        JPanel btnNext = new JPanel();
        btnNext.setBackground(new Color(50, 89, 119));
        btnNext.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btnNext.setBackground(new Color(68, 116, 148));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btnNext.setBackground(new Color(50, 89, 119));
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        /* Login(); */
                    }

                });
        btnNext.setBounds(300, 450, 200, 50);
        btnNext.setLayout(null);
        btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnNext.add(lblBtnNext);
        panelForm.add(btnNext);

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
}