class FacilityCounter {
    private static int totalOccupancy = 0;
    public static void occupy() { totalOccupancy++; }
    public static void release() { if (totalOccupancy > 0) totalOccupancy--; }
    public static int getOccupancy() { return totalOccupancy; }
}

public class Task05Demo {
    public static void main(String[] args) {
        FacilityCounter.occupy();
        FacilityCounter.occupy();
        System.out.println("Occupancy: " + FacilityCounter.getOccupancy());
        FacilityCounter.release();
        System.out.println("After release: " + FacilityCounter.getOccupancy());
        System.out.println("A departed ticket becomes GC-eligible when no live reference points to it.");
    }
}
