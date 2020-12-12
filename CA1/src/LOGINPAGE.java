import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LOGINPAGE{
        JFrame frame1 = new JFrame("Log-in Form");
        
        JButton SUBMIT, NCLIENT;
        
        JLabel emailLabel, lPassword;
        JTextField emailTF, passWord;
        
        //DATABASECONECTION dbC=new DATABASECONECTION();
        
        public LOGINPAGE()
        {
                createAndShowGUI();
        }
        
        void login()
        {
                emailLabel = new JLabel("Email");
                emailTF = new JTextField(15);
                
                lPassword = new JLabel("Password");
                passWord = new JPasswordField(15);
                
                SUBMIT = new JButton("SUBMIT");
                NCLIENT = new JButton("CREATE AN ACCOUNT");
                
                JPanel panel = new JPanel(new GridLayout(10,10));
                panel.setSize(500,400);
                panel.add(emailLabel);
                panel.add(emailTF);
                panel.add(lPassword);
                panel.add(passWord);
                panel.add(SUBMIT);
                panel.add(NCLIENT);
                frame1.add(panel, BorderLayout.CENTER);

    SUBMIT.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            { DATABASECONECTION dbC=new DATABASECONECTION();
                    char[] input = ((JPasswordField) passWord).getPassword();
                    String email = emailTF.getText();
                    String password = String.copyValueOf(input);

                    System.out.println("value1: " + email);
                    System.out.println("value2: " + password);

                    if(dbC.vertify(email, password))
                    {
                        CONTROLLER ps = new CONTROLLER();
                            ps.setVisible(true);
                            //a pop-up box
                            JOptionPane.showMessageDialog(null, "You have logged in successfully", "Success",
                                            JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                            //a pop-up box
                            JOptionPane.showMessageDialog(null, "Login failed!", "Failed!",
                                            JOptionPane.INFORMATION_MESSAGE);
                    }
            }
                });
        }
        
        void createAndShowGUI(){
                JFrame.setDefaultLookAndFeelDecorated(true);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(500, 400);
                frame1.setVisible(true);
                
                login();
        }
        
        public static void main(String[] args)
        {
          new LOGINPAGE();
        }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}