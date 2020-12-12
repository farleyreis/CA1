
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BOOKS extends JFrame implements ActionListener {

    JButton btn, btn2;

    private ActionListener eventHandler;

    public BOOKS() {

        JFrame frame = new JFrame("SOS Beauty - Select an Appointment");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 550);
        // frame.setLocation(430, 100);

        JPanel panel = new JPanel();
        panel = new JPanel(new GridLayout(8, 8));

        frame.add(panel);

        JLabel SER = new JLabel("SELECT SERVICE ");
        JLabel MON = new JLabel("SELECT MONTH");
        JLabel DIA = new JLabel("SELECT DAY");
        JLabel LO = new JLabel("SELECT LOCATION:");

        String[] Location = {"SOS BEAUTY DUBLIN1", "SOS BEAUTY DUBLIN2", "SOS BEAUTY DUBLIN8"};

        String[] Service = {"Haircutting", "Hair Coloring", "Specialty coloring", "Grey Blending",
            "Highlights", "Gel nail extension", "Acrylic nail extensi", "Overlays", "Manicure", "Reconstruction Nails",
            "Spa pedicure + gel polish on toes", "Repair one nail"};

        String[] Month = {"January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October",
            "November", "December"};
        String[] Day = {"1", "2", "3", "4",
            "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14",
            "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24",
            "25", "26", "27", "28", "29", "30"};

        final JComboBox<String> loc = new JComboBox<String>(Location);
        panel.add(LO);

        final JComboBox<String> sr = new JComboBox<String>(Service);
        panel.add(SER);
        final JComboBox<String> cd = new JComboBox<String>(Day);
        final JComboBox<String> cb = new JComboBox<String>(Month);

        panel.add(LO);
        panel.add(loc);

        panel.add(SER);
        panel.add(sr);

        panel.add(MON);
        panel.add(cb);

        panel.add(DIA);
        panel.add(cd);

        JButton btn = new JButton("BACK");
        JButton btn2 = new JButton("NEXT");

        panel.add(btn);
        panel.add(btn2);

        frame.setVisible(true);
        btn2.addActionListener(this);
        btn.addActionListener(this);
        btn.addActionListener(eventHandler);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            CA1 nc = new CA1();
            nc.setVisible(true);
            //dispose();

        } else if (e.getSource() == btn2) {
            SERVICEPROVIDER nc = new SERVICEPROVIDER();
            nc.setVisible(true);
            //dispose();
        }
    }

    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    public void setVisible(boolean b) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
