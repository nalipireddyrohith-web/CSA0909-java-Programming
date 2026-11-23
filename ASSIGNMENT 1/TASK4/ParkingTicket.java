import java.time.LocalDateTime;

public class ParkingTicket {
    private static int nextTicket = 1001;
    private final int ticketNo;
    private final String regNo;
    private final LocalDateTime entryTime;
    private int floor;
    private int slot;

    public ParkingTicket(String regNo) { this(regNo, LocalDateTime.now(), -1, -1); }
    public ParkingTicket(String regNo, LocalDateTime entryTime, int floor, int slot) {
        this.ticketNo = nextTicket++;
        this.regNo = regNo;
        this.entryTime = entryTime;
        this.floor = floor;
        this.slot = slot;
    }
    public ParkingTicket(ParkingTicket other) {
        this(other.regNo, other.entryTime, other.floor, other.slot);
    }
    public int getTicketNo() { return ticketNo; }
    public void setSlot(int floor, int slot) { this.floor = floor; this.slot = slot; }
    public String toString() { return "Ticket " + ticketNo + " " + regNo + " floor=" + floor + " slot=" + slot; }
}
