import java.util.*;

public class ParkingSystem {
    static class Ticket {
        String reg; String type; int floor; int slot; int minutes;
        Ticket(String reg, String type, int floor, int slot, int minutes) { this.reg=reg; this.type=type; this.floor=floor; this.slot=slot; this.minutes=minutes; }
    }
    private final String[][] slots;
    private final Map<String, Ticket> active = new HashMap<>();
    private int nextTicket = 1;
    public ParkingSystem(int[] sizes) {
        slots = new String[sizes.length][];
        for (int i=0;i<sizes.length;i++) slots[i]=new String[sizes[i]];
    }
    public Ticket enter(String reg, String type, int minutes) {
        if (active.containsKey(reg)) throw new IllegalArgumentException("Duplicate registration");
        if (!type.equals("TwoWheeler") && !type.equals("Car") && !type.equals("ElectricCar")) throw new IllegalArgumentException("Unknown vehicle type");
        for (int f=0;f<slots.length;f++) for (int s=0;s<slots[f].length;s++) if (slots[f][s]==null) {
            slots[f][s]=reg; Ticket t=new Ticket(reg,type,f,s,minutes); active.put(reg,t); return t;
        }
        return null;
    }
    public double exit(String reg) {
        Ticket t=active.remove(reg); if(t==null) throw new IllegalArgumentException("Ticket not found");
        slots[t.floor][t.slot]=null;
        int hours=(t.minutes+59)/60;
        double rate=t.type.equals("TwoWheeler")?10:t.type.equals("Car")?30:30;
        double fee=hours*rate;
        if(t.type.equals("ElectricCar")) fee+=120;
        return fee;
    }
    public static void main(String[] args) {
        ParkingSystem p=new ParkingSystem(new int[]{1,1});
        Ticket a=p.enter("TN11A1","TwoWheeler",60);
        Ticket b=p.enter("TN11B2","Car",120);
        System.out.println("Entered: " + a.reg + " floor="+a.floor+" slot="+a.slot);
        System.out.println("Entered: " + b.reg + " floor="+b.floor+" slot="+b.slot);
        System.out.println("Car fee: Rs " + p.exit("TN11B2"));
        System.out.println("TwoWheeler fee: Rs " + p.exit("TN11A1"));
        try { p.enter("TN11C3","Bike",10); } catch(Exception e) { System.out.println("Invalid type: " + e.getMessage()); }
        p.enter("TN11D4","Car",0);
        try { p.enter("TN11D4","Car",10); } catch(Exception e) { System.out.println("Duplicate: " + e.getMessage()); }
    }
}
