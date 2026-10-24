public class DataRepresentationDemo {
    public static void main(String[] args) {
        int[] slotsPerFloor = {20, 50, 35};
        String[][] slots = new String[slotsPerFloor.length][];
        for (int f = 0; f < slotsPerFloor.length; f++) {
            slots[f] = new String[slotsPerFloor[f]];
        }

        int minutes = 61;
        double hourlyRate = 30.0;
        int wrongHours = minutes / 60;
        double wrongFee = wrongHours * hourlyRate;
        int billableHours = (minutes + 59) / 60;
        double correctFee = billableHours * hourlyRate;

        System.out.println("Floors: " + slots.length);
        System.out.println("Slots on floor 2: " + slots[2].length);
        System.out.println("Wrong fee using minutes / 60: Rs " + wrongFee);
        System.out.println("Correct fee using ceiling integer arithmetic: Rs " + correctFee);
    }
}
