package linked_list.social_media;

import java.util.ArrayList;

public class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    User next;

    // Constructor
    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Age: " + age + ", Friends: " + friendIds;
    }
}
