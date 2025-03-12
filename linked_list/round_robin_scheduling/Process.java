package linked_list.round_robin_scheduling;

public class Process {
int processId;
int burstTime;
int priority;
Process next;


public Process(int processId, int burstTime, int priority) {
    this.processId = processId;
    this.burstTime = burstTime;
    this.priority = priority;
    this.next = null;
}

@Override
public String toString() {
    return "Process ID: " + processId + ", Burst Time: " + burstTime + ", Priority: " + priority;
}
}