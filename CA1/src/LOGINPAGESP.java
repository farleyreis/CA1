/*
 * To change this license header, choose License Headers in Project Properties.
 * To chaSDFnge this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author Fabiolla/Farley
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LOGINPAGESP extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton SPButton = new JButton("NEW ACCOUNT");
    JCheckBox showPassword = new JCheckBox("Show Password");

    LOGINPAGESP() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(100, 150, 100, 30);
        passwordLabel.setBounds(100, 220, 100, 30);
        userTextField.setBounds(220, 150, 250, 30);
        passwordField.setBounds(220, 220, 250, 30);
        showPassword.setBounds(220, 250, 150, 30);
        loginButton.setBounds(150, 300, 100, 40);
        SPButton.setBounds(350, 300, 130, 40);
        setSize(700, 550);
    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(SPButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        SPButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    
     @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SPButton) {
            SERVICEPROVIDER nc = new SERVICEPROVIDER() {
               
                public void actionPerformed(ActionEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            nc.setVisible(true);
            dispose();

        }
        String userName = userTextField.getText();
        String password = passwordField.getText();
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://apontejaj.com:3306/Fabiolla_2019226?useSSL=false", "Fabiolla_2019226", "2019226");

            PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("Select email, password from user where email=? and password=?");

            st.setString(1, userName);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                MENUSP ah = new MENUSP();
                ah.setVisible(true);
                dispose();

                JOptionPane.showMessageDialog(loginButton, "You have successfully logged in");
            } else {
                JOptionPane.showMessageDialog(loginButton, "Wrong Username & Password");

            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

}