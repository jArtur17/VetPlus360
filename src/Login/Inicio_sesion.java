package Login;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class Inicio_sesion {


    private JPanel PanelPrincipal;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loginButton;
    private JPanel PanelLogin;
    private JLabel img;
    private JLabel userLabel;
    private JLabel passwordLabel;


    public Inicio_sesion() {

        Border roundedBorder = BorderFactory.createLineBorder(Color.GRAY, 5, true);
        PanelLogin.setBorder(roundedBorder);

        //PanelLogin.setBackground(new Color(30, 30, 255, 180));

        PanelPrincipal.setLayout(null);
        PanelLogin.setLayout(null);
        PanelLogin.setBounds(150, 80, 400, 500);
        userLabel.setBounds(48, 170, 300, 30);
        passwordLabel.setBounds(48, 230, 300, 30);
        loginButton.setBounds(48, 350, 300, 40);
        textField1.setBounds(48, 200, 300, 30);
        textField2.setBounds(48, 260, 300, 30);
        PanelPrincipal.setBackground(new java.awt.Color(30, 30, 60));
        textField1.setBackground(new java.awt.Color(79, 122, 184));
        textField2.setBackground(new java.awt.Color(79, 122, 184));
        img.setBounds(140, 30, 300, 100);
        loginButton.setBackground(new java.awt.Color(30, 30, 55));


        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setBackground(new Color(30, 30, 90));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setBackground(new Color(30, 30, 60)); // Regresar al azul normal

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



    }
}
