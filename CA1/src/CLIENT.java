/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * 
 * @author farleyreis 
 */
public class CLIENT extends JFrame implements ActionListener {
    
    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel;
    JButton newUser;
    private ActionListener eventHandler;
     
    public CLIENT()
    {user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField(); 
        
        
        // Password

        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();

        // Submit

        submit = new JButton("SUBMIT");
        newUser = new JButton("NEW USER");
        
        submit.addActionListener(eventHandler);
        newUser.addActionListener(eventHandler);
        

        panel = new JPanel(new GridLayout(10, 10));
        

        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        panel.add(newUser);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(500, 400);
        setVisible(true);
        
        
        panel.setBorder(BorderFactory.createTitledBorder("SOS BEAUTY CLIENT LOGIN"));

    }
    

   
    public void actionPerformed(ActionEvent e) {
      String nameUserText = userName_text.getText();
      String passordUserText = password_text.getText();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    }
    

