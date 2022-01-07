/**
 *
 * @author Kevin
 */
public class TeacherNode {
    
    //Instance variables
    private Teacher teacher;
    private TeacherNode next;

    //Constructor
    public TeacherNode() {
        this(null, null);
    }

    //Constructor
    public TeacherNode(Teacher teacher, TeacherNode next) {
        this.teacher = teacher;
        this.next = next;
    }

    //Constructor
    public TeacherNode(Teacher teacher) {
        this.teacher = teacher;
        this.next = null;
    }

    //Modifier method for the teacher
    public void setData(Teacher teacher) {
        this.teacher = teacher;
    }

    //Modifier method for the teacher node
    public void setNext(TeacherNode next) {
        this.next = next;
    }

    //Accessor method for the teacher
    public Teacher getData() {
        return teacher;
    }

    //Accessor method for the teacher node
    public TeacherNode getNext() {
        return next;
    }

}

