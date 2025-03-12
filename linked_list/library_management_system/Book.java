package linked_list.library_management_system;

public class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
    }
}
class LinkedList{
    private Book head;
    private int cnt;
    LinkedList(){
        this.head = null;
    }
    public void append(String title, String author, String genre, int bookId, boolean availabilityStatus){
        Book newNode = new Book(title, author, genre, bookId, availabilityStatus);
        if(head == null){
            head = newNode;
        }
        else{
            Book current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
            newNode.next = null;
        }
    }
    public  void prepend(String title, String author, String genre, int bookId, boolean availabilityStatus){
        Book newNode = new Book(title, author, genre, bookId, availabilityStatus);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    public void add(String title, String author, String genre, int bookId, boolean availabilityStatus, int index) {
        Book newNode = new Book(title, author, genre, bookId, availabilityStatus);
        if(head == null){
            return;
        }
        else{
            Book current = head;
            int cnt = 0;

            while(current != null && cnt != index){
                current = current.next;
                cnt++;
            }
            if(cnt == index) {
                current.prev.next = newNode;
                newNode.next = current;
                current.prev = newNode;
            }
            else return;
        }
    }
    public void delete(int bookId){
        if(head == null){
            return;
        }
        if(head.bookId == bookId){
            head = head.next;
            head.prev = null;
            return;
        }
        else{
            Book current = head;
            while (current != null && current.next.bookId == bookId){
                current = current.next;
            }
            if(current != null) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
        }
    }

    public Book searchByAuthor(String author){
        if(head == null){
            return null;
        }
        if(head.author.equals(author)){
            return head;
        }
        else{
            Book current = head;
            while (current!= null && !current.author.equals(author)){
                current = current.next;
            }
            return current;
        }
    }

    public Book searchByTitle(String title){
        if(head == null){
            return null;
        }
        if(head.title.equals(title)){
            return head;
        }
        else{
            Book current = head;
            while (current!= null && !current.title.equals(title)){
                current = current.next;
            }
            return current;
        }
    }

    public void displayForward(){
        if(head == null){
            return;
        }
        else{
            Book current = head;
            while(current != null){
                System.out.println("Title: " + current.title + " author: " + current.author + " Genre: " + current.genre + " Book Id: " + current.bookId + "Availability Status: " + current.availabilityStatus);
                current = current.next;
            }
        }
    }

    public void displayReverse(){
        if(head == null){
            return;
        }
        else{
            Book current = head;
            while(current.next != null){
                current = current.next;
            }
            while(current != null){
                System.out.println("Title: " + current.title + " author: " + current.author + " Genre: " + current.genre + " Book Id: " + current.bookId + "Availability Status: " + current.availabilityStatus);
                current = current.prev;
            }
        }
    }

    public void updateStatus(String title, boolean status){
        if(head == null){
            return;
        }
        if(!head.title.equals(title)){
            head.availabilityStatus = status;
        }
        else{
            Book current = head;
            while(current!= null && !current.title.equals(title)){
                current = current.next;
            }
            if(current != null){
                current.availabilityStatus = status;
            }
        }
    }

    public int count(){
        Book current = head;
        while (current != null){
            current = current.next;
            cnt++;
        }
        return cnt;
    }

}
