import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Kevin
 */
public class AddNewClass extends JFrame implements ActionListener, KeyListener {

    // Container
    private Container c;

    //JLabels, JButtons and JTextFields
    private JLabel title;
    private JLabel teachersNameLabel;
    private JTextField teachersNameTextField;
    private JLabel courseLabel;
    private JTextField courseTextField;
    private JLabel periodLabel;
    private JLabel dayOfWeekLabel;
    private JButton addClassButton;
    private JButton exitButton;
    private JButton menuButton;
    private JButton mondayButton;
    private JButton tuesdayButton;
    private JButton wednesdayButton;
    private JButton thursdayButton;
    private JButton fridayButton;
    private JButton period1Button;
    private JButton period2Button;
    private JButton period3Button;
    private JButton period4Button;
    private JLabel incompleteFieldsWarningLabel;
    private JLabel overlapWarningLabel;

    //Objects Declaration
    private Welcome welcome;
    private Timetable timetable;
    private UserMenu userMenu;
    private SignIn signIn;

    //String Declaration and Initialization
    private String period = "";
    private String dayOfWeek = "";

    //Booleab Declaration
    private boolean successfulAddition;

    //Integer Declaration
    private int accountCount;

    //Scanner Declaration
    private Scanner input;

    public AddNewClass(Timetable t, UserMenu u) {
        super();
        timetable = t;
        c = this.getContentPane();
        setTitle("Computer Lab Schedule");
        c.setLayout(null);
        c.setBackground(Color.BLACK);
        userMenu = u;
        addAClassMenu();
    }
    
    public void addAClassMenu() {
        setPreferredSize(new Dimension(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT));
        // Title
        title = new JLabel("Add New Class");
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setBounds(20, 40, 500, 50);
        c.add(title);

        // Teacher JLabel
        teachersNameLabel = new JLabel("Please Enter The Teachers Name");
        teachersNameLabel.setBounds(20, 120, 250, 25);
        teachersNameLabel.setForeground(Color.CYAN);
        c.add(teachersNameLabel);

        // Teacher Text Field
        teachersNameTextField = new JTextField(30);
        teachersNameTextField.addKeyListener(this);
        teachersNameTextField.setBounds(250, 120, 260, 25);
        c.add(teachersNameTextField);

        // Course JLabel
        courseLabel = new JLabel("Please Enter The Course Code");
        courseLabel.setBounds(20, 170, 250, 25);
        courseLabel.setForeground(Color.CYAN);
        c.add(courseLabel);

        // Course Text Field
        courseTextField = new JTextField(30);
        courseTextField.addKeyListener(this);
        courseTextField.setBounds(250, 170, 260, 25);
        c.add(courseTextField);

        // Period JLabel
        periodLabel = new JLabel("Please Select The Period");
        periodLabel.setBounds(20, 220, 250, 25);
        periodLabel.setForeground(Color.CYAN);
        c.add(periodLabel);

        //Period 1 Button
        period1Button = new JButton("Period 1");
        period1Button.setBounds(250, 220, 125, 25);
        period1Button.addActionListener(this);
        c.add(period1Button);

        //Period 2 Button
        period2Button = new JButton("Period 2");
        period2Button.setBounds(400, 220, 125, 25);
        period2Button.addActionListener(this);
        c.add(period2Button);

        //Period 3 Button
        period3Button = new JButton("Period 3");
        period3Button.setBounds(550, 220, 125, 25);
        period3Button.addActionListener(this);
        c.add(period3Button);

        //Period 4 Button
        period4Button = new JButton("Period 4");
        period4Button.setBounds(700, 220, 125, 25);
        period4Button.addActionListener(this);
        c.add(period4Button);

        //Day of Week Label
        dayOfWeekLabel = new JLabel("Please Select The Day of Week");
        dayOfWeekLabel.setBounds(20, 270, 250, 25);
        dayOfWeekLabel.setForeground(Color.CYAN);
        c.add(dayOfWeekLabel);

        //Monday Button
        mondayButton = new JButton("Monday");
        mondayButton.setBounds(250, 270, 125, 25);
        mondayButton.addActionListener(this);
        c.add(mondayButton);

        //Tuesday Button
        tuesdayButton = new JButton("Tuesday");
        tuesdayButton.setBounds(400, 270, 125, 25);
        tuesdayButton.addActionListener(this);
        c.add(tuesdayButton);

        //Wednesday Button
        wednesdayButton = new JButton("Wednesday");
        wednesdayButton.setBounds(550, 270, 125, 25);
        wednesdayButton.addActionListener(this);
        c.add(wednesdayButton);

        //Thursday Button
        thursdayButton = new JButton("Thursday");
        thursdayButton.setBounds(700, 270, 125, 25);
        thursdayButton.addActionListener(this);
        c.add(thursdayButton);

        //Friday Button
        fridayButton = new JButton("Friday");
        fridayButton.setBounds(850, 270, 125, 25);
        fridayButton.addActionListener(this);
        c.add(fridayButton);

        // Add A Class Button
        addClassButton = new JButton("Add Class");
        addClassButton.setBounds(250, 350, 125, 25);
        addClassButton.setBackground(Color.ORANGE);
        addClassButton.addActionListener(this);
        c.add(addClassButton);

        // Menu Button
        menuButton = new JButton("Main Menu");
        menuButton.setBounds(400, 350, 125, 25);
        menuButton.setBackground(Color.orange);
        menuButton.addActionListener(this);
        c.add(menuButton);

        // Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(550, 350, 125, 25);
        exitButton.setBackground(Color.ORANGE);
        exitButton.addActionListener(this);
        c.add(exitButton);

        // Warning Label For Incomplete Fields
        incompleteFieldsWarningLabel = new JLabel("PLEASE FILL IN ALL THE FIELDS");
        incompleteFieldsWarningLabel.setBounds(250, 400, 500, 25);
        incompleteFieldsWarningLabel.setForeground(Color.PINK);
        incompleteFieldsWarningLabel.setVisible(false);
        c.add(incompleteFieldsWarningLabel);

        // Warning Label For Overlapping Classes 
        overlapWarningLabel = new JLabel("A CLASS ALREADY RESERVED THE COMPUTER LAB FOR THIS TIME");
        overlapWarningLabel.setBounds(280, 400, 500, 25);
        overlapWarningLabel.setForeground(Color.PINK);
        overlapWarningLabel.setVisible(false);
        c.add(overlapWarningLabel);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        //If the Period 1 Button is pressed
        if (evt.getSource() == period1Button) {
            period = "1";
            period1Button.setBackground(Color.GREEN);
            period2Button.setBackground(new JButton().getBackground());
            period3Button.setBackground(new JButton().getBackground());
            period4Button.setBackground(new JButton().getBackground());
        }

        //If the Period 2 Button is pressed
        if (evt.getSource() == period2Button) {
            period = "2";
            period1Button.setBackground(new JButton().getBackground());
            period2Button.setBackground(Color.GREEN);
            period3Button.setBackground(new JButton().getBackground());
            period4Button.setBackground(new JButton().getBackground());
        }

        //If the Period 3 Button is pressed
        if (evt.getSource() == period3Button) {
            period = "3";
            period1Button.setBackground(new JButton().getBackground());
            period2Button.setBackground(new JButton().getBackground());
            period3Button.setBackground(Color.GREEN);
            period4Button.setBackground(new JButton().getBackground());
        }

        //If the Period 4 Button is pressed
        if (evt.getSource() == period4Button) {
            period = "4";
            period1Button.setBackground(new JButton().getBackground());
            period2Button.setBackground(new JButton().getBackground());
            period3Button.setBackground(new JButton().getBackground());
            period4Button.setBackground(Color.GREEN);
        }

        //If the Monday Button is pressed
        if (evt.getSource() == mondayButton) {
            dayOfWeek = "Monday";
            mondayButton.setBackground(Color.GREEN);
            tuesdayButton.setBackground(new JButton().getBackground());
            wednesdayButton.setBackground(new JButton().getBackground());
            thursdayButton.setBackground(new JButton().getBackground());
            fridayButton.setBackground(new JButton().getBackground());
        }

        //If the Tuesday Button is pressed
        if (evt.getSource() == tuesdayButton) {
            dayOfWeek = "Tuesday";
            mondayButton.setBackground(new JButton().getBackground());
            tuesdayButton.setBackground(Color.GREEN);
            wednesdayButton.setBackground(new JButton().getBackground());
            thursdayButton.setBackground(new JButton().getBackground());
            fridayButton.setBackground(new JButton().getBackground());
        }

        //If the Wednesday Button is pressed
        if (evt.getSource() == wednesdayButton) {
            dayOfWeek = "Wednesday";
            mondayButton.setBackground(new JButton().getBackground());
            tuesdayButton.setBackground(new JButton().getBackground());
            wednesdayButton.setBackground(Color.GREEN);
            thursdayButton.setBackground(new JButton().getBackground());
            fridayButton.setBackground(new JButton().getBackground());
        }

        //If the Thursday Button is pressed
        if (evt.getSource() == thursdayButton) {
            dayOfWeek = "Thursday";
            mondayButton.setBackground(new JButton().getBackground());
            tuesdayButton.setBackground(new JButton().getBackground());
            wednesdayButton.setBackground(new JButton().getBackground());
            thursdayButton.setBackground(Color.GREEN);
            fridayButton.setBackground(new JButton().getBackground());
        }

        //If the Friday Button is pressed
        if (evt.getSource() == fridayButton) {
            dayOfWeek = "Friday";
            mondayButton.setBackground(new JButton().getBackground());
            tuesdayButton.setBackground(new JButton().getBackground());
            wednesdayButton.setBackground(new JButton().getBackground());
            thursdayButton.setBackground(new JButton().getBackground());
            fridayButton.setBackground(Color.GREEN);
        }

        //If the Add Class Button is pressed
        if (evt.getSource() == addClassButton) {
            // Getting the text from the text fields
            String teachersName = teachersNameTextField.getText();
            String courseCode = courseTextField.getText();
            String thePeriod = period;
            String theDayOfWeek = dayOfWeek;

            //Checking if all the fields have been fileld in
            if (thePeriod.equals("") || theDayOfWeek.equals("") || teachersName.equals("") || courseCode.equals("")) {
                incompleteFieldsWarningLabel.setVisible(true);
            } else {
                // Checking which account the user is using
                try {
                    input = new Scanner(new File("accountCount.txt"));
                } catch (IOException io) {
                    io.getMessage();
                }
                try {
                    while (input.hasNext()) {
                        accountCount = Integer.parseInt(input.next());
                    }
                } catch (NullPointerException np) {
                    np.getMessage();
                }
                /*Writing the period, the day of week, the teacher's name and the course code
                 * to a textfile*/
                File file = new File("newClassDetails" + accountCount + ".txt");
                try {
                    //Writing to the text file with buffered writer
                    int numericalDayOfWeek = -1;
                    int numericalPeriod = Integer.parseInt(period) - 1;
                    if (theDayOfWeek.equals("Monday")) {
                        numericalDayOfWeek = 0;
                    } else if (theDayOfWeek.equals("Tuesday")) {
                        numericalDayOfWeek = 1;
                    } else if (theDayOfWeek.equals("Wednesday")) {
                        numericalDayOfWeek = 2;
                    } else if (theDayOfWeek.equals("Thursday")) {
                        numericalDayOfWeek = 3;
                    } else if (theDayOfWeek.equals("Friday")) {
                        numericalDayOfWeek = 4;
                    }
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    if (timetable.getReserved()[numericalDayOfWeek][numericalPeriod] == false) {
                        bw.write(thePeriod + "\n");
                        bw.write(theDayOfWeek + "\n");
                        bw.write(teachersName + "\n");
                        bw.write(courseCode + "\n");
                    }
                    bw.close();
                } catch (IOException io) {
                    io.getMessage();
                }
            }
            //Checking the user's choices
            if (thePeriod.equals("1") && theDayOfWeek.equals("Monday")) {
                if (timetable.getReserved()[0][0] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[2][1] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("1") && theDayOfWeek.equals("Tuesday")) {
                if (timetable.getReserved()[1][0] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[3][1] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("1") && theDayOfWeek.equals("Wednesday")) {
                if (timetable.getReserved()[2][0] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[4][1] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("1") && theDayOfWeek.equals("Thursday")) {
                if (timetable.getReserved()[3][0] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[5][1] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("1") && theDayOfWeek.equals("Friday")) {
                if (timetable.getReserved()[4][0] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[6][1] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("2") && theDayOfWeek.equals("Monday")) {
                if (timetable.getReserved()[0][1] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[2][2] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("2") && theDayOfWeek.equals("Tuesday")) {
                if (timetable.getReserved()[1][1] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[3][2] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("2") && theDayOfWeek.equals("Wednesday")) {
                if (timetable.getReserved()[2][1] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[4][2] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("2") && theDayOfWeek.equals("Thursday")) {
                if (timetable.getReserved()[3][1] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[5][2] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("2") && theDayOfWeek.equals("Friday")) {
                if (timetable.getReserved()[4][1] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[6][2] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("3") && theDayOfWeek.equals("Monday")) {
                if (timetable.getReserved()[0][2] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[2][4] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("3") && theDayOfWeek.equals("Tuesday")) {
                if (timetable.getReserved()[1][2] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[3][4] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("3") && theDayOfWeek.equals("Wednesday")) {
                if (timetable.getReserved()[2][2] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[4][4] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("3") && theDayOfWeek.equals("Thursday")) {
                if (timetable.getReserved()[3][2] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[5][4] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("3") && theDayOfWeek.equals("Friday")) {
                if (timetable.getReserved()[4][2] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[6][4] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("4") && theDayOfWeek.equals("Monday")) {
                if (timetable.getReserved()[0][3] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[2][5] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("4") && theDayOfWeek.equals("Tuesday")) {
                if (timetable.getReserved()[1][3] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[3][5] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("4") && theDayOfWeek.equals("Wednesday")) {
                if (timetable.getReserved()[2][3] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[4][5] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("4") && theDayOfWeek.equals("Thursday")) {
                if (timetable.getReserved()[3][3] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[5][5] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }
            if (thePeriod.equals("4") && theDayOfWeek.equals("Friday")) {
                if (timetable.getReserved()[4][3] == false) {
                    successfulAddition = true;
                    timetable.getTimetable()[6][5] = thePeriod + "\n" + theDayOfWeek
                            + "\n" + teachersName + "\n" + courseCode;
                } else {
                    successfulAddition = false;
                    JOptionPane.showMessageDialog(welcome, "This time is already reserved!");
                }
            }

            if (successfulAddition == true) {
                dispose();
                c.removeAll();
                repaint();
                welcome = new Welcome();
                timetable = new Timetable(userMenu);
                timetable.setVisible(true);
                timetable.pack();
                timetable.setSize(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT);
                timetable.setLocationRelativeTo(null);
                timetable.setResizable(false);
                timetable.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        }

        //If the Exit Button is pressed
        if (evt.getSource()
                == exitButton) {
            System.exit(0);
        }

        //If the Main Menu Button is pressed
        if (evt.getSource() == menuButton) {
            dispose();
            c.removeAll();
            repaint();
            welcome = new Welcome();
            userMenu = new UserMenu(signIn);
            userMenu.setVisible(true);
            userMenu.pack();
            userMenu.setSize(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT);
            userMenu.setLocationRelativeTo(null);
            userMenu.setResizable(false);
            userMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (teachersNameTextField.getText().length() >= 10) {
            getToolkit().beep();
            evt.consume();
        }
        if (courseTextField.getText().length() >= 10) {
            getToolkit().beep();
            evt.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {

    }

    @Override
    public void keyPressed(KeyEvent evt) {

    }
}
