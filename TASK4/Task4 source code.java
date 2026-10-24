class ParkingTicket {
    private final int ticketNo;
    private final String regNo;
    private final long entryTime;

    ParkingTicket() {
        this(0, "UNKNOWN", System.currentTimeMillis());
    }

    ParkingTicket(int ticketNo, String regNo) {
        this(ticketNo, regNo, System.currentTimeMillis());
    }

    ParkingTicket(int ticketNo, String regNo, long entryTime) {
        if (ticketNo < 0 || regNo == null || regNo.isBlank()) {
            throw new IllegalArgumentException("Invalid ticket data");
        }
        this.ticketNo = ticketNo;
        this.regNo = regNo;
        this.entryTime = entryTime;
    }

    ParkingTicket(ParkingTicket other) {
        this(other.ticketNo, other.regNo, other.entryTime);
    }

    @Override
    public String toString() {
        return "Ticket " + ticketNo + ", vehicle=" + regNo + ", entry=" + entryTime;
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        ParkingTicket t1 = new ParkingTicket(101, "TN01AB1111");
        ParkingTicket t2 = new ParkingTicket(t1);
        System.out.println(t1);
        System.out.println(t2);
    }
}
