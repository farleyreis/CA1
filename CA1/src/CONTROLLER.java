
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
    JButton home = new JButton("HOME PAGE");

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
        b1.setBounds(220, 50, 200, 32);
        b2.setBounds(220, 100, 200, 32);
        b3.setBounds(220, 150, 200, 32);
        b4.setBounds(220, 200, 200, 32);
        home.setBounds(220, 250, 200, 32);

        setSize(700, 550);
    }

    public void addComponentsToContainer() {
        container.add(b1);
        container.add(b2);
        container.add(b3);
        container.add(b4);
        container.add(home);

        home.setForeground(Color.red);
        home.setOpaque(true);
    }

    public void addActionEvent() {
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        home.addActionListener(this);

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
            NCLIENT nc = new NCLIENT() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            nc.setVisible(true);
            dispose();
        }
        if (e.getSource() == b3) {
            SETTINGS nc = new SETTINGS() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            nc.setVisible(true);
            dispose();

        }
        if (e.getSource() == home) {
            CA1 nc = new CA1();
            nc.setVisible(true);
            dispose();

        }
        if (e.getSource() == b4) {
            PAYMENTFEEDBACK nc = new PAYMENTFEEDBACK() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            nc.setVisible(true);
            dispose();

        } else {

        }

    }

}
