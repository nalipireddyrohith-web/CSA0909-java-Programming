class ParkingTicket {
    static int nextTicketNo = 1001;
    static int totalTickets = 0;

    int ticketNo;
    String regNo;
    boolean active;

    ParkingTicket(String regNo) {
        this.ticketNo = nextTicketNo++;
        this.regNo = regNo;
        this.active = true;
        totalTickets++;
    }

    static void displayTotalTickets() {
        System.out.println("Total Tickets: " + totalTickets);
    }

    void releaseTicket() {
        if (active) {
            active = false;
            totalTickets--;
            System.out.println("Ticket Released: " + ticketNo);
        }
    }

    void display() {
        System.out.println("Ticket Number: " + ticketNo);
        System.out.println("Registration Number: " + regNo);
        System.out.println("Active: " + active);
    }
}

class ParkingFacility {
    static String facilityName = "Campus Parking";
    static int totalFacilities = 0;

    ParkingFacility() {
        totalFacilities++;
    }

    static void displayFacility() {
        System.out.println("Facility Name: " + facilityName);
        System.out.println("Total Facilities: " + totalFacilities);
    }

    ParkingTicket createTicket(String regNo) {
        return new ParkingTicket(regNo);
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingFacility north = new ParkingFacility();
        ParkingFacility south = new ParkingFacility();

        ParkingFacility.displayFacility();

        ParkingTicket t1 = north.createTicket("TN01AB1111");
        ParkingTicket t2 = south.createTicket("TN02CD2222");

        t1.display();
        t2.display();

        ParkingTicket.displayTotalTickets();

        t1.releaseTicket();

        ParkingTicket.displayTotalTickets();

        t2.releaseTicket();

        ParkingTicket.displayTotalTickets();
    }
}
