class ScannerStation extends Thread {
    private final int stationId;
    private final int scripts;
    ScannerStation(int stationId, int scripts) { this.stationId = stationId; this.scripts = scripts; }
    public void run() {
        try {
            Thread.sleep(50L * stationId);
            System.out.println("Station " + stationId + " scanned " + scripts + " scripts");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ThreadLifeCycleDemo {
    public static void main(String[] args) throws InterruptedException {
        ScannerStation[] stations = new ScannerStation[4];
        int total = 0;
        for (int i = 0; i < 4; i++) {
            stations[i] = new ScannerStation(i + 1, 100 + i * 25);
            total += 100 + i * 25;
        }
        for (ScannerStation s : stations) {
            System.out.println("Before start, alive=" + s.isAlive());
            s.start();
        }
        for (ScannerStation s : stations) s.join();
        System.out.println("All stations completed.");
        System.out.println("Total scripts scanned: " + total);
    }
}
