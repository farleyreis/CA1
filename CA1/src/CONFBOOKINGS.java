
/**
 *
 * @author Fabiolla/Farley
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CONFBOOKINGS {

    JButton menu = new JButton("MENU");
    JButton confirm = new JButton("CONFIRM");
    JFrame f;

    CONFBOOKINGS() {

        //here should be the bookings made by the client, to the professional confirm the booking
        f = new JFrame();
        String data[][] = {{"9H", "15/12/2020", "Haircutting", "9/10"}, //should be a button to confirm the booking in the last column
        {"10H", "15/10/2020", "Hair Coloring", "10/10"},
        {"15H", "15/10/2020", "Highlights", "10/10"},
        {"17H", "15/10/2020", "Manicure", "10/10"},
        {"10H", "16/10/2020", "Manicure", "#"},
        {"11H", "16/10/2020", "Haircutting", "10/10"},
        {"12H", "16/10/2020", "Manicure", "10/10"},
        {"15H", "16/12/2020", "Hair Coloring", "#"}};
        String column[] = {"TIME", "DATE", "SERVICE", "CONFIRM"};
        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(700, 550);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new SCHEDULE();
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
