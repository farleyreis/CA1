
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

public class CA1 extends JPanel {
    
 

    static JButton button1;
    static JButton button2;

    static JTextField ta;
    
    static AppointmentBook appBook = new AppointmentBook();
    static EventHandler eventHandler;
    
    public static void CreateandShowGUI() {
        
        
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
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
        
       
        
    }
    
    public static class EventHandler implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button1) {
                CLIENT nc = new CLIENT();
                
                
                
                
                
            }
            
           else if (e.getSource() == button2) {
                SERVICEPROVIDER nc = new SERVICEPROVIDER();
            }
            
            
        }
    }
    
    public static void main(String[] args) {
        
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateandShowGUI();
            }
            
        });
        
    }
}

