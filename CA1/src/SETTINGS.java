
/**
 *
 * @author farleyreis Fabiola
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

public abstract class SETTINGS extends JFrame implements ActionListener {

    JPanel panel;
    JLabel user_label, password_label, password_label2, message, fullName, email, phoneNumber;
    JTextField userName_text, fullNameText, emailText, phoneNumberText;
    JPasswordField password_text, password_text2;
    JButton submit, cancel, home;

    private ActionListener eventHandler;

    public SETTINGS() {
        //Full name

        fullName = new JLabel();
        fullName.setText("UPDATE FULL NAME :");
        fullNameText = new JTextField();

        // email
        email = new JLabel();
        email.setText("UPDATE EMAIL :");
        emailText = new JTextField();

        //phone Number
        phoneNumber = new JLabel();
        phoneNumber.setText("UPDATE PHONE NUMBER :");
        phoneNumberText = new JTextField();

        password_label = new JLabel();
        password_label.setText("UPDATE PASSWORD :");
        password_text = new JPasswordField();

        password_label2 = new JLabel();
        password_label2.setText("UPDATE CONFIRM PASSWORD :");
        password_text2 = new JPasswordField();

        // Submit
        submit = new JButton("SUBMIT");
        home = new JButton("HOME");
        //newUser = new JButton("NEW USER");

        submit.addActionListener(eventHandler);
        home.addActionListener(eventHandler);

        panel = new JPanel(new GridLayout(11, 3));

        panel.add(fullName);
        panel.add(fullNameText);
        panel.add(email);
        panel.add(emailText);
        panel.add(phoneNumber);
        panel.add(phoneNumberText);
        panel.add(password_label);
        panel.add(password_text);
        panel.add(password_label2);
        panel.add(password_text2);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        panel.add(home);
        //panel.add(newUser);
        home.setForeground(Color.red);
        home.setOpaque(true);

        // Adding the listeners to components..
        submit.addActionListener(this);
        home.addActionListener(this);
        add(panel, BorderLayout.CENTER);

        setTitle("Welcome to SOS BEAUTY!");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBorder(BorderFactory.createTitledBorder("SOS BEAUTY CLIENT LOGIN"));

        submit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    theQuery("UPDATE user SET('" + fullNameText.getText() + "',"
                            + "'" + password_text.getText() + "','" + password_text2.getText() + "','" + emailText.getText() + "','" + phoneNumberText.getText() + "')");
                } catch (Exception ex) {
                }

            }

        }
        );
        home.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                LOGINPAGE ps = new LOGINPAGE();

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

        new SETTINGS() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
    }

}
