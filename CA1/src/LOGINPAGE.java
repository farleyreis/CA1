
/**
 *
 * @author farleyreis Fabiola
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

public class LOGINPAGE extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("EMAIL");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton CLIENTButton = new JButton("NEW ACCOUNT");
    JCheckBox showPassword = new JCheckBox("Show Password");

    LOGINPAGE() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    LOGINPAGE(CA1.EventHandler aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        CLIENTButton.setBounds(350, 300, 130, 40);
        setSize(700, 550);
    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(CLIENTButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        CLIENTButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CLIENTButton) {
            NCLIENT nc = new NCLIENT() {
                @Override
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

                CONTROLLER ah = new CONTROLLER();
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
