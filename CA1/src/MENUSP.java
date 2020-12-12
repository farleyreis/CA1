

/**
 *ASDF
 * @author Fabiolla/Farley
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MENUSP extends JFrame implements ActionListener {

    Container container = getContentPane();

    JButton b1 = new JButton("SCHEDULE");
    JButton b2 = new JButton("CONFIRM BOOKINGS");
    JButton b3 = new JButton("SET AVALABILITY");
    JButton b4 = new JButton("CCHECK FEEDBACKS & PAYMENTS");
    JButton logout = new JButton("LOGOUT");

    MENUSP() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
        
    }

    public void setLocationAndSize() {
        b1.setBounds(220, 50, 200, 32);
        b2.setBounds(220, 100, 200, 32);
        b3.setBounds(220, 150, 200, 32);
        b4.setBounds(220, 200, 200, 32);
        logout.setBounds(220, 250, 200, 32);

        setSize(700, 550);
    }

    public void addComponentsToContainer() {
        container.add(b1);
        container.add(b2);
        container.add(b3);
        container.add(b4);
        container.add(logout);
        
        logout.setForeground(Color.red);
        logout.setOpaque(true);

    }

    public void addActionEvent() {
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        logout.addActionListener(this);
        
        logout.setForeground(Color.red);
        logout.setOpaque(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {

            SCHEDULE nc = new SCHEDULE();
            nc.setVisible(true);
            dispose();
          
        }

        if (e.getSource() == b2) {
            CONFBOOKINGS nc = new CONFBOOKINGS() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            nc.setVisible(true);
            dispose();
        }
        if (e.getSource() == b3) {
            SETAVAILABILITY nc = new SETAVAILABILITY();
            nc.setVisible(true);
            dispose();

        }
        if (e.getSource() == b4) {
//            FEEDBACKPAYMENT nc = new  FEEDBACKPAYMENT();
//            nc.setVisible(true);
//            dispose();
           

        } 
        
        if (e.getSource() == logout) {
            CA1 nc = new CA1();
            nc.setVisible(true);
            dispose();
        }
        
        else {
        }

    }
}