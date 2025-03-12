package linked_list.undo_redo;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(5); // Max history size = 5

        // Adding text states
        editor.addState("Hello");
        editor.addState("Hello, world!");
        editor.addState("Hello, world! How are you?");
        editor.addState("Hello, world! How are you? I'm fine.");
        editor.addState("Hello, world! How are you? I'm fine. Thank you!");

        // Display current state
        editor.displayCurrentState();

        // Perform undo
        editor.undo();
        editor.undo();

        // Perform redo
        editor.redo();

        // Add more states to test history limit
        editor.addState("Hello, world! How are you? I'm fine. Thank you! How about you?");
        editor.addState("Hello, world! How are you? I'm fine. Thank you! How about you? I'm good.");

        // Display current state
        editor.displayCurrentState();

        // Display entire history (for debugging)
        editor.displayHistory();
    }
}