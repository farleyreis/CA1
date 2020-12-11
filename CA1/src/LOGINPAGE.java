
/**
 *
 * @author farleyreis Fabiola
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LOGINPAGE extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("EMAIL");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton CLIENTButton = new JButton("NEW ACCOUNT");
    JCheckBox showPassword = new JCheckBox("Show Password");
    
    
    // CONECTION WITH DATABASE MANAGER
    DATABASECONECTION dbC = new DATABASECONECTION(); 

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
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        CLIENTButton.setBounds(200, 300, 130, 30);
        setSize(500, 400);
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
    public void actionPerformed(ActionEvent e)  
    
{
        char[] input = ((JPasswordField) passwordField).getPassword();
        String fullName = userTextField.getText();
        String password = String.copyValueOf(input);

        System.out.println("value1: " + fullName);
        System.out.println("value2: " + password);

        if(dbC.vertify(fullName, password))
        {
                //a pop-up box
                JOptionPane.showMessageDialog(null, "You have logged in successfully", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
                //a pop-up box
                JOptionPane.showMessageDialog(null, "Login failed!", "Failed!",
                                JOptionPane.INFORMATION_MESSAGE);
        }
}
}
