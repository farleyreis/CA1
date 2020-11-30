
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

// Fabiola, I set the Frames to "frame.setSize (500, 400)" width and size
// To make it easier, you can use the structured pages I created, I will try to clean
// the code to make it easy understanding

public class CA1 extends JPanel {
    
//the commands for the next pages
    static JButton button1;
    static JButton button2;

    static JTextField ta;
    
    static AppointmentBook appBook = new AppointmentBook();
    static EventHandler eventHandler;
    
    public static void WelcomeWindow() {
        
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 10));
        
        
        

        button1 = new JButton("CLIENT");
        button2 = new JButton("SERVICE\n" +
                                "PROVIDER");

        
        
        eventHandler = new EventHandler();

        button1.addActionListener(eventHandler);
        button2.addActionListener(eventHandler);

        
        frame.setContentPane(panel);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 400);
        
        
       
        

        panel.add(new JLabel("         "));
        panel.add(new JLabel("Hi!! Welcome to SOS Beauty!\n" +
"Are you a:"));
        panel.add(new JLabel("         "));
        panel.add(button1);
        panel.add(button2);
        
        panel.setBorder(BorderFactory.createTitledBorder("SOS BEAUTY"));
         // this should close the frame and open another one, but it must be in the wrong place.
         // but that will solve it.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public static class EventHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button1) {
                NewClient nc = new NewClient();
                nc.setVisible(true);
             
                
                
                
                
                
            }
            // here your part .. of button2 SERVICEPROVIDER will enter.
             // my old condition is in the SERVICEPROVIDER class, you can copy all code from the NewCliente class and put it in
             // from SERVICEPROVIDER to have the same design.
   
           else if (e.getSource() == button2) {
                SERVICEPROVIDER nc = new SERVICEPROVIDER();
            }
            
            
        }
    }
    
    public static void main(String[] args) {
        
        // this is for open the new windows
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WelcomeWindow();
            }
            
        });
        
    }
}

