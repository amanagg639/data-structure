package linked_list.student_record_management;

public class Main {
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.append(1, "Aman", 21, "A");
        ls.append(2, "Ram", 19, "A+");
        ls.append(3, "John", 24, "B");
        ls.prepend(4, "rohit", 22, "C");
        ls.add(5, "Priya", 21, "F", 2);
        ls.delete(3);
        ls.updateGrade(5, "A");
        ls.display();
    }
}
