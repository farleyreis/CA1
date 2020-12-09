
/**
 *
 * @author farleyreis Fabiola
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SETTINGS extends JFrame implements ActionListener {

    JPanel panel;
    JLabel user_label, password_label, password_label2, message, fullName, email, phoneNumber;
    JTextField userName_text, fullNameText, emailText, phoneNumberText;
    JPasswordField password_text, password_text2;
    JButton submit, cancel, backb;
    JButton newUser;
    private ActionListener eventHandler;

    public SETTINGS() {
        //Full name

        fullName = new JLabel();
        fullName.setText("CHANGE: Name:");
        fullNameText = new JTextField();

        // email
        email = new JLabel();
        email.setText("CHANGE: Email :");
        emailText = new JTextField();

        //phone Number
        phoneNumber = new JLabel();
        phoneNumber.setText("CHANGE: Phone Number :");
        phoneNumberText = new JTextField();

        password_label = new JLabel();
        password_label.setText("NEW PassWord :");
        password_text = new JPasswordField();

        password_label2 = new JLabel();
        password_label2.setText("Confirm new PassWord :");
        password_text2 = new JPasswordField();

        // Submit
        submit = new JButton("SUBMIT");
        backb = new JButton("BACK");
        //newUser = new JButton("NEW USER");

        submit.addActionListener(eventHandler);
        //newUser.addActionListener(eventHandler);

        panel = new JPanel(new GridLayout(10, 10));

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
        panel.add(backb);
        
        //panel.add(newUser);

        
        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBorder(BorderFactory.createTitledBorder("SOS BEAUTY CLIENT LOGIN"));

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backb) {
                CONTROLLER nc = new CONTROLLER();
                //nc.setVisible(true);
                //dispose();

        } else if (e.getSource() == newUser) {
            SERVICEPROVIDER nc = new SERVICEPROVIDER();
            nc.setVisible(true);
            dispose();
        }
    }

}
