import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.io.FileNotFoundException;

/**
 *
 * @author Kevin
 */
public class Timetable extends JFrame implements ActionListener {

    // Container
    private Container c;

    //JLabels and JButtons
    private JLabel title;
    private JButton exitButton;
    private JButton menuButton;
    private JButton clearTimetableButton;

    //Object Declaration
    private Welcome welcome;
    private UserMenu userMenu;
    private SignIn signIn;

    //2D String Array Declaration and Initialization
    private String[][] theTimetable = new String[7][6];

    //ArrayLists for Teacher and Courses Objects
    private TeacherLinkedList linkedListOfPeriod1Teachers = new TeacherLinkedList();
    private TeacherLinkedList linkedListOfPeriod2Teachers = new TeacherLinkedList();
    private TeacherLinkedList linkedListOfPeriod3Teachers = new TeacherLinkedList();
    private TeacherLinkedList linkedListOfPeriod4Teachers = new TeacherLinkedList();

    private CourseLinkedList linkedListOfPeriod1Courses = new CourseLinkedList();
    private CourseLinkedList linkedListOfPeriod2Courses = new CourseLinkedList();
    private CourseLinkedList linkedListOfPeriod3Courses = new CourseLinkedList();
    private CourseLinkedList linkedListOfPeriod4Courses = new CourseLinkedList();

    //Timetable coordinate declaration and initialization
    private final int topLeftX = 100;
    private final int topLeftY = 150;
    private final int XIncrement = 100;
    private final int YIncrement = 50;
    private final int rectangleWidth = 100;
    private final int rectangleHeight = 50;

    //Timetable text coordinate declaration and initialization
    private final int dayOfWeekYCoordinate = 180;
    private final int dayOfWeekXCoordinate = 100;
    private final int dayOfWeekXSpacing = 20;
    private final int LunchBreakXCoordinate = 100;
    private final int LunchBreakXSpacing = 20;
    private final int LunchBreakYCoordinate = 320;
    private final int periodXCoordinate = 110;
    private final int timeXCoordinate = 210;
    private final int periodYCoordinate = 220;
    private final int periodYSpacing = 50;
    private final int timeYCoordinate = 220;
    private final int timeYSpacing = 50;

    //The coordinates of text which  the user chooses after adding a new class
    private final int teachersNameXCoordinate = 320;
    private final int teachersNameXSpacing = 100;
    private final int courseNameXCoordinate = 320;
    private final int courseNameXSpacing = 100;
    private final int teachersNameYCoordinate = 220;
    private final int teachersNameYSpacing = 50;
    private final int courseNameYCoordinate = 240;
    private final int courseNameYSpacing = 50;

    //Integer Declaration (Account count)
    private int accountCount;

    //2D Array Declaration and Initialization (Reserved time periods)
    private boolean[][] reserved = new boolean[5][4];

    //Scanner Declaration
    private Scanner input;

    public Timetable(UserMenu u) {
        super();
        c = this.getContentPane();
        setTitle("Computer Lab Schedule");
        c.setLayout(null);
        c.setBackground(Color.BLACK);
        userMenu = u;
        createInitialTimetable();
    }

    public void createInitialTimetable() {
        setPreferredSize(new Dimension(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT));

        // Title
        title = new JLabel("Computer Lab Schedule");
        title.setForeground(Color.ORANGE);
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setBounds(100, 40, 500, 50);
        c.add(title);

        //Menu Button
        menuButton = new JButton("Main Menu");
        menuButton.setBounds(200, 450, 150, 25);
        menuButton.setBackground(Color.ORANGE);
        menuButton.addActionListener(this);
        c.add(menuButton);

        //Clear Timetable Button
        clearTimetableButton = new JButton("Clear Schedule");
        clearTimetableButton.setBounds(400, 450, 150, 25);
        clearTimetableButton.setBackground(Color.ORANGE);
        clearTimetableButton.addActionListener(this);
        c.add(clearTimetableButton);

        // Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(600, 450, 150, 25);
        exitButton.setBackground(Color.ORANGE);
        exitButton.addActionListener(this);
        c.add(exitButton);

        //Filling the timetable 2D array with the variables
        for (int i = 0; i < theTimetable.length; i++) {
            for (int j = 0; j < theTimetable[i].length; j++) {
                theTimetable[i][j] = "";
                if (i == 2 && j == 0) {
                    theTimetable[i][j] = "Monday";
                } else if (i == 3 && j == 0) {
                    theTimetable[i][j] = "Tuesday";
                } else if (i == 4 && j == 0) {
                    theTimetable[i][j] = "Wednesday";
                } else if (i == 5 && j == 0) {
                    theTimetable[i][j] = "Thursday";
                } else if (i == 6 && j == 0) {
                    theTimetable[i][j] = "Friday";
                } else if (i == 2 && j == 3) {
                    theTimetable[i][j] = "-";
                } else if (i == 3 && j == 3) {
                    theTimetable[i][j] = "-";
                } else if (i == 4 && j == 3) {
                    theTimetable[i][j] = "-";
                } else if (i == 5 && j == 3) {
                    theTimetable[i][j] = "-";
                } else if (i == 6 && j == 3) {
                    theTimetable[i][j] = "-";
                } else if (i == 0 && j == 1) {
                    theTimetable[i][j] = "Period 1";
                } else if (i == 0 && j == 2) {
                    theTimetable[i][j] = "Period 2";
                } else if (i == 0 && j == 3) {
                    theTimetable[i][j] = "Lunch Break";
                } else if (i == 0 && j == 4) {
                    theTimetable[i][j] = "Period 3";
                } else if (i == 0 && j == 5) {
                    theTimetable[i][j] = "Period 4";
                } else if (i == 1 && j == 1) {
                    theTimetable[i][j] = "8:45 - 10:05";
                } else if (i == 1 && j == 2) {
                    theTimetable[i][j] = "10:10 - 11:25";
                } else if (i == 1 && j == 3) {
                    theTimetable[i][j] = "11:25 - 12:25";
                } else if (i == 1 && j == 4) {
                    theTimetable[i][j] = "12:25 - 13:40";
                } else if (i == 1 && j == 5) {
                    theTimetable[i][j] = "13:45 - 15:00";
                }
            }
        }
        try {
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
            File file = new File("newClassDetails" + accountCount + ".txt");
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(file));
            String thePeriod = reader.readLine();
            String theDayOfWeek = reader.readLine();
            String theTeachersName = reader.readLine();
            String theCourseCode = reader.readLine();

            while (thePeriod != null && theDayOfWeek != null && theTeachersName != null && theCourseCode != null) {
                if (thePeriod.equals("1") && theDayOfWeek.equals("Monday")) {
                    reserved[0][0] = true;
                    linkedListOfPeriod1Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod1Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("2") && theDayOfWeek.equals("Monday")) {
                    reserved[0][1] = true;
                    linkedListOfPeriod2Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod2Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("3") && theDayOfWeek.equals("Monday")) {
                    reserved[0][2] = true;
                    linkedListOfPeriod3Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod3Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("4") && theDayOfWeek.equals("Monday")) {
                    reserved[0][3] = true;
                    linkedListOfPeriod4Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod4Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("1") && theDayOfWeek.equals("Tuesday")) {
                    reserved[1][0] = true;
                    linkedListOfPeriod1Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod1Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("2") && theDayOfWeek.equals("Tuesday")) {
                    reserved[1][1] = true;
                    linkedListOfPeriod2Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod2Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("3") && theDayOfWeek.equals("Tuesday")) {
                    reserved[1][2] = true;
                    linkedListOfPeriod3Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod3Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("4") && theDayOfWeek.equals("Tuesday")) {
                    reserved[1][3] = true;
                    linkedListOfPeriod4Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod4Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("1") && theDayOfWeek.equals("Wednesday")) {
                    reserved[2][0] = true;
                    linkedListOfPeriod1Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod1Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("2") && theDayOfWeek.equals("Wednesday")) {
                    reserved[2][1] = true;
                    linkedListOfPeriod2Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod2Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("3") && theDayOfWeek.equals("Wednesday")) {
                    reserved[2][2] = true;
                    linkedListOfPeriod3Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod3Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("4") && theDayOfWeek.equals("Wednesday")) {
                    reserved[2][3] = true;
                    linkedListOfPeriod4Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod4Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("1") && theDayOfWeek.equals("Thursday")) {
                    reserved[3][0] = true;
                    linkedListOfPeriod1Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod1Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("2") && theDayOfWeek.equals("Thursday")) {
                    reserved[3][1] = true;
                    linkedListOfPeriod2Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod2Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("3") && theDayOfWeek.equals("Thursday")) {
                    reserved[3][2] = true;
                    linkedListOfPeriod3Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod3Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("4") && theDayOfWeek.equals("Thursday")) {
                    reserved[3][3] = true;
                    linkedListOfPeriod4Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod4Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("1") && theDayOfWeek.equals("Friday")) {
                    reserved[4][0] = true;
                    linkedListOfPeriod1Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod1Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("2") && theDayOfWeek.equals("Friday")) {
                    reserved[4][1] = true;
                    linkedListOfPeriod2Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod2Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("3") && theDayOfWeek.equals("Friday")) {
                    reserved[4][2] = true;
                    linkedListOfPeriod3Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod3Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                } else if (thePeriod.equals("4") && theDayOfWeek.equals("Friday")) {
                    reserved[4][3] = true;
                    linkedListOfPeriod4Teachers.add(new Teacher(theTeachersName, theCourseCode, theDayOfWeek, thePeriod));
                    linkedListOfPeriod4Courses.add(new Course(theCourseCode, theTeachersName, theDayOfWeek, thePeriod));
                }
                thePeriod = reader.readLine();
                theDayOfWeek = reader.readLine();
                theTeachersName = reader.readLine();
                theCourseCode = reader.readLine();
            }

        } catch (IOException io) {
            io.getMessage();
        }
    }

    //Drawing the timetable
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        g.setColor(Color.YELLOW);
        for (int i = 0; i < theTimetable.length; i++) {
            for (int j = 0; j < theTimetable[i].length; j++) {
                g.drawRect(topLeftX + XIncrement * i, topLeftY + YIncrement * j, rectangleWidth, rectangleHeight);
            }
        }
        for (int i = 0; i < theTimetable.length; i++) {
            for (int j = 0; j < theTimetable[i].length; j++) {
                if (i == 2 && j == 0) {
                    g.drawString("Monday", dayOfWeekXCoordinate * (i + 1) + dayOfWeekXSpacing, dayOfWeekYCoordinate);
                } else if (i == 3 && j == 0) {
                    g.drawString("Tuesday", dayOfWeekXCoordinate * (i + 1) + dayOfWeekXSpacing, dayOfWeekYCoordinate);
                } else if (i == 4 && j == 0) {
                    g.drawString("Wednesday", dayOfWeekXCoordinate * (i + 1) + dayOfWeekXSpacing, dayOfWeekYCoordinate);
                } else if (i == 5 && j == 0) {
                    g.drawString("Thursday", dayOfWeekXCoordinate * (i + 1) + dayOfWeekXSpacing, dayOfWeekYCoordinate);
                } else if (i == 6 && j == 0) {
                    g.drawString("Friday", dayOfWeekXCoordinate * (i + 1) + dayOfWeekXSpacing, dayOfWeekYCoordinate);
                } else if (i == 2 && j == 3) {
                    g.drawString("-", LunchBreakXCoordinate * (i + 1) + LunchBreakXSpacing, LunchBreakYCoordinate);
                } else if (i == 3 && j == 3) {
                    g.drawString("-", LunchBreakXCoordinate * (i + 1) + LunchBreakXSpacing, LunchBreakYCoordinate);
                    theTimetable[i][j] = "-";
                } else if (i == 4 && j == 3) {
                    g.drawString("-", LunchBreakXCoordinate * (i + 1) + LunchBreakXSpacing, LunchBreakYCoordinate);
                    theTimetable[i][j] = "-";
                } else if (i == 5 && j == 3) {
                    g.drawString("-", LunchBreakXCoordinate * (i + 1) + LunchBreakXSpacing, LunchBreakYCoordinate);
                } else if (i == 6 && j == 3) {
                    g.drawString("-", LunchBreakXCoordinate * (i + 1) + LunchBreakXSpacing, LunchBreakYCoordinate);
                } else if (i == 0 && j == 1) {
                    g.drawString("Period 1", periodXCoordinate, periodYCoordinate);
                } else if (i == 0 && j == 2) {
                    g.drawString("Period 2", periodXCoordinate, periodYCoordinate + periodYSpacing);
                } else if (i == 0 && j == 3) {
                    g.drawString("Lunch Break", periodXCoordinate, periodYCoordinate + (2 * periodYSpacing));
                } else if (i == 0 && j == 4) {
                    g.drawString("Period 3", periodXCoordinate, periodYCoordinate + (3 * periodYSpacing));
                } else if (i == 0 && j == 5) {
                    g.drawString("Period 4", periodXCoordinate, periodYCoordinate + (4 * periodYSpacing));
                } else if (i == 1 && j == 1) {
                    g.drawString("8:45 - 10:05", timeXCoordinate, timeYCoordinate);
                } else if (i == 1 && j == 2) {
                    g.drawString("10:10 - 11:25", timeXCoordinate, timeYCoordinate + timeYSpacing);
                } else if (i == 1 && j == 3) {
                    g.drawString("11:25 - 12:25", timeXCoordinate, timeYCoordinate + (2 * timeYSpacing));
                } else if (i == 1 && j == 4) {
                    g.drawString("12:25 - 13:40", timeXCoordinate, timeYCoordinate + (3 * timeYSpacing));
                } else if (i == 1 && j == 5) {
                    g.drawString("13:45 - 15:00", timeXCoordinate, timeYCoordinate + (4 * timeYSpacing));
                }
            }
        }

        try {
            //Using buffered reader to read the file from the text rile
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
            File file = new File("newClassDetails" + accountCount + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String thePeriod = reader.readLine();
            String theDayOfWeek = reader.readLine();
            String theTeachersName = reader.readLine();
            String theCourseCode = reader.readLine();
            while (thePeriod != null && theDayOfWeek != null && theTeachersName != null && theCourseCode != null) {
                if (thePeriod.equals("1") && theDayOfWeek.equals("Monday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate,
                            teachersNameYCoordinate);
                    g.drawString(theCourseCode, courseNameXCoordinate,
                            courseNameYCoordinate);
                } else if (thePeriod.equals("2") && theDayOfWeek.equals("Monday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate,
                            teachersNameYCoordinate + teachersNameYSpacing);
                    g.drawString(theCourseCode, courseNameXCoordinate,
                            courseNameYCoordinate + courseNameYSpacing);
                } else if (thePeriod.equals("3") && theDayOfWeek.equals("Monday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate,
                            teachersNameYCoordinate + (3 * teachersNameYSpacing));
                    g.drawString(theCourseCode, courseNameXCoordinate,
                            courseNameYCoordinate + (3 * courseNameYSpacing));
                } else if (thePeriod.equals("4") && theDayOfWeek.equals("Monday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate,
                            teachersNameYCoordinate + (4 * teachersNameYSpacing));
                    g.drawString(theCourseCode, courseNameXCoordinate,
                            courseNameYCoordinate + (4 * courseNameYSpacing));
                } else if (thePeriod.equals("1") && theDayOfWeek.equals("Tuesday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + teachersNameXSpacing,
                            teachersNameYCoordinate);
                    g.drawString(theCourseCode, courseNameXCoordinate + courseNameXSpacing,
                            courseNameYCoordinate);
                } else if (thePeriod.equals("2") && theDayOfWeek.equals("Tuesday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + teachersNameXSpacing,
                            teachersNameYCoordinate + teachersNameYSpacing);
                    g.drawString(theCourseCode, courseNameXCoordinate + courseNameXSpacing,
                            courseNameYCoordinate + courseNameYSpacing);
                } else if (thePeriod.equals("3") && theDayOfWeek.equals("Tuesday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + teachersNameXSpacing,
                            teachersNameYCoordinate + (3 * teachersNameYSpacing));
                    g.drawString(theCourseCode, courseNameXCoordinate + courseNameXSpacing,
                            courseNameYCoordinate + (3 * courseNameYSpacing));
                } else if (thePeriod.equals("4") && theDayOfWeek.equals("Tuesday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + teachersNameXSpacing,
                            teachersNameYCoordinate + (4 * teachersNameYSpacing));
                    g.drawString(theCourseCode, courseNameXCoordinate + courseNameXSpacing,
                            courseNameYCoordinate + (4 * courseNameYSpacing));
                } else if (thePeriod.equals("1") && theDayOfWeek.equals("Wednesday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + (2 * teachersNameXSpacing),
                            teachersNameYCoordinate);
                    g.drawString(theCourseCode, courseNameXCoordinate + (2 * courseNameXSpacing),
                            courseNameYCoordinate);
                } else if (thePeriod.equals("2") && theDayOfWeek.equals("Wednesday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + (2 * teachersNameXSpacing),
                            teachersNameYCoordinate + teachersNameYSpacing);
                    g.drawString(theCourseCode, courseNameXCoordinate + (2 * courseNameXSpacing),
                            courseNameYCoordinate + courseNameYSpacing);
                } else if (thePeriod.equals("3") && theDayOfWeek.equals("Wednesday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + (2 * teachersNameXSpacing),
                            teachersNameYCoordinate + (3 * teachersNameYSpacing));
                    g.drawString(theCourseCode, courseNameXCoordinate + (2 * courseNameXSpacing),
                            courseNameYCoordinate + (3 * courseNameYSpacing));
                } else if (thePeriod.equals("4") && theDayOfWeek.equals("Wednesday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + (2 * teachersNameXSpacing),
                            teachersNameYCoordinate + (4 * teachersNameYSpacing));
                    g.drawString(theCourseCode, courseNameXCoordinate + (2 * courseNameXSpacing),
                            courseNameYCoordinate + (4 * courseNameYSpacing));
                } else if (thePeriod.equals("1") && theDayOfWeek.equals("Thursday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + (3 * teachersNameXSpacing),
                            teachersNameYCoordinate);
                    g.drawString(theCourseCode, courseNameXCoordinate + (3 * courseNameXSpacing),
                            courseNameYCoordinate);
                } else if (thePeriod.equals("2") && theDayOfWeek.equals("Thursday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + (3 * teachersNameXSpacing),
                            teachersNameYCoordinate + teachersNameYSpacing);
                    g.drawString(theCourseCode, courseNameXCoordinate + (3 * courseNameXSpacing),
                            courseNameYCoordinate + courseNameYSpacing);
                } else if (thePeriod.equals("3") && theDayOfWeek.equals("Thursday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + (3 * teachersNameXSpacing),
                            teachersNameYCoordinate + (3 * teachersNameYSpacing));
                    g.drawString(theCourseCode, courseNameXCoordinate + (3 * courseNameXSpacing),
                            courseNameYCoordinate + (3 * courseNameYSpacing));
                } else if (thePeriod.equals("4") && theDayOfWeek.equals("Thursday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + (3 * teachersNameXSpacing),
                            teachersNameYCoordinate + (4 * teachersNameYSpacing));
                    g.drawString(theCourseCode, courseNameXCoordinate + (3 * courseNameXSpacing),
                            courseNameYCoordinate + (4 * courseNameYSpacing));
                } else if (thePeriod.equals("1") && theDayOfWeek.equals("Friday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + (4 * teachersNameXSpacing),
                            teachersNameYCoordinate);
                    g.drawString(theCourseCode, courseNameXCoordinate + (4 * courseNameXSpacing),
                            courseNameYCoordinate);
                } else if (thePeriod.equals("2") && theDayOfWeek.equals("Friday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + (4 * teachersNameXSpacing),
                            teachersNameYCoordinate + teachersNameYSpacing);
                    g.drawString(theCourseCode, courseNameXCoordinate + (4 * courseNameXSpacing),
                            courseNameYCoordinate + courseNameYSpacing);
                } else if (thePeriod.equals("3") && theDayOfWeek.equals("Friday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + (4 * teachersNameXSpacing),
                            teachersNameYCoordinate + (3 * teachersNameYSpacing));
                    g.drawString(theCourseCode, courseNameXCoordinate + (4 * courseNameXSpacing),
                            courseNameYCoordinate + (3 * courseNameYSpacing));
                } else if (thePeriod.equals("4") && theDayOfWeek.equals("Friday")) {
                    g.drawString(theTeachersName, teachersNameXCoordinate + (4 * teachersNameXSpacing),
                            teachersNameYCoordinate + (4 * teachersNameYSpacing));
                    g.drawString(theCourseCode, courseNameXCoordinate + (4 * courseNameXSpacing),
                            courseNameYCoordinate + (4 * courseNameYSpacing));
                }
                thePeriod = reader.readLine();
                theDayOfWeek = reader.readLine();
                theTeachersName = reader.readLine();
                theCourseCode = reader.readLine();
            }
        } catch (IOException io) {
            io.getMessage();
        }
    }

    /*
    *@return the array of classes that have reserved a time in the computer lab
     */
    public boolean[][] getReserved() {
        return reserved;
    }

    /*
    &@return the timetable array
     */
    public String[][] getTimetable() {
        return theTimetable;
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
            welcome = new Welcome();
            userMenu = new UserMenu(signIn);
            userMenu.setVisible(true);
            userMenu.pack();
            userMenu.setSize(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT);
            userMenu.setLocationRelativeTo(null);
            userMenu.setResizable(false);
            userMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        //If the clear time table button is pressed
        if (evt.getSource() == clearTimetableButton) {
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
            try {
                PrintWriter pw = new PrintWriter("newClassDetails" + accountCount + ".txt");
                pw.close();
                repaint();
            } catch (FileNotFoundException fnf) {
                fnf.getMessage();
            }
        }
    }

    /*
    *@return the array list of teachers for period 1
     */
    public TeacherLinkedList getLinkedListOfPeriod1Teachers() {
        return linkedListOfPeriod1Teachers;
    }

    /*
    *@return the array list of teachers for period 2
     */
    public TeacherLinkedList getLinkedListOfPeriod2Teachers() {
        return linkedListOfPeriod2Teachers;
    }

    /*
    *@return the array list of teachers for period 3
     */
    public TeacherLinkedList getLinkedListOfPeriod3Teachers() {
        return linkedListOfPeriod3Teachers;
    }

    /*
    *@return the array list of teachers for period 4
     */
    public TeacherLinkedList getLinkedListOfPeriod4Teachers() {
        return linkedListOfPeriod4Teachers;
    }

    /*
    *@return the array list of courses for period 1
     */
    public CourseLinkedList getLinkedListOfPeriod1Courses() {
        return linkedListOfPeriod1Courses;
    }

    /*
    *@return the array list of courses for period 2
     */
    public CourseLinkedList getLinkedListOfPeriod2Courses() {
        return linkedListOfPeriod2Courses;
    }

    /*
    *@return the array list of courses for period 3
     */
    public CourseLinkedList getLinkedListOfPeriod3Courses() {
        return linkedListOfPeriod3Courses;
    }

    /*
    *@return the array list of courses for period 4
     */
    public CourseLinkedList getLinkedListOfPeriod4Courses() {
        return linkedListOfPeriod4Courses;
    }
}

