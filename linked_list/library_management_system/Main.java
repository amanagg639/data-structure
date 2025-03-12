package linked_list.library_management_system;

public class Main {
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.append("chamber of secrets", "JK Rowling", "Fantasy", 1, true);
        ls.append("pretty lies", "abc", "Drama", 2, true);
        ls.append("fault in our stars", "def", "romance", 3, true);
        ls.displayReverse();
        System.out.println(ls.searchByAuthor("def").title);
    }
}
