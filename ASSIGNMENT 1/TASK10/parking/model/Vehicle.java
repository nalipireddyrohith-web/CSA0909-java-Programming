package parking.model;
public class Vehicle {
    private final String regNo;
    private int slot;
    public Vehicle(String regNo) {
        if (regNo == null || regNo.isBlank()) throw new IllegalArgumentException("Registration required");
        this.regNo = regNo;
    }
    public String getRegNo() { return regNo; }
    public int getSlot() { return slot; }
    public void setSlot(int slot) {
        if (slot < 0) throw new IllegalArgumentException("Invalid slot");
        this.slot = slot;
    }
}
