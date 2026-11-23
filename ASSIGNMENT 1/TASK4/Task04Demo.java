public class Task04Demo {
    public static void main(String[] args) {
        ParkingTicket t1 = new ParkingTicket("TN01AB1111");
        t1.setSlot(0, 2);
        ParkingTicket t2 = new ParkingTicket(t1);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println("Objects use reference variables; objects are created on the heap.");
    }
}
