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
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Kevin
 */
public class SignIn extends JFrame implements ActionListener {

    //Container
    private Container c;

    //JLabels, JButtons and JTextfields
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JTextField passwordTextField;
    private JLabel unsuccessfulLogin;
    private JLabel title;
    private JButton loginButton;
    private JButton exitButton;
    private JButton homeButton;

    //The Scanner
    private Scanner input;

    //Object Declaration
    private UserMenu menu;
    private Welcome welcome;

    //String Declaration (Usernames and Passwords that already exist)
    private String theUsername;
    private String thePassword;

    //String Declaration (The username and password that the user enters into the JTextfield)
    private String username;
    private String password;

    //Integer Declaration and Initialization
    private int accountCount;

    //Boolean variable declaration and initialization
    private boolean successfulSignIn = false;

    public SignIn() {
        super();
        c = this.getContentPane();
        setTitle("Computer Lab Schedule");
        c.setLayout(null);
        c.setBackground(Color.BLACK);
        createSignInScreen();
    }

    public void createSignInScreen() {
        setPreferredSize(new Dimension(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT));
        //Title
        title = new JLabel("Login Page");
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setBounds(20, 40, 500, 50);
        c.add(title);

        //Username JLabel
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(20, 120, 80, 25);
        usernameLabel.setForeground(Color.CYAN);
        c.add(usernameLabel);

        //Username Text Field
        usernameTextField = new JTextField(30);
        usernameTextField.setBounds(100, 120, 260, 25);
        c.add(usernameTextField);

        //Password JLabel
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20, 170, 80, 25);
        passwordLabel.setForeground(Color.CYAN);
        c.add(passwordLabel);

        //Password Text Field
        passwordTextField = new JPasswordField(30);
        passwordTextField.setBounds(100, 170, 260, 25);
        c.add(passwordTextField);

        //Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 250, 100, 25);
        loginButton.setBackground(Color.ORANGE);
        loginButton.addActionListener(this);
        c.add(loginButton);

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

        //Unsuccessful login message
        unsuccessfulLogin = new JLabel();
        unsuccessfulLogin.setBounds(50, 325, 500, 25);
        unsuccessfulLogin.setForeground(Color.GREEN);
        c.add(unsuccessfulLogin);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        username = usernameTextField.getText();
        password = passwordTextField.getText();
        try {
            input = new Scanner(new File("loginInformation.txt"));
        } catch (IOException io) {
            io.getMessage();
        }
        accountCount = 1;
        try {
            while (input.hasNext()) {
                String theUsername = input.next();
                String thePassword = input.next();
                if (!username.equalsIgnoreCase(theUsername) || !password.equalsIgnoreCase(thePassword)) {
                    accountCount++;
                } else {
                    break;
                }
            }
        } catch (NullPointerException np) {
            np.getMessage();
        }
        File file = new File("accountCount.txt");
        try {
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(accountCount);
            pw.close();
        } catch (IOException io) {
            io.getMessage();
        }

        //If the exit button is pressed
        if (evt.getSource() == exitButton) {
            System.exit(0);
        }

        //If the login button is pressed
        if (evt.getSource() == loginButton) {

            try {
                input = new Scanner(new File("loginInformation.txt"));
            } catch (IOException io) {
                io.getMessage();
            }

            //Checking if an account exists
            //Not case sensitive
            try {
                while (input.hasNext()) {
                    theUsername = input.next();
                    thePassword = input.next();
                    if (username.equalsIgnoreCase(theUsername) && password.equalsIgnoreCase(thePassword)) {
                        successfulSignIn = true;
                    } else {
                        unsuccessfulLogin.setText("LOGIN NOT SUCCESSFUL!");
                        unsuccessfulLogin.setVisible(true);
                    }
                }
            } catch (NullPointerException np) {
                unsuccessfulLogin.setText("LOGIN NOT SUCCESSFUL!");
                unsuccessfulLogin.setVisible(true);
                np.getLocalizedMessage();
            }

            //Signing into the program/Displaying the user menu
            try {
                input.close();
                if (successfulSignIn) {
                    dispose();
                    c.removeAll();
                    repaint();
                    menu = new UserMenu(this);
                    welcome = new Welcome();
                    menu.setVisible(true);
                    menu.pack();
                    menu.setSize(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT);
                    menu.setLocationRelativeTo(null);
                    menu.setResizable(false);
                    menu.setVisible(true);
                    menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                }
            } catch (NullPointerException np) {
                np.getMessage();
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

    /*
    @return the username that the user signs into the program with
     */
    public String getUsername() {
        return username;
    }

    /*
    @return the password that the user signs into the program with
     */
    public String getPassword() {
        return password;
    }

    /*
    @return the account number
     */
    public int getAccountCount() {
        return accountCount;
    }
}
