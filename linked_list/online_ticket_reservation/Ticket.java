package linked_list.online_ticket_reservation;

public class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    Ticket next;

    // Constructor
    public Ticket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + ", Customer Name: " + customerName + ", Movie Name: " + movieName +
                ", Seat Number: " + seatNumber + ", Booking Time: " + bookingTime;
    }
}