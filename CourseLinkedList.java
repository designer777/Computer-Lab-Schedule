/**
 *
 * @author Kevin
 */
public class CourseLinkedList implements CourseList {

    CourseNode head;
    int size;

    CourseLinkedList() {
        head = null;
        size = 0;
    }

    private CourseNode traverse(int i) {
        CourseNode courseNode = head;

        if (i < 0) {
            return null;
        }

        for (int j = 0; j < i; j++) {
            if (courseNode == null) {
                return null;
            }
            courseNode = courseNode.getNext();
        }
        return courseNode;
    }

    public boolean add(Course course) {
        CourseNode previous;
        CourseNode newCourseNode = new CourseNode(course);

        if (isEmpty()) {
            newCourseNode.setNext(head);

            head = newCourseNode;
        } else {
            previous = traverse(size - 1);
            if (previous == null) {
                return false;
            }
            newCourseNode.setNext(previous.getNext());
            previous.setNext(newCourseNode);
        }
        size++;
        return true;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public Course get(int i) {
        CourseNode courseNode = traverse(i);
        if (courseNode == null) {
            return null;
        }
        return courseNode.getData();
    }
}

