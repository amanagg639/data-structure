package linked_list.task_schedular;

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTaskAtEnd(1, "Task A", 2, "2025-03-15");
        scheduler.addTaskAtEnd(2, "Task B", 1, "2025-03-16");
        scheduler.viewCurrentTask();
    }
}
