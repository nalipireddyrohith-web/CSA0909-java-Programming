class Ticket {
    private static int nextNumber = 1;
    private final int number;
    private final String regNo;

    Ticket(String regNo) {
        this.number = nextNumber++;
        this.regNo = regNo;
    }

    int getNumber() { return number; }

    @Override
    public String toString() { return "Ticket " + number + " for " + regNo; }
}

public class StaticLifecycleDemo {
    public static void main(String[] args) {
        Ticket north = new Ticket("TN01AB1111");
        Ticket south = new Ticket("TN02CD2222");
        System.out.println(north);
        System.out.println(south);
        north = null;
        System.out.println("Ticket object is eligible for garbage collection if no other references exist.");
    }
}
