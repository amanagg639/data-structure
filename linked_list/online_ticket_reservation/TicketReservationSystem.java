package linked_list.online_ticket_reservation;

public class TicketReservationSystem {
private Ticket head;
private Ticket tail;

// Check if the list is empty
public boolean isEmpty() {
    return head == null;
}

// Add a new ticket reservation at the end of the circular list
public void addTicket(Ticket ticket) {
    if (isEmpty()) {
        head = ticket;
        tail = ticket;
        tail.next = head; // circular connection
    } else {
        tail.next = ticket;
        ticket.next = head;
        tail = ticket;
    }
}

// Remove a ticket by Ticket ID
public void removeTicketById(int ticketId) {
    if (isEmpty()) {
        System.out.println("No tickets to remove.");
        return;
    }
    Ticket temp = head;
    Ticket prev = tail;

    do {
        if (temp.ticketId == ticketId) {
            if (temp == head) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    tail.next = head;
                }
            } else {
                prev.next = temp.next;
                if (temp == tail) {
                    tail = prev;
                }
            }
            System.out.println("Ticket with ID " + ticketId + " removed.");
            return;
        }
        prev = temp;
        temp = temp.next;
    } while (temp != head);

    System.out.println("Ticket with ID " + ticketId + " not found.");
}

// Display all tickets in the circular list
public void displayTickets() {
    if (isEmpty()) {
        System.out.println("No tickets available.");
        return;
    }
    Ticket temp = head;
    do {
        System.out.println(temp);
        temp = temp.next;
    } while (temp != head);
}

// Search for a ticket by Customer Name
public void searchByCustomerName(String customerName) {
    if (isEmpty()) {
        System.out.println("No tickets available.");
        return;
    }
    Ticket temp = head;
    boolean found = false;
    do {
        if (temp.customerName.equalsIgnoreCase(customerName)) {
            System.out.println("Ticket found: " + temp);
            found = true;
        }
        temp = temp.next;
    } while (temp != head);
    if (!found) {
        System.out.println("No tickets found for customer '" + customerName + "'.");
    }
}

// Search for a ticket by Movie Name
public void searchByMovieName(String movieName) {
    if (isEmpty()) {
        System.out.println("No tickets available.");
        return;
    }
    Ticket temp = head;
    boolean found = false;
    do {
        if (temp.movieName.equalsIgnoreCase(movieName)) {
            System.out.println("Ticket found: " + temp);
            found = true;
        }
        temp = temp.next;
    } while (temp != head);
    if (!found) {
        System.out.println("No tickets found for movie '" + movieName + "'.");
    }
}

// Calculate the total number of booked tickets
public int countTickets() {
    if (isEmpty()) {
        return 0;
    }
    int count = 0;
    Ticket temp = head;
    do {
        count++;
        temp = temp.next;
    } while (temp != head);
    return count;
}
}
