
/**
 *
 * @author farleyreis Fabiola
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentBook extends JFrame implements ActionListener {

    Container container = getContentPane();

    JButton b1 = new JButton("ENTER AVAILABLE SLOTS");
    JButton b2 = new JButton("CANCEL BOOKS");
    JButton b3 = new JButton("SETTINGS");
    JButton b4 = new JButton("FEEDBACKS & PAYMENTS");

    AppointmentBook() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        b1.setBounds(150, 50, 200, 32);
        b2.setBounds(150, 100, 200, 32);
        b3.setBounds(150, 150, 200, 32);
        b4.setBounds(150, 200, 200, 32);
//        showPassword.setBounds(150, 250, 150, 30);
//        loginButton.setBounds(50, 300, 100, 30);
//        CLIENTButton.setBounds(200, 300, 130, 30);
        setSize(500, 400);
    }

    public void addComponentsToContainer() {
        container.add(b1);
        container.add(b2);
        container.add(b3);
        container.add(b4);

    }

    public void addActionEvent() {
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == loginButton) {
//            String userText;
//            String pwdText;
//            userText = userTextField.getText();
//            pwdText = passwordField.getText();
//            if (userText.equalsIgnoreCase("") && pwdText.equalsIgnoreCase("")) {
//                AppointmentBook nc = new AppointmentBook();
//                nc.setVisible(true);
//                dispose();
//                JOptionPane.showMessageDialog(this, "Login Successful");
//            } else {
//                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
//            }
//
//        }
//        if (e.getSource() == CLIENTButton) {
//            NCLIENT nc = new NCLIENT();
//            nc.setVisible(true);
//            dispose();
//        }
//        if (e.getSource() == showPassword) {
//            if (showPassword.isSelected()) {
//                passwordField.setEchoChar((char) 0);
//            } else {
//                passwordField.setEchoChar('*');
//            }
//
//        }
    }

}
