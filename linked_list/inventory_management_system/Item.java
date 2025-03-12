package linked_list.inventory_management_system;

public class Item {
    String itemName;
    int id;
    int quantity;
    float price;
    Item next;

    public Item(String itemName, int id, int quantity, float price) {
        this.itemName = itemName;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }
}
class LinkedList{
    private Item head;
    LinkedList(){
        this.head = null;
    }
    public void append(String itemName, int id, int quantity, float price){
        Item newNode = new Item(itemName, id, quantity, price);
        if(head == null){
            head = newNode;
        }
        else{
            Item current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            newNode.next = null;
        }
    }
    public  void prepend(String itemName, int id, int quantity, float price){
        Item newNode = new Item(itemName, id, quantity, price);
        newNode.next = head;
        head = newNode;
    }
    public void add(String itemName, int id, int quantity, float price, int index) {
        Item newNode = new Item(itemName, id, quantity, price);
        if(head == null){
            return;
        }
        else{
            Item current = head;
            int cnt = 1;

            while(current.next != null && cnt != index){
                current = current.next;
                cnt++;
            }
            if(cnt == index) {
                Item temp = current.next;
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
        if(head.id == id){
            head = head.next;
            return;
        }
        else{
            Item current = head;
            while (current != null && current.next.id != id){
                current = current.next;
            }
            if(current != null) {
                current.next = current.next.next;
            }
        }
    }

    public Item search(int id){
        if(head == null){
            return null;
        }
        if(head.rollNumber == id){
            return head;
        }
        else{
            Item current = head;
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
            Item current = head;
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
            Item current = head;
            while(current!= null && current.rollNumber != id){
                current = current.next;
            }
            if(current != null){
                current.grade = grade;
            }
        }
    }

}
