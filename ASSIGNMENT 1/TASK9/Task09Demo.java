interface Payable {
    double payment();
    default String paymentType() { return "Parking payment"; }
    static String currency() { return "INR"; }
}
abstract class AbstractVehicle {
    protected final String regNo;
    AbstractVehicle(String regNo) { this.regNo = regNo; }
    abstract double rate();
}
class PayableCar extends AbstractVehicle implements Payable {
    PayableCar(String regNo) { super(regNo); }
    public double rate() { return 30; }
    public double payment() { return rate(); }
}
public class Task09Demo {
    public static void main(String[] args) {
        PayableCar c = new PayableCar("TN09P9");
        System.out.println("Rate: Rs " + c.rate());
        System.out.println(c.paymentType());
        System.out.println("Currency: " + Payable.currency());
    }
}
