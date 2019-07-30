package ventana1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JDialog {
    
    private Persona p;

    public Login(Persona p) {
        this.p = p;
        IniciarVentana();
        IniciarComponentes();
        setVisible(true);
    }
    

    public void IniciarVentana() {
        setTitle("Login");
        setSize(400, 150);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        
    }
    
    public void IniciarComponentes() {
        
        JLabel nameLabel = new JLabel("Name : ");
        JLabel passwordLabel = new JLabel("Password : ");

        JTextField nameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        JPanel topPanel = new JPanel(new GridBagLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(4, 4, 4, 4);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        topPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        topPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        topPanel.add(passwordLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        topPanel.add(passwordField, gbc);

        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameField.getText().equals(p.getUsuario()) && passwordField.getText().equals(p.getContraseña())) {
                   login(); 
                } else {
                    JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrecto");
                }
                
            }
        });

        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Login.this.setVisible(false);
                dispose();
            }
        });
        
        getRootPane().setDefaultButton(okButton);

        this.add(topPanel);

        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void login() {
        System.out.println("You logged in!");
        Login.this.setVisible(false);
        Ventana v1 = new Ventana();
    }

}