
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

        //frame.setVisible(true);
        btn2.addActionListener(this);
        btn.addActionListener(this);
        btn.addActionListener(eventHandler);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            CA1 nc = new CA1();
            nc.setVisible(true);
            dispose();

        } else if (e.getSource() == btn2) {
            CONFBOOKINGS nc = new CONFBOOKINGS();

            nc.setVisible(true);
            dispose();
        }
    }

}
//***
//I tried to make the data connection using JCombox but I was unable to insert it with the database,
//we tried for many days to find this solution but unfortunately we couldn't. 
//So to imagine what the other classes and attributes would look like, 
//I made the connection directly with the actionPerformed (ActionEvent e) to view the other dependencies.
//
//
//the comment below is the connection idea with the data base!
//**

//
//
//import javax.swing.*;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.BoxLayout;
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//public class BOOKS extends JFrame implements ActionListener {
//
//    JButton btn, btn2;
//
//    private ActionListener eventHandler;
//
//    public BOOKS() {
//
//        JFrame frame = new JFrame("SOS Beauty - Select an Appointment");
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(700, 550);
//        // frame.setLocation(430, 100);
//
//        JPanel panel = new JPanel();
//        panel = new JPanel(new GridLayout(8, 8));
//
//        frame.add(panel);
//
//        JLabel SER = new JLabel("SELECT SERVICE ");
//        JLabel MON = new JLabel("SELECT MONTH");
//        JLabel DIA = new JLabel("SELECT DAY");
//        JLabel LO = new JLabel("SELECT LOCATION:");
//
//        String[] Location = {"SOS BEAUTY DUBLIN1", "SOS BEAUTY DUBLIN2", "SOS BEAUTY DUBLIN8"};
//
//        String[] Service = {"Haircutting", "Hair Coloring", "Specialty coloring", "Grey Blending",
//            "Highlights", "Gel nail extension", "Acrylic nail extensi", "Overlays", "Manicure", "Reconstruction Nails",
//            "Spa pedicure + gel polish on toes", "Repair one nail"};
//
//        String[] Month = {"January", "February", "March", "April",
//            "May", "June", "July", "August", "September", "October",
//            "November", "December"};
//        String[] Day = {"1", "2", "3", "4",
//            "5", "6", "7", "8", "9", "10",
//            "11", "12", "13", "14",
//            "15", "16", "17", "18", "19", "20",
//            "21", "22", "23", "24",
//            "25", "26", "27", "28", "29", "30"};
//
//        final JComboBox<String> loc = new JComboBox<String>(Location);
//        panel.add(LO);
//
//        final JComboBox<String> sr = new JComboBox<String>(Service);
//        panel.add(SER);
//        final JComboBox<String> cd = new JComboBox<String>(Day);
//        final JComboBox<String> cb = new JComboBox<String>(Month);
//
//        panel.add(LO);
//        panel.add(loc);
//
//        panel.add(SER);
//        panel.add(sr);
//
//        panel.add(MON);
//        panel.add(cb);
//
//        panel.add(DIA);
//        panel.add(cd);
//
//        JButton btn = new JButton("BACK");
//        JButton btn2 = new JButton("NEXT");
//
//        panel.add(btn);
//        panel.add(btn2);
//
//        //frame.setVisible(true);
//        btn2.addActionListener(this);
//        btn.addActionListener(this);
//        btn.addActionListener(eventHandler); 
//        
////        btn2.addActionListener(new ActionListener() {
////
////            public void actionPerformed(ActionEvent e) {
////                try {
////                    
//////    theQuery("INSERT INTO service (location,data,month,service) VALUES ('" + loc.getSelectedItem()+ "','" + cd.getSelectedItem() + "','" + cb.getSelectedItem() + "','" + sr.getSelectedItem() "');
////                } catch (Exception ex) {
////                }
////            } 

////        }
////        );
//        btn.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//                LOGINPAGE ps = new LOGINPAGE();
//
//                ps.setVisible(true);
//            }
//
//        }
//        );
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//        //setLocationRelativeTo(null);
//        setSize(700, 550);
//        
//
//    }
//
//    //function to execute the insert update delete query
//    public void theQuery(String query) {
//        Connection con = null;
//        Statement st = null;
//        try {
//            con = DriverManager.getConnection("jdbc:mysql://apontejaj.com:3306/Fabiolla_2019226?useSSL=false", "Fabiolla_2019226", "2019226");
//            st = con.createStatement();
//            st.executeUpdate(query);
//            JOptionPane.showMessageDialog(null, "Query Executed");
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//
//        new BOOKS() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//            
//        };
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}