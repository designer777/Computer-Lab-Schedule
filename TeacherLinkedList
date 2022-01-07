/**
 *
 * @author Kevin
 */
public class TeacherLinkedList implements TeacherList {

    TeacherNode head;
    int size;

    TeacherLinkedList() {
        head = null;
        size = 0;
    }

    private TeacherNode traverse(int i) {
        TeacherNode teacherNode = head;

        if (i < 0) {
            return null;
        }

        for (int j = 0; j < i; j++) {
            if (teacherNode == null) {
                return null;
            }
            teacherNode = teacherNode.getNext();
        }
        return teacherNode;
    }

    public boolean add(Teacher teacher) {
        TeacherNode previous;
        TeacherNode newTeacherNode = new TeacherNode(teacher);

        if (isEmpty()) {
            newTeacherNode.setNext(head);
            head = newTeacherNode;
        } else {
            previous = traverse(size - 1);
            if (previous == null) {
                return false;
            }
            newTeacherNode.setNext(previous.getNext());
            previous.setNext(newTeacherNode);
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

    public Teacher get(int i) {
        TeacherNode teacherNode = traverse(i);
        if (teacherNode == null) {
            return null;
        }
        return teacherNode.getData();
    }
}

