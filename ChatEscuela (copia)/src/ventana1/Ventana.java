package ventana1;

import java.awt.event.*;
import javax.swing.*;

public class Ventana extends JFrame{
    
    public Ventana() {
        
        iniciarVentana();
        iniciarComponentes();
        setVisible(true);
    }
    
    public void iniciarVentana() {
        setTitle("Chat");
        setLayout(null);
        setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
        setSize(500,400);
        setResizable(false);
    }
    
    public void iniciarComponentes() {
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 10, 480, 250);
        textArea.setEditable(false);
        
        JTextField textField = new JTextField();
        textField.setBounds(10, 280, 480, 25);
        textField.setText("");
        
        JButton btn1 = new JButton("Enviar");
        btn1.setBounds(369, 325, 120, 30);
        
        JButton btn2 = new JButton("Borrar");
        btn2.setBounds(239, 325, 120, 30);

        JButton btn3 = new JButton("Salir");
        btn3.setBounds(165, 325, 60, 30);
        
        JScrollPane scroll = new JScrollPane (textArea);
        scroll.setBounds(10, 10, 480, 250);
        
        JCheckBox cb1 = new JCheckBox("Escribir al final");
        cb1.setBounds(10, 325, 130, 25);
        cb1.setSelected(true);
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String texta = textArea.getText();
                
                if(textField.getText().equals("")){
                    
                } else {
                    if(cb1.isSelected()) {
                        textArea.append(textField.getText() + "\n");
                        textField.setText("");
                    } else {
                        
                        textArea.setText("");
                        textArea.append(textField.getText() + "\n" + texta);
                        textField.setText("");
                    }
                }
                
            }
        });
        
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int option = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de borrar todo?", "Borrar", JOptionPane.YES_NO_OPTION);
                
                if(option == JOptionPane.YES_OPTION) {
                    textArea.setText("");
                    textField.setText("");
                }
            }
        });
        
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Ventana.this.setVisible(false);
                Login v1 = new Login(new Persona("Gorda", "Loca69"));
            }
        });
        
        getRootPane().setDefaultButton(btn1);
        
        

        add(textField);
        add(btn1);
        add(btn2);
        add(btn3);
        add(scroll);
        add(cb1);
    }

}
