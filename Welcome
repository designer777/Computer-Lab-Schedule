import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
/**
 *
 * @author Kevin
 */
public class Welcome extends JFrame implements ActionListener {
    
     //Integer Declarations (Window width and height of the program)
    public final static int WINDOWWIDTH = 1000;
    public final static int WINDOWHEIGHT = 600;

    //JLabels and JButtons
    private JButton registerButton;
    private JButton signInButton;
    private JLabel title;

    //Objects
    private SignIn signIn;
    private Register register;

    //Container
    private Container c;
  
    public Welcome() {
        super();
        c = this.getContentPane();
        setTitle("Computer Lab Schedule");
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        createWelcomeScreen();
    }

    public void createWelcomeScreen() {
        
        //Title
        title = new JLabel("Computer Lab Schedule");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setBounds(350, 40, 500, 50);
        c.add(title);

        //Registration Button
        registerButton = new JButton("<html><i>Registration</i></html>");
        registerButton.setHorizontalAlignment(SwingConstants.CENTER);
        registerButton.setVerticalAlignment(SwingConstants.CENTER);
        registerButton.setFont(new Font("Serif", Font.BOLD, 20));
        registerButton.setBounds(200, 150, 100, 25);
        registerButton.setSize(275, 275);
        registerButton.setBackground(Color.PINK);
        registerButton.addActionListener(this);
        c.add(registerButton);

        //Sign In Button
        signInButton = new JButton("<html><i>Login</i></html>");
        signInButton.setHorizontalAlignment(SwingConstants.CENTER);
        signInButton.setVerticalAlignment(SwingConstants.CENTER);
        signInButton.setFont(new Font("Serif", Font.BOLD, 20));
        signInButton.setBounds(500, 150, 100, 25);
        signInButton.setSize(275, 275);
        signInButton.setBackground(Color.PINK);
        signInButton.addActionListener(this);
        c.add(signInButton);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        //If the register button is pressed
        if (evt.getSource() == registerButton) {
            dispose();
            c.removeAll();
            repaint();
            register = new Register();
            register.setVisible(true);
            register.pack();
            register.setSize(WINDOWWIDTH, WINDOWHEIGHT);
            register.setLocationRelativeTo(null);
            register.setResizable(false);
            register.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        //If the sign in button is pressed
        if (evt.getSource() == signInButton) {
            dispose();
            c.removeAll();
            repaint();
            signIn = new SignIn();
            signIn.setVisible(true);
            signIn.pack();
            signIn.setSize(WINDOWWIDTH, WINDOWHEIGHT);
            signIn.setLocationRelativeTo(null);
            signIn.setResizable(false);
            signIn.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }
    
}

