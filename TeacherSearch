import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Kevin
 */
public class TeacherSearch extends JFrame implements ActionListener {

    //Container
    private Container c;

    //JLabels, JButtons and JTextField
    private JButton exitButton;
    private JLabel title;
    private JLabel teachersNameLabel;
    private JTextField teachersNameTextField;
    private JButton searchButton;
    private JButton searchMenuButton;
    private JLabel searchCompleted;

    //Objects
    private Welcome welcome;
    private Timetable timetable;
    private SearchMenu searchMenu;
    private SignIn signIn;
    private UserMenu userMenu;

    public TeacherSearch(Timetable t) {
        super();
        c = this.getContentPane();
        setTitle("Computer Lab Schedule");
        c.setLayout(null);
        c.setBackground(Color.BLACK);
        timetable = t;
        createTeacherSearchScreen();
    }

    public void createTeacherSearchScreen() {
        signIn = new SignIn();
        userMenu = new UserMenu(signIn);
        timetable = new Timetable(userMenu);
        //Title
        title = new JLabel("Searching For A Teacher");
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setBounds(50, 40, 500, 50);
        c.add(title);

        //Searching JLabel
        teachersNameLabel = new JLabel("Please Enter A Teacher's Name");
        teachersNameLabel.setBounds(50, 120, 180, 25);
        teachersNameLabel.setForeground(Color.CYAN);
        c.add(teachersNameLabel);

        //Teachers Name Text Field
        teachersNameTextField = new JTextField(30);
        teachersNameTextField.setBounds(250, 120, 260, 25);
        c.add(teachersNameTextField);

        //Teacher Found In Computer Lab Schedule
        searchCompleted = new JLabel();
        searchCompleted.setBounds(50, 175, 800, 25);
        searchCompleted.setVisible(false);
        c.add(searchCompleted);

        //Search Button
        searchButton = new JButton("Search For Teacher");
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

        if (evt.getSource() == exitButton) {
            System.exit(0);
        }

        if (evt.getSource() == searchButton) {

            TeacherLinkedList period1TeacherLinkedList = linkedlistOfSortedTeachers(timetable.getLinkedListOfPeriod1Teachers());
            TeacherLinkedList period2TeacherLinkedList = linkedlistOfSortedTeachers(timetable.getLinkedListOfPeriod2Teachers());
            TeacherLinkedList period3TeacherLinkedList = linkedlistOfSortedTeachers(timetable.getLinkedListOfPeriod3Teachers());
            TeacherLinkedList period4TeacherLinkedList = linkedlistOfSortedTeachers(timetable.getLinkedListOfPeriod4Teachers());

            TeacherLinkedList period1And2TeachersLinkedList = mergeLinkedLists(period1TeacherLinkedList, period2TeacherLinkedList);
            TeacherLinkedList period3And4TeachersLinkedList = mergeLinkedLists(period3TeacherLinkedList, period4TeacherLinkedList);
            TeacherLinkedList allTeachers = mergeLinkedLists(period1And2TeachersLinkedList, period3And4TeachersLinkedList);
            String name = teachersNameTextField.getText();
            int teacherIndex = searchTeacher(allTeachers, name, -1, allTeachers.size());
            if (teacherIndex != -1) {
                searchCompleted.setText("This Teacher is Found! The teacher teaches "
                        + allTeachers.get(teacherIndex).getCourse() + " on "
                        + allTeachers.get(teacherIndex).getDayOfWeek()
                        + " during period " + allTeachers.get(teacherIndex).getPeriod()
                        + " in the computer lab");
                searchCompleted.setForeground(Color.GREEN);
                searchCompleted.setVisible(true);
            } else if (teacherIndex == -1) {
                searchCompleted.setText("This Teacher is not Found");
                searchCompleted.setForeground(Color.GREEN);
                searchCompleted.setVisible(true);
            }
        }

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
    *@param A linkedlist of teachers
    *@return A sorted linkedlist of teachers by name
     */
    public TeacherLinkedList linkedlistOfSortedTeachers(TeacherLinkedList linkedListOfTeachers) {
        String tempName;
        String tempCourse;
        String tempDayOfWeek;
        String tempPeriod;
        for (int i = 0; i < linkedListOfTeachers.size(); i++) {
            for (int j = i + 1; j < linkedListOfTeachers.size(); j++) {
                if (linkedListOfTeachers.get(i).getName().compareToIgnoreCase(linkedListOfTeachers.get(j).getName()) > 0) {
                    tempName = linkedListOfTeachers.get(i).getName();
                    linkedListOfTeachers.get(i).setName(linkedListOfTeachers.get(j).getName());
                    linkedListOfTeachers.get(j).setName(tempName);

                    tempCourse = linkedListOfTeachers.get(i).getCourse();
                    linkedListOfTeachers.get(i).setCourse(linkedListOfTeachers.get(j).getCourse());
                    linkedListOfTeachers.get(j).setCourse(tempCourse);

                    tempDayOfWeek = linkedListOfTeachers.get(i).getDayOfWeek();
                    linkedListOfTeachers.get(i).setDayOfWeek(linkedListOfTeachers.get(j).getDayOfWeek());
                    linkedListOfTeachers.get(j).setDayOfWeek(tempDayOfWeek);

                    tempPeriod = linkedListOfTeachers.get(i).getPeriod();
                    linkedListOfTeachers.get(i).setPeriod(linkedListOfTeachers.get(j).getPeriod());
                    linkedListOfTeachers.get(j).setPeriod(tempPeriod);
                }
            }
        }
        return linkedListOfTeachers;
    }

    /*
    *@param A linkedlists of teachers
    *@param A target String, which is the teacher's name in this case
    *@param The left boundary
    *@param The right boundary
    *@return The index of the teacher if the he or she is present in the linkedlist
    *@return -1 if the teacher is not present in the linkedlist
     */
    public int searchTeacher(TeacherLinkedList linkedListOfTeachers, String target, int left, int right) {
        try {
            if (left < right) {
                int middle = (left + (right - 1)) / 2;
                if (target.equalsIgnoreCase(linkedListOfTeachers.get(middle).getName())) {
                    return middle;
                }
                if (target.compareToIgnoreCase(linkedListOfTeachers.get(middle).getName()) < 0) {
                    return searchTeacher(linkedListOfTeachers, target, left, middle - 1);
                }
                if (target.compareToIgnoreCase(linkedListOfTeachers.get(middle).getName()) > 0) {
                    return searchTeacher(linkedListOfTeachers, target, middle + 1, right);
                }
            }
        }
        catch (NullPointerException np) {
            np.getMessage();
        }
        return -1;
    }

    /*
    *@param The first sorted linkedlist of teachers
    *@param The second sorted linkedlist of teachers
    *@return A merged linkedlists of teachers that is also sorted
     */
    public TeacherLinkedList mergeLinkedLists(TeacherLinkedList linkedList1, TeacherLinkedList linkedList2) {
        int linked1Length = linkedList1.size();
        int linked2Length = linkedList2.size();
        TeacherLinkedList merge = new TeacherLinkedList();
        int position1 = 0;
        int position2 = 0;
        while (position1 < linked1Length && position2 < linked2Length) {
            if (linkedList1.get(position1).getName().compareToIgnoreCase(linkedList2.get(position2).getName()) < 0) {
                merge.add(linkedList1.get(position1++));
            } else {
                merge.add(linkedList2.get(position2++));
            }
        }

        while (position1 < linked1Length) {
            merge.add(linkedList1.get(position1++));
        }

        while (position2 < linked2Length) {
            merge.add(linkedList2.get(position2++));
        }
        return merge;
    }
}

