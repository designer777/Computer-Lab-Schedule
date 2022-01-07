import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.WindowConstants;


/**
 *
 * @author Kevin
 */
public class UserMenu extends JFrame implements ActionListener {
    
        //Container
    private Container c;

    //JLabels and JButtons
    private JLabel title;
    private JButton exitButton;
    private JButton viewTimetableButton;
    private JButton addAClassButton;
    private JButton searchButton;

    //Object Declarations
    private Welcome welcome;
    private Timetable timetable;
    private AddNewClass addclass;
    private SearchMenu searchMenu;
    private SignIn signIn;

    public UserMenu(SignIn s) {
        super ();
        c = this.getContentPane();
        setTitle("Computer Lab Schedule");
        c.setLayout(null);
        c.setBackground(Color.BLACK);
        signIn = s;
        createUserMenu();
    }

    public void createUserMenu() {
        setPreferredSize(new Dimension(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT));
        //Title
        title = new JLabel("The Main Menu");
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setBounds(200, 50, 500, 50);
        c.add(title);

        //View Timetable Button
        viewTimetableButton = new JButton("<html><i>View Timetable</i></html>");
        viewTimetableButton.setFont(new Font("Serif", Font.BOLD, 20));
        viewTimetableButton.setBounds(200, 150, 250, 150);
        viewTimetableButton.setBackground(Color.ORANGE);
        viewTimetableButton.addActionListener(this);
        c.add(viewTimetableButton);

        //Add A Button
        addAClassButton = new JButton("<html><i>Add A Class</i></html>");
        addAClassButton.setFont(new Font("Serif", Font.BOLD, 20));
        addAClassButton.setBounds(500, 150, 250, 150);
        addAClassButton.setBackground(Color.ORANGE);
        addAClassButton.addActionListener(this);
        c.add(addAClassButton);

        //Search Button
        searchButton = new JButton("<html><i>Search</i></html>");
        searchButton.setFont(new Font("Serif", Font.BOLD, 20));
        searchButton.setBounds(200, 350, 250, 150);
        searchButton.setBackground(Color.ORANGE);
        searchButton.addActionListener(this);
        c.add(searchButton);

        //Exit Button
        exitButton = new JButton("<html></i>Exit</i></html>");
        exitButton.setFont(new Font("Serif", Font.BOLD, 20));
        exitButton.setBounds(500, 350, 250, 150);
        exitButton.addActionListener(this);
        exitButton.setBackground(Color.ORANGE);
        c.add(exitButton);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        
        //If the exit button is pressed
        if (evt.getSource() == exitButton) {
            System.exit(0);
        }
        
        //if the add a class button is pressed
        if (evt.getSource() == addAClassButton) {
            // Getting the text from the text fields
            // Writing the period, day of week, teacher's name and course code to a text file
            dispose();
            c.removeAll();
            repaint();
            welcome = new Welcome();
            timetable = new Timetable(this);
            addclass = new AddNewClass(timetable, this);
            addclass.setVisible(true);
            addclass.pack();
            addclass.setSize(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT);
            addclass.setLocationRelativeTo(null);
            addclass.setResizable(false);
            addclass.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        //If the view time table button is pressed
        if (evt.getSource() == viewTimetableButton) {
            // Getting the text from the text fields
            // Writing the period, day of week, teacher's name and course code to a text file

            dispose();
            c.removeAll();
            repaint();
            welcome = new Welcome();
            timetable = new Timetable(this);
            timetable.setVisible(true);
            timetable.pack();
            timetable.setSize(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT);
            timetable.setLocationRelativeTo(null);
            timetable.setResizable(false);
            timetable.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        }
        
        //If the search button is pressed
        if (evt.getSource()  == searchButton) {
            dispose();
            c.removeAll();
            repaint();
            welcome = new Welcome();
            timetable = new Timetable(this);
            searchMenu = new SearchMenu(timetable);
            searchMenu.setVisible(true);
            searchMenu.pack();
            searchMenu.setSize(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT);
            searchMenu.setLocationRelativeTo(null);
            searchMenu.setResizable(false);
            searchMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }
    
}
