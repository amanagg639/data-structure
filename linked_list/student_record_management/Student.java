package linked_list.student_record_management;

public class Student {
    int rollNumber;
    String name;
    int age;
    String grade;

    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }

}
class LinkedList{
    private Student head;
    LinkedList(){
        this.head = null;
    }
    public void append(int rollNumber, String name, int age, String grade){
        Student newNode = new Student(rollNumber, name, age, grade);
        if(head == null){
            head = newNode;
        }
        else{
            Student current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            newNode.next = null;
        }
    }
    public  void prepend(int rollNumber, String name, int age, String grade){
        Student newNode = new Student(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }
    public void add(int rollNumber, String name, int age, String grade, int index) {
        Student newNode = new Student(rollNumber, name, age, grade);
        if(head == null){
            return;
        }
        else{
            Student current = head;
            int cnt = 1;

            while(current.next != null && cnt != index){
                current = current.next;
                cnt++;
            }
            if(cnt == index) {
                Student temp = current.next;
                current.next = newNode;
                newNode.next = temp;
            }
            else return;
        }
    }
    public void delete(int id){
        if(head == null){
            return;
        }
        if(head.rollNumber == id){
            head = head.next;
            return;
        }
        else{
            Student current = head;
            while (current != null && current.next.rollNumber != id){
                current = current.next;
            }
            if(current != null) {
                current.next = current.next.next;
            }
        }
    }

    public Student search(int id){
        if(head == null){
            return null;
        }
        if(head.rollNumber == id){
            return head;
        }
        else{
            Student current = head;
            while (current!= null && current.rollNumber != id){
                current = current.next;
            }
            return current;
        }
    }
    public void display(){
        if(head == null){
            return;
        }
        else{
            Student current = head;
            while(current != null){
                System.out.println("roll number: " + current.rollNumber + " name: " + current.name + " age: " + current.age + " grade: " + current.grade);
                current = current.next;
            }
        }
    }
    public void updateGrade(int id, String grade){
        if(head == null){
            return;
        }
        if(head.rollNumber == id){
            head.grade = grade;
        }
        else{
            Student current = head;
            while(current!= null && current.rollNumber != id){
                current = current.next;
            }
            if(current != null){
                current.grade = grade;
            }
        }
    }

}
