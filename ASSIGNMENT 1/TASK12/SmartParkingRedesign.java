import java.time.*;

interface Pass { boolean valid(LocalDate date); }
class OneDayPass implements Pass {
    private final LocalDate date;
    OneDayPass(LocalDate date) { this.date=date; }
    public boolean valid(LocalDate today) { return date.equals(today); }
}
abstract class NewVehicle {
    final String regNo;
    NewVehicle(String regNo){this.regNo=regNo;}
    abstract double fee(int minutes, LocalTime time);
}
class NewCar extends NewVehicle {
    NewCar(String r){super(r);}
    double fee(int minutes, LocalTime time){return ((minutes+59)/60)*30.0;}
}
class EBike extends NewVehicle {
    EBike(String r){super(r);}
    double fee(int minutes, LocalTime time){return 25.0;}
}
class DeliveryVan extends NewVehicle {
    DeliveryVan(String r){super(r);}
    double fee(int minutes, LocalTime time){
        double base=((minutes+59)/60)*30.0;
        if(!time.isBefore(LocalTime.of(9,0)) && time.isBefore(LocalTime.of(17,0))) return base*2;
        return base;
    }
}
public class SmartParkingRedesign {
    public static void main(String[] args) {
        int[] floors={20,35,40,25,50};
        System.out.println("Floors: " + floors.length + ", unequal slots supported: " + (floors[0]!=floors[1]));
        System.out.println("E-bike fee: Rs " + new EBike("EB01").fee(10,LocalTime.of(10,0)));
        System.out.println("Van fee 10AM for 2h: Rs " + new DeliveryVan("DV01").fee(120,LocalTime.of(10,0)));
        System.out.println("Van fee 6PM for 2h: Rs " + new DeliveryVan("DV02").fee(120,LocalTime.of(18,0)));
        Pass p=new OneDayPass(LocalDate.now());
        System.out.println("One-day pass valid today: " + p.valid(LocalDate.now()));
        System.out.println("Decision: MODIFY with jagged floors + Pass + vehicle fee abstraction.");
    }
}
