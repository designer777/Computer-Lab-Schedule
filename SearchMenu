import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Kevin
 */
public class SearchMenu extends JFrame implements ActionListener {

    //Container
    private Container c;

    //Object Declaration
    private Welcome welcome;
    private TeacherSearch teacherSearch;
    private CourseSearch courseSearch;
    private Timetable timetable;
    private SignIn signIn;
    private UserMenu userMenu;

    //JLabels and JButtons
    private JLabel title;
    private JButton teacherSearchButton;
    private JButton courseSearchButton;
    private JButton exitButton;
    private JButton menuButton;

    public SearchMenu(Timetable t) {
        super();
        c = this.getContentPane();
        setTitle("Computer Lab Schedule");
        c.setLayout(null);
        c.setBackground(Color.BLACK);
        timetable = t;
        createSearchScreen();
    }

    public void createSearchScreen() {
        // Title
        title = new JLabel("Searching Menu");
        title.setForeground(Color.MAGENTA);
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setBounds(200, 50, 500, 50);
        c.add(title);

        //Teacher Search Button
        teacherSearchButton = new JButton("<html><i>Teacher Search</i></html>");
        teacherSearchButton.setFont(new Font("Serif", Font.BOLD, 20));
        teacherSearchButton.setBounds(200, 150, 250, 150);
        teacherSearchButton.setBackground(Color.PINK);
        teacherSearchButton.addActionListener(this);
        c.add(teacherSearchButton);

        //Course Search Button
        courseSearchButton = new JButton("<html><i>Course Search</i></html>");
        courseSearchButton.setFont(new Font("Serif", Font.BOLD, 20));
        courseSearchButton.setBounds(500, 150, 250, 150);
        courseSearchButton.setBackground(Color.PINK);
        courseSearchButton.addActionListener(this);
        c.add(courseSearchButton);

        //Menu Button
        menuButton = new JButton("<html><i>Main Menu</i></html>");
        menuButton.setFont(new Font("Serif", Font.BOLD, 20));
        menuButton.setBounds(200, 350, 250, 150);
        menuButton.setBackground(Color.PINK);
        menuButton.addActionListener(this);
        c.add(menuButton);

        //Exit Button
        exitButton = new JButton("<html><i>Exit</i></html>");
        exitButton.setFont(new Font("Serif", Font.BOLD, 20));
        exitButton.setBounds(500, 350, 250, 150);
        exitButton.setBackground(Color.PINK);
        exitButton.addActionListener(this);
        c.add(exitButton);

    }


   @Override
    public void actionPerformed(ActionEvent evt) {
        //If the exit button is pressed
        if (evt.getSource() == exitButton) {
            System.exit(0);
        }
        
        //If the menu button is pressed
        if (evt.getSource() == menuButton) {
            dispose();
            c.removeAll();
            repaint();
            userMenu = new UserMenu(signIn);
            welcome = new Welcome();
            userMenu.setVisible(true);
            userMenu.pack();
            userMenu.setSize(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT);
            userMenu.setLocationRelativeTo(null);
            userMenu.setResizable(false);
            userMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        //If the teacher search button is pressed
        if (evt.getSource() == teacherSearchButton) {
            dispose();
            c.removeAll();
            repaint();
            teacherSearch = new TeacherSearch(timetable);
            welcome = new Welcome();
            teacherSearch.setVisible(true);
            teacherSearch.pack();
            teacherSearch.setSize(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT);
            teacherSearch.setLocationRelativeTo(null);
            teacherSearch.setResizable(false);
            teacherSearch.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        //If the course search button is pressed
        if (evt.getSource() == courseSearchButton) {
            dispose();
            c.removeAll();
            repaint();
            courseSearch = new CourseSearch(timetable);
            welcome = new Welcome();
            courseSearch.setVisible(true);
            courseSearch.pack();
            courseSearch.setSize(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT);
            courseSearch.setLocationRelativeTo(null);
            courseSearch.setResizable(false);
            courseSearch.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }

}

