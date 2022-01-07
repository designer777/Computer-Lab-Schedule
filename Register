import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 *
 * @author Kevin
 */
public class Register extends JFrame implements ActionListener {

    //Container
    private Container c;

    //JLabels, JButtons and JTextfields
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JTextField passwordTextField;
    private JLabel title;
    private JButton registerButton;
    private JButton exitButton;
    private JLabel usernameWarning;
    private JLabel passwordWarning;
    private JButton homeButton;

    //Object Declaration
    private Welcome welcome;
    private SignIn signIn;

    //Scanner Declaration
    private Scanner input;

    //Integer Declaration
    private int count;

    public Register() {
        super();
        c = this.getContentPane();
        setTitle("Computer Lab Schedule");
        c.setLayout(null);
        c.setBackground(Color.BLACK);
        createRegisterScreen();

    }

    public void createRegisterScreen() {
        setPreferredSize(new Dimension(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT));

        //Title
        title = new JLabel("Registration Page");
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setBounds(20, 40, 500, 50);
        c.add(title);

        //Username JLabel
        usernameLabel = new JLabel("Please Create A Username");
        usernameLabel.setBounds(20, 120, 180, 25);
        usernameLabel.setForeground(Color.CYAN);
        c.add(usernameLabel);

        //Username Text Field
        usernameTextField = new JTextField(30);
        usernameTextField.setBounds(220, 120, 260, 25);
        c.add(usernameTextField);

        //Password JLabel
        passwordLabel = new JLabel("Please Create A Password");
        passwordLabel.setBounds(20, 170, 180, 25);
        passwordLabel.setForeground(Color.CYAN);
        c.add(passwordLabel);

        //Password Text Field
        passwordTextField = new JPasswordField(30);
        passwordTextField.setBounds(220, 170, 260, 25);
        c.add(passwordTextField);

        //Register Button
        registerButton = new JButton("Sign Up");
        registerButton.setBounds(50, 250, 100, 25);
        registerButton.setBackground(Color.ORANGE);
        registerButton.addActionListener(this);
        c.add(registerButton);

        //Return To Welcome Page Button
        homeButton = new JButton("Home");
        homeButton.setBounds(200, 250, 100, 25);
        homeButton.setBackground(Color.ORANGE);
        homeButton.addActionListener(this);
        c.add(homeButton);

        //Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(350, 250, 100, 25);
        exitButton.setBackground(Color.ORANGE);
        exitButton.addActionListener(this);
        c.add(exitButton);

        //Username warning if the user has a blank username
        usernameWarning = new JLabel();
        usernameWarning.setBounds(20, 330, 500, 25);
        usernameWarning.setForeground(Color.GREEN);
        c.add(usernameWarning);

        //Password warning if the user has a blank password
        passwordWarning = new JLabel();
        passwordWarning.setBounds(20, 380, 500, 25);
        passwordWarning.setForeground(Color.GREEN);
        c.add(passwordWarning);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        //If registration button is pressed and no username is entered
        if (evt.getSource() == registerButton && username.equals("")) {
            usernameWarning.setText("Please Enter A Valid Username!");
        }

        //If registration button is pressed and a username is entered
        if (evt.getSource() == registerButton && !username.equals("")) {
            usernameWarning.setText("");
        }

        //If registration button is pressed and no password is entered
        if (evt.getSource() == registerButton && password.equals("")) {
            passwordWarning.setText("Please Enter A Valid Password!");
        }

        //If registration button is pressed and a username is entered
        if (evt.getSource() == registerButton && !password.equals("")) {
            passwordWarning.setText("");
        }

        //If exit button is pressed
        if (evt.getSource() == exitButton) {
            System.exit(0);
        }

        //If registration button is pressed and both a username and password are entered
        if (evt.getSource() == registerButton && !username.equals("") && !password.equals("")) {
            count = 1;
            //Writing the username and password to a text file
            File file = new File("loginInformation.txt");
            try {
                input = new Scanner(file);
            } catch (FileNotFoundException fnf) {
                fnf.getMessage();
            }
            try {
                while (input.hasNext()) {
                    String theUsername = input.next();
                    String thePassword = input.next();
                    if (username.equalsIgnoreCase(theUsername) && password.equalsIgnoreCase(thePassword)) {
                        count++;
                    }
                }
            } catch (NullPointerException np) {
                np.getLocalizedMessage();
            }
            if (count >= 2) {
                JOptionPane.showMessageDialog(welcome, "This Account Already Exists");
            } else {
                try {
                    FileWriter fw = new FileWriter(file, true);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.print(username + "\n");
                    pw.print(password + "\n");
                    pw.close();
                } catch (IOException io) {
                    io.getMessage();
                }
                JOptionPane.showMessageDialog(welcome, "You Have Successfully Registered A New Account");
                dispose();
                c.removeAll();
                repaint();
                signIn = new SignIn();
                welcome = new Welcome();
                signIn.setVisible(true);
                signIn.pack();
                signIn.setSize(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT);
                signIn.setLocationRelativeTo(null);
                signIn.setResizable(false);
                signIn.setVisible(true);
                signIn.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }

        }

        //If the home button is pressed
        if (evt.getSource() == homeButton) {
            dispose();
            c.removeAll();
            repaint();
            welcome = new Welcome();
            welcome.setVisible(true);
            welcome.pack();
            welcome.setSize(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT);
            welcome.setLocationRelativeTo(null);
            welcome.setResizable(false);
            welcome.setVisible(true);
            welcome.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }
}

