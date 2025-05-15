package Login;

import Conexion.Conexion;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Inicio_sesion {


    private JPanel PanelPrincipal;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loginButton;
    private JPanel PanelLogin;
    private JLabel img;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JLabel label1;
    private JLabel label2;


    public Inicio_sesion() {
        Conexion con = new Conexion();
        Connection cn = con.getConnection();

        //Border roundedBorder = BorderFactory.createLineBorder(Color.GRAY, 5, true);
        //PanelLogin.setBorder(roundedBorder);

        //PanelLogin.setBackground(new Color(30, 30, 255, 180));

        PanelPrincipal.setLayout(null);
        PanelLogin.setLayout(null);
        PanelLogin.setBounds(150, 80, 400, 500);
        userLabel.setBounds(48, 170, 300, 30);
        passwordLabel.setBounds(48, 230, 300, 30);
        loginButton.setBounds(48, 350, 300, 40);
        textField1.setBounds(48, 200, 300, 30);
        textField2.setBounds(48, 260, 300, 30);
        PanelPrincipal.setBackground(new java.awt.Color(99,106,229));
        textField1.setBackground(new java.awt.Color(216, 216, 216));
        textField2.setBackground(new java.awt.Color(216, 216, 216));
        img.setBounds(100, 30, 300, 100);
        label1.setBounds(105, 100, 400, 100);
        label2.setBounds(48, 360, 400, 100);
        label2.setForeground(new java.awt.Color(99,106,229));
        loginButton.setBackground(new java.awt.Color(71, 75, 193));


        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(new Color(99,106,229));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(new Color(71, 75, 193)); // Regresar al azul normal

            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textField1.getText();
                String password = textField2.getText();
                if(!usuario.isEmpty() || !password.isEmpty()){
                    try{
                        PreparedStatement ps = cn.prepareStatement("SELECT rol FROM usuarios WHERE nombre_usuario='"+usuario+"' AND contraseña='"+password+"'");
                        ResultSet rs = ps.executeQuery();
                        if(rs.next()){

                            String rol = rs.getString("rol");
                            if(rol.equalsIgnoreCase("Administrador")){
                                System.out.println("Administrador");
                            }else if(rol.equalsIgnoreCase("Veterinario")){
                                System.out.println("Veterinario");
                            }

                        }else{
                            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,"Error al iniciar sesion");
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "Los campos están vacíos");
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Inicio_sesion().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);



    }
}
