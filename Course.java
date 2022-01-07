/**
 *
 * @author Kevin
 */
public class Course {

    //String Declarations
    private String teachersName;
    private String course;
    private String dayOfWeek;
    private String period;

    //Constructor
    public Course(String course, String teachersName, String dayOfWeek, String period) {
        this.course = course;
        this.teachersName = teachersName;
        this.dayOfWeek = dayOfWeek;
        this.period = period;
    }

    //Accessor method for teacher's name
    public String getTeachersName() {
        return teachersName;
    }
    
    //Accessor method for the course code
    public String getCourse() {
        return course;
    }
    
    //Accessor method for the day of the week
    public String getDayOfWeek() {
        return dayOfWeek;
    }
    
    //Accessor method for the period
    public String getPeriod() {
        return period;
    }
    
    //Modifier method for the teacher's name
    public void setTeachersName(String teachersName) {
        this.teachersName = teachersName;
    }
    
    //Modifier method for the course code
    public void setCourse(String course) {
        this.course = course;
    }
    
    //Modifier method for the day of the week
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    
    //Modifier method for the period
    public void setPeriod(String period) {
        this.period = period;
    }

}

