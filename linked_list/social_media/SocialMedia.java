package linked_list.social_media;

import java.util.ArrayList;

public class SocialMedia {
    private User head;

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Add a new user to the list
    public void addUser(User user) {
        if (isEmpty()) {
            head = user;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = user;
        }
    }

    // Find a user by User ID
    private User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
            user2.friendIds.add(userId1);
            System.out.println("Friend connection added between User " + userId1 + " and User " + userId2 + ".");
        } else {
            System.out.println("Friend connection already exists.");
        }
    }

    // Remove a friend connection between two users
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (user1.friendIds.contains(userId2)) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
            System.out.println("Friend connection removed between User " + userId1 + " and User " + userId2 + ".");
        } else {
            System.out.println("No friend connection exists.");
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        ArrayList<Integer> mutualFriends = new ArrayList<>();
        for (int friendId : user1.friendIds) {
            if (user2.friendIds.contains(friendId)) {
                mutualFriends.add(friendId);
            }
        }
        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends found.");
        } else {
            System.out.println("Mutual friends between User " + userId1 + " and User " + userId2 + ": " + mutualFriends);
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of User " + userId + ": " + user.friendIds);
    }

    // Search for a user by Name
    public void searchByName(String name) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User found: " + temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("User with name '" + name + "' not found.");
        }
    }

    // Search for a user by User ID
    public void searchById(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User with ID " + userId + " not found.");
        } else {
            System.out.println("User found: " + user);
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println("User " + temp.userId + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }

    // Display all users in the list
    public void displayAllUsers() {
        if (isEmpty()) {
            System.out.println("No users in the system.");
            return;
        }
        User temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
