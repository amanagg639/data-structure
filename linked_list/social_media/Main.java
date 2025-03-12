package linked_list.social_media;

public class Main {
    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();

        // Adding users
        socialMedia.addUser(new User(1, "Alice", 25));
        socialMedia.addUser(new User(2, "Bob", 30));
        socialMedia.addUser(new User(3, "Charlie", 22));
        socialMedia.addUser(new User(4, "David", 28));

        // Display all users
        System.out.println("All Users:");
        socialMedia.displayAllUsers();

        // Add friend connections
        socialMedia.addFriendConnection(1, 2);
        socialMedia.addFriendConnection(1, 3);
        socialMedia.addFriendConnection(2, 4);
        socialMedia.addFriendConnection(3, 4);

        // Display friends of a specific user
        System.out.println("\nFriends of User 1:");
        socialMedia.displayFriends(1);

        // Find mutual friends
        System.out.println("\nMutual friends between User 1 and User 4:");
        socialMedia.findMutualFriends(1, 4);

        // Remove a friend connection
        System.out.println("\nRemoving friend connection between User 1 and User 3:");
        socialMedia.removeFriendConnection(1, 3);
        socialMedia.displayFriends(1);

        // Search for a user by name
        System.out.println("\nSearching for user by name 'Bob':");
        socialMedia.searchByName("Bob");

        // Search for a user by ID
        System.out.println("\nSearching for user by ID 4:");
        socialMedia.searchById(4);

        // Count the number of friends for each user
        System.out.println("\nNumber of friends for each user:");
        socialMedia.countFriends();
    }
}