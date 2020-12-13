
/**
 *
 * @author Fabiolla/Farley
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static sun.swing.SwingUtilities2.submit;

;

/**
 * ASDC
 *
 * @author farleyreis
 */
public abstract class SERVICEPROVIDER extends JFrame implements ActionListener {

    JPanel panel;
    JLabel user_label, password_label, jobService, location, password_label2, message, email, phoneNumber;
    JTextField userName_text, emailText, phoneNumberText, jobServiceText, locationText;
    JPasswordField password_text, password_text2;
    JButton submit, cancel;
    JButton newUser, backb;
    private ActionListener eventHandler;

    public SERVICEPROVIDER() {//Full name

        user_label = new JLabel();
        user_label.setText("EMPLOYEE NAME:");
        userName_text = new JTextField();

        // email
        email = new JLabel();
        email.setText("EMAIL :");
        emailText = new JTextField();

        // Job service
        jobService = new JLabel();
        jobService.setText("JOB SERVICE:");
        jobServiceText = new JTextField();
        //box with the options

        //phone Number
        phoneNumber = new JLabel();
        phoneNumber.setText("PHONE NUMBER :");
        phoneNumberText = new JTextField();

        //Location
        location = new JLabel();
        location.setText("LOCATION:");
        locationText = new JTextField();
        //box with options

        password_label = new JLabel();
        password_label.setText("PASSWORD :");
        password_text = new JPasswordField();

        password_label2 = new JLabel();
        password_label2.setText("CONFIRM PASSWORD :");
        password_text2 = new JPasswordField();

        // Submit
        submit = new JButton("SUBMIT");
        backb = new JButton("Back");

        submit.addActionListener(eventHandler);
        backb.addActionListener(eventHandler);

        panel = new JPanel(new GridLayout(11, 3));

        panel.add(user_label);
        panel.add(userName_text);
        panel.add(email);
        panel.add(emailText);
        panel.add(phoneNumber);
        panel.add(phoneNumberText);
        panel.add(jobService);
        panel.add(jobServiceText);
        panel.add(location);
        panel.add(locationText);
        panel.add(password_label);
        panel.add(password_text);
        panel.add(password_label2);
        panel.add(password_text2);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        panel.add(backb);
        backb.setForeground(Color.red);
        backb.setOpaque(true);

        submit.addActionListener(this);
        backb.addActionListener(this);
        add(panel, BorderLayout.CENTER);

        setTitle("Welcome to SOS BEAUTY!");
        setSize(700, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBorder(BorderFactory.createTitledBorder("SOS BEAUTY CLIENT LOGIN"));

        submit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    theQuery("INSERT INTO employee (empName,empEmail,empPhone,empPWD,empPWDConf,empJob,empLocation) VALUES ('" + userName_text.getText() + "','" + emailText.getText() + "','" + phoneNumberText.getText() + "','" + password_text.getText() + "','" + password_text2.getText() + "','" + jobServiceText.getText() + "','" + locationText.getText() + "')");
                } catch (Exception ex) {
                }

            }

        }
        );
        backb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                LOGINPAGESP ps = new LOGINPAGESP();

                ps.setVisible(true);

            }

        }
        );

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //setLocationRelativeTo(null);
        setSize(700, 550);

    }

    //function to execute the insert update delete query
    public void theQuery(String query) {
        Connection con = null;
        Statement st = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://apontejaj.com:3306/Fabiolla_2019226?useSSL=false", "Fabiolla_2019226", "2019226");
            st = con.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Query Executed");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static void main(String[] args) {

        new SERVICEPROVIDER() {

            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };

    }
}
