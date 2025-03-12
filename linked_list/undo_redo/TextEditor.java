package linked_list.undo_redo;

public class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState currentState;
    private final int maxHistorySize;
    private int currentHistorySize;

    // Constructor
    public TextEditor(int maxHistorySize) {
        this.maxHistorySize = maxHistorySize;
        this.currentHistorySize = 0;
        this.head = null;
        this.tail = null;
        this.currentState = null;
    }

    // Add a new text state
    public void addState(String content) {
        TextState newState = new TextState(content);

        if (head == null) {
            head = newState;
            tail = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
        }

        currentState = newState;
        currentHistorySize++;

        // Remove the oldest state if history size exceeds the limit
        if (currentHistorySize > maxHistorySize) {
            head = head.next;
            head.prev = null;
            currentHistorySize--;
        }
    }

    // Undo functionality
    public void undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("Nothing to undo.");
            return;
        }
        currentState = currentState.prev;
        System.out.println("Undo successful. Current state: " + currentState);
    }

    // Redo functionality
    public void redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("Nothing to redo.");
            return;
        }
        currentState = currentState.next;
        System.out.println("Redo successful. Current state: " + currentState);
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (currentState == null) {
            System.out.println("No text available.");
        } else {
            System.out.println("Current state: " + currentState);
        }
    }

    // Display the entire history (for debugging purposes)
    public void displayHistory() {
        TextState temp = head;
        System.out.println("History:");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}