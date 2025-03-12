package linked_list.movie_management_system;

public class Movie {
    String title;
    String director;
    int yearOfRelease;
    float rating;

    Movie next;

    Movie prev;

    public Movie(String title, String director, int yearOfRelease, float rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
class LinkedList{
    private Movie head;
    LinkedList(){
        this.head = null;
    }
    public void append(String title, String director, int yearOfRelease, float rating){
        Movie newNode = new Movie(title, director, yearOfRelease, rating);
        if(head == null){
            head = newNode;
        }
        else{
            Movie current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
            newNode.next = null;
        }
    }
    public  void prepend(String title, String director, int yearOfRelease, float rating){
        Movie newNode = new Movie(title, director, yearOfRelease, rating);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    public void add(String title, String director, int yearOfRelease, float rating, int index) {
        Movie newNode = new Movie(title, director, yearOfRelease, rating);
        if(head == null){
            return;
        }
        else{
            Movie current = head;
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
    public void delete(String title){
        if(head == null){
            return;
        }
        if(head.title.equals(title)){
            head = head.next;
            head.prev = null;
            return;
        }
        else{
            Movie current = head;
            while (current != null && !current.next.title.equals(title)){
                current = current.next;
            }
            if(current != null) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
        }
    }

    public Movie search(String director){
        if(head == null){
            return null;
        }
        if(head.director.equals(director)){
            return head;
        }
        else{
            Movie current = head;
            while (current!= null && !current.director.equals(director)){
                current = current.next;
            }
            return current;
        }
    }

    public Movie search(float rating){
        if(head == null){
            return null;
        }
        if(head.rating == rating){
            return head;
        }
        else{
            Movie current = head;
            while (current!= null && current.rating == rating){
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
            Movie current = head;
            while(current != null){
                System.out.println("Title: " + current.title + " Director: " + current.director + " Year of Release: " + current.yearOfRelease + " Rating: " + current.rating);
                current = current.next;
            }
        }
    }
    public void updateGrade(String title, float rating){
        if(head == null){
            return;
        }
        if(!head.title.equals(title)){
            head.rating = rating;
        }
        else{
            Movie current = head;
            while(current!= null && !current.title.equals(title)){
                current = current.next;
            }
            if(current != null){
                current.rating = rating;
            }
        }
    }



}