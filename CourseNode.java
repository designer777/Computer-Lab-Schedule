/**
 *
 * @author Kevin
 */
public class CourseNode {
    
   //Instance variables
   private Course course;
   private CourseNode next;
   
    //Constructor
    public CourseNode() {
        this(null, null);
    }
    
    //Constructor
    public CourseNode(Course course, CourseNode next) {
        this.course = course;
        this.next = next;
    }
    
    //Constructor
    public CourseNode(Course course) {
        this.course = course;
        this.next = null;
    }

    //Modifier method for the course 
    public void setData(Course course) {
        this.course = course;
    }
    
    //Modifier method for the course node
    public void setNext(CourseNode next) {
        this.next = next;
    }
    
    //Accessor method for the course
    public Course getData() {
        return course;
    }
    
    //Accessor method for the course node
    public CourseNode getNext() {
        return next;
    }

}
