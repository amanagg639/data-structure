package linked_list.online_ticket_reservation;

public class Main {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Adding tickets
        system.addTicket(new Ticket(1, "Alice", "Inception", 5, "10:00 AM"));
        system.addTicket(new Ticket(2, "Bob", "Interstellar", 10, "12:30 PM"));
        system.addTicket(new Ticket(3, "Charlie", "Inception", 15, "3:00 PM"));

        // Display all tickets
        System.out.println("All Tickets:");
        system.displayTickets();

        // Search for a ticket by customer name
        System.out.println("\nSearching for tickets by customer name 'Alice':");
        system.searchByCustomerName("Alice");

        // Search for a ticket by movie name
        System.out.println("\nSearching for tickets by movie name 'Inception':");
        system.searchByMovieName("Inception");

        // Remove a ticket by ID
        System.out.println("\nRemoving ticket with ID 2:");
        system.removeTicketById(2);
        System.out.println("\nUpdated Tickets:");
        system.displayTickets();

        // Count the total number of booked tickets
        System.out.println("\nTotal number of booked tickets: " + system.countTickets());
    }
}

