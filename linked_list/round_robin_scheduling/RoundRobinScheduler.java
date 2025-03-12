package linked_list.round_robin_scheduling;

public class RoundRobinScheduler {
    private java.lang.Process head;
    private java.lang.Process current;
    private int timeQuantum;

    // Constructor
    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Check if the scheduler is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Add a process at the end of the circular list
    public void addProcess(java.lang.Process process) {
        if (isEmpty()) {
            head = process;
            head.next = head; // circular link
            current = head;
        } else {
            java.lang.Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = process;
            process.next = head;   // circular linking
        }
    }

    // Remove a process by Process ID
    public void removeProcessById(int processId) {
        if (isEmpty()) {
            System.out.println("No processes to remove.");
            return;
        }
        java.lang.Process temp = head;
        java.lang.Process prev = null;
        do {
            if (temp.processId == processId) {
                if (temp == head) {
                    if (head.next == head) {
                        head = null;
                    } else {
                        java.lang.Process lastNode = head;
                        while (lastNode.next != head) {
                            lastNode = lastNode.next;
                        }
                        head = head.next;
                        lastNode.next = head;
                    }
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Process with ID " + processId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate round-robin scheduling
    public void simulateScheduling() {
        if (isEmpty()) {
            System.out.println("No processes to schedule.");
            return;
        }
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int totalProcesses = 0;

        System.out.println("Starting Round Robin Scheduling with Time Quanta: " + timeQuantum);
        while (!isEmpty()) {
            java.lang.Process currentProcess = current;
            System.out.println("Executing: " + currentProcess);

            // Execute the process for the time quantum or its remaining burst time
            int executionTime = Math.min(timeQuantum, currentProcess.burstTime);
            currentProcess.burstTime -= executionTime;

            // Calculate waiting time and turn-around time
            totalWaitingTime += (totalTurnAroundTime - currentProcess.priority); // Simplified waiting time calculation
            totalTurnAroundTime += executionTime;
            totalProcesses++;

            // Display the updated list of processes
            System.out.println("Updated Process List:");
            displayProcesses();

            // Remove the process if it has completed execution
            if (currentProcess.burstTime == 0) {
                removeProcessById(currentProcess.processId);
            }

            // Move to the next process
            current = current.next;
        }

        // Calculate and display average waiting time and turn-around time
        double averageWaitingTime = (double) totalWaitingTime / totalProcesses;
        double averageTurnAroundTime = (double) totalTurnAroundTime / totalProcesses;
        System.out.println("\nAverage Waiting Time: " + averageWaitingTime);
        System.out.println("Average Turn-Around Time: " + averageTurnAroundTime);
    }

    // Display all processes in the circular list
    public void displayProcesses() {
        if (isEmpty()) {
            System.out.println("No processes in the scheduler.");
            return;
        }
        java.lang.Process temp = head;
        do {
            System.out.println(temp);
            temp = temp.next;
        } while (temp != head);
    }
}