import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Kevin
 */
public class CourseSearch extends JFrame implements ActionListener {

    //Container
    private Container c;

    //JLabels, JButtons and JTextField
    private JButton exitButton;
    private JLabel title;
    private JLabel courseNameLabel;
    private JTextField courseNameTextField;
    private JButton searchButton;
    private JButton searchMenuButton;
    private JLabel searchCompleted;

    //Object Declarations
    private Welcome welcome;
    private Timetable timetable;
    private SearchMenu searchMenu;
    private UserMenu userMenu;
    private SignIn signIn;

    public CourseSearch(Timetable t) {
        super();
        timetable = t;
        c = this.getContentPane();
        setTitle("Computer Lab Schedule");
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        createCourseSearchScreen();
    }

    public void createCourseSearchScreen() {
        signIn = new SignIn();
        userMenu = new UserMenu(signIn);
        timetable = new Timetable(userMenu);

        //Title
        title = new JLabel("Searching For A Course");
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setBounds(50, 40, 500, 50);
        c.add(title);

        //Searching JLabel
        courseNameLabel = new JLabel("Please Enter A Course Code");
        courseNameLabel.setBounds(50, 120, 180, 25);
        courseNameLabel.setForeground(Color.CYAN);
        c.add(courseNameLabel);

        //Courses Name Text Field
        courseNameTextField = new JTextField(30);
        courseNameTextField.setBounds(250, 120, 260, 25);
        c.add(courseNameTextField);

        //Teacher Found In Computer Lab Schedule
        searchCompleted = new JLabel();
        searchCompleted.setBounds(50, 175, 800, 25);
        searchCompleted.setVisible(false);
        c.add(searchCompleted);

        //Search Button
        searchButton = new JButton("Search For Course");
        searchButton.setBounds(50, 225, 200, 25);
        searchButton.setBackground(Color.ORANGE);
        searchButton.addActionListener(this);
        c.add(searchButton);

        //Return To Search Menu Button
        searchMenuButton = new JButton("Return To Search Menu");
        searchMenuButton.setBounds(300, 225, 200, 25);
        searchMenuButton.setBackground(Color.ORANGE);
        searchMenuButton.addActionListener(this);
        c.add(searchMenuButton);

        //Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(550, 225, 200, 25);
        exitButton.setBackground(Color.ORANGE);
        exitButton.addActionListener(this);
        c.add(exitButton);

    }

   @Override
    public void actionPerformed(ActionEvent evt) {
        //If exit button is pressed
        if (evt.getSource() == exitButton) {
            System.exit(0);
        }

        //If the search button is pressed
        if (evt.getSource() == searchButton) {
            CourseLinkedList period1CourseLinkedList = linkedListOfSortedCourses(timetable.getLinkedListOfPeriod1Courses());
            CourseLinkedList period2CourseLinkedList = linkedListOfSortedCourses(timetable.getLinkedListOfPeriod2Courses());
            CourseLinkedList period3CourseLinkedList = linkedListOfSortedCourses(timetable.getLinkedListOfPeriod3Courses());
            CourseLinkedList period4CourseLinledList = linkedListOfSortedCourses(timetable.getLinkedListOfPeriod4Courses());

            CourseLinkedList period1And2CoursesLinkedList = mergeLinkedLists(period1CourseLinkedList, period2CourseLinkedList);
            CourseLinkedList period3And4CoursesLinkedList = mergeLinkedLists(period3CourseLinkedList, period4CourseLinledList);
            CourseLinkedList allCourses = mergeLinkedLists(period1And2CoursesLinkedList, period3And4CoursesLinkedList);

            String course = courseNameTextField.getText();
            int courseIndex = searchCourse(allCourses, course, -1, allCourses.size());

            if (courseIndex != -1) {
                searchCompleted.setText("This Course is Found! The Course is taught by "
                        + allCourses.get(courseIndex).getTeachersName() + " on "
                        + allCourses.get(courseIndex).getDayOfWeek()
                        + " during period " + allCourses.get(courseIndex).getPeriod()
                        + " in the computer lab");
                searchCompleted.setForeground(Color.GREEN);
                searchCompleted.setVisible(true);
            } else if (courseIndex == -1) {
                searchCompleted.setText("This Course is not Found");
                searchCompleted.setForeground(Color.GREEN);
                searchCompleted.setVisible(true);
            }
        }

        //If the search menu button is pressed
        if (evt.getSource() == searchMenuButton) {
            dispose();
            c.removeAll();
            repaint();
            searchMenu = new SearchMenu(timetable);
            searchMenu.setVisible(true);
            searchMenu.pack();
            searchMenu.setSize(welcome.WINDOWWIDTH, welcome.WINDOWHEIGHT);
            searchMenu.setLocationRelativeTo(null);
            searchMenu.setResizable(false);
            searchMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }

    /*
    *@param An linkedlist of courses
    *@return A sorted linkedlist of courses by name
     */
    public CourseLinkedList linkedListOfSortedCourses(CourseLinkedList linkedListOfCourses) {
        String tempCourse;
        String tempTeachersName;
        String tempDayOfWeek;
        String tempPeriod;
        for (int i = 0; i < linkedListOfCourses.size(); i++) {
            for (int j = i + 1; j < linkedListOfCourses.size(); j++) {
                if (linkedListOfCourses.get(i).getCourse().compareToIgnoreCase(linkedListOfCourses.get(j).getCourse()) > 0) {
                    tempCourse = linkedListOfCourses.get(i).getCourse();
                    linkedListOfCourses.get(i).setCourse(linkedListOfCourses.get(j).getCourse());
                    linkedListOfCourses.get(j).setCourse(tempCourse);

                    tempTeachersName = linkedListOfCourses.get(i).getTeachersName();
                    linkedListOfCourses.get(i).setTeachersName(linkedListOfCourses.get(j).getTeachersName());
                    linkedListOfCourses.get(j).setTeachersName(tempTeachersName);

                    tempDayOfWeek = linkedListOfCourses.get(i).getDayOfWeek();
                    linkedListOfCourses.get(i).setDayOfWeek(linkedListOfCourses.get(j).getDayOfWeek());
                    linkedListOfCourses.get(j).setDayOfWeek(tempDayOfWeek);

                    tempPeriod = linkedListOfCourses.get(i).getPeriod();
                    linkedListOfCourses.get(i).setPeriod(linkedListOfCourses.get(j).getPeriod());
                    linkedListOfCourses.get(j).setPeriod(tempPeriod);
                }
            }
        }
        return linkedListOfCourses;
    }

    /*
    *@param A linkedlists of coutses
    *@param A target String, which is the course code in this case
    *@param The left boundary
    *@param The right boundary
    *@return The index of the course if it is present in the linkedlist
    *@return -1 if the course is not present in the linkedlist
     */
    public int searchCourse(CourseLinkedList arrayListOfCourses, String target, int left, int right) {
        try {
            if (left < right) {
                int middle = (left + (right - 1)) / 2;
                if (target.equalsIgnoreCase(arrayListOfCourses.get(middle).getCourse())) {
                    return middle;
                }
                if (target.compareToIgnoreCase(arrayListOfCourses.get(middle).getCourse()) < 0) {
                    return searchCourse(arrayListOfCourses, target, left, middle - 1);
                }
                if (target.compareToIgnoreCase(arrayListOfCourses.get(middle).getCourse()) > 0) {
                    return searchCourse(arrayListOfCourses, target, middle + 1, right);
                }
            }
        }
        catch (NullPointerException np) {
            np.getMessage();
        }
        return -1;
    }

    /*
    *@param The first sorted linkedlist of courses
    *@param The second sorted linkedlist of courses
    *@return A merged linkedlists of courses that is also sorted
     */
    public CourseLinkedList mergeLinkedLists(CourseLinkedList linkedList1, CourseLinkedList linkedList2) {
        int array1Length = linkedList1.size();
        int array2Length = linkedList2.size();
        CourseLinkedList merge = new CourseLinkedList();
        int position1 = 0;
        int position2 = 0;
        while (position1 < array1Length && position2 < array2Length) {
            if (linkedList1.get(position1).getCourse().compareToIgnoreCase(linkedList2.get(position2).getCourse()) < 0) {
                merge.add(linkedList1.get(position1++));
            } else {
                merge.add(linkedList2.get(position2++));
            }
        }

        while (position1 < array1Length) {
            merge.add(linkedList1.get(position1++));
        }

        while (position2 < array2Length) {
            merge.add(linkedList2.get(position2++));
        }
        return merge;
    }

}

