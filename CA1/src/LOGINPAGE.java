
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LOGINPAGE {

    JFrame frame1 = new JFrame("Log-in Form");

    JButton SUBMIT, NCLIENT;

    JLabel emailLabel, lPassword;
    JTextField emailTF, passWord;

    public LOGINPAGE() {
        createAndShowGUI();
    }

    void login() {
        emailLabel = new JLabel("Email");
        emailTF = new JTextField(15);

        lPassword = new JLabel("Password");
        passWord = new JPasswordField(15);

        SUBMIT = new JButton("SUBMIT");
        NCLIENT = new JButton("CREATE AN ACCOUNT");

        JPanel panel = new JPanel(new GridLayout(10, 10));
        panel.setSize(500, 400);
        panel.add(emailLabel);
        panel.add(emailTF);
        panel.add(lPassword);
        panel.add(passWord);
        panel.add(SUBMIT);
        panel.add(NCLIENT);
        frame1.add(panel, BorderLayout.CENTER);

        SUBMIT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = emailTF.getText();
                String password = passWord.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://apontejaj.com:3306/Fabiolla_2019226?useSSL=false", "Fabiolla_2019226", "2019226");

                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select email, password from user where email=? and password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {

                        CONTROLLER ah = new CONTROLLER();
                      
                        ah.setVisible(true);

                        JOptionPane.showMessageDialog(SUBMIT, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(SUBMIT, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

        });
    }

    void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500, 400);
        frame1.setVisible(true);

        login();
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
