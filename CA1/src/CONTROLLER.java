
/**
 *
 * @author farleyreis Fabiola
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CONTROLLER extends JFrame implements ActionListener {

    Container container = getContentPane();

    JButton b1 = new JButton("ENTER AVAILABLE SLOTS");
    JButton b2 = new JButton("CANCEL BOOKS");
    JButton b3 = new JButton("SETTINGS");
    JButton b4 = new JButton("FEEDBACKS & PAYMENTS");

    CONTROLLER() {
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
        if (e.getSource() == b1) {
            
              BOOKS nc = new BOOKS();
                nc.setVisible(true);
                dispose();
                JOptionPane.showMessageDialog(this, "Login Successful");
            } 

        
    if (e.getSource() == b2) {
            NCLIENT nc = new NCLIENT();
            nc.setVisible(true);
            dispose();
        }
        if (e.getSource() == b3) {
                SETTINGS nc = new SETTINGS();
                nc.setVisible(true);
                dispose();
            
            } else {
            }

        }
    
    }


