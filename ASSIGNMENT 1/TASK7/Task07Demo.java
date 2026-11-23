class BaseVehicle {
    protected String regNo;
    BaseVehicle(String regNo) { this.regNo = regNo; }
    double calculateFee(int hours) { return hours * 20.0; }
    public String toString() { return "BaseVehicle(" + regNo + ")"; }
    public boolean equals(Object o) { return o instanceof BaseVehicle && regNo.equals(((BaseVehicle)o).regNo); }
    public int hashCode() { return regNo.hashCode(); }
}
class SpecialCar extends BaseVehicle {
    SpecialCar(String regNo) { super(regNo); }
    @Override double calculateFee(int hours) { return hours * 30.0; }
}
public class Task07Demo {
    public static void main(String[] args) {
        BaseVehicle v = new SpecialCar("TN02B2");
        System.out.println("Overridden fee: Rs " + v.calculateFee(3));
        System.out.println("Final variables prevent reassignment; final methods prevent overriding.");
        System.out.println("Equal registration objects: " + new BaseVehicle("TN01").equals(new BaseVehicle("TN01")));
    }
}
