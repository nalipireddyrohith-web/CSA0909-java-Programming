import java.util.*;

public class ListComparison {
    static final int RUNS = 8;

    static double average(Runnable r) {
        for (int i = 0; i < 3; i++) r.run();
        long total = 0;
        for (int i = 0; i < RUNS; i++) {
            long s = System.nanoTime();
            r.run();
            total += System.nanoTime() - s;
        }
        return total / (double) RUNS / 1_000_000.0;
    }

    static ArrayList<Integer> arrayList(int n) {
        ArrayList<Integer> x = new ArrayList<>(n);
        for (int i = 0; i < n; i++) x.add(i);
        return x;
    }

    static LinkedList<Integer> linkedList(int n) {
        LinkedList<Integer> x = new LinkedList<>();
        for (int i = 0; i < n; i++) x.add(i);
        return x;
    }

    static ArrayDeque<Integer> deque(int n) {
        ArrayDeque<Integer> x = new ArrayDeque<>();
        for (int i = 0; i < n; i++) x.addLast(i);
        return x;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};
        System.out.println("Q2 - List and Deque comparison");
        System.out.println("Size | ArrayList addEnd | LinkedList addEnd | ArrayList getMiddle | LinkedList getMiddle | ArrayDeque frontOps");

        for (int n : sizes) {
            double a = average(() -> {
                ArrayList<Integer> x = new ArrayList<>();
                for (int i = 0; i < n; i++) x.add(i);
            });
            double b = average(() -> {
                LinkedList<Integer> x = new LinkedList<>();
                for (int i = 0; i < n; i++) x.add(i);
            });
            double c = average(() -> {
                ArrayList<Integer> x = arrayList(n);
                long sum = 0;
                for (int i = 0; i < 1000; i++) sum += x.get(n / 2);
                if (sum == -1) System.out.print("");
            });
            double d = average(() -> {
                LinkedList<Integer> x = linkedList(n);
                long sum = 0;
                for (int i = 0; i < 1000; i++) sum += x.get(n / 2);
                if (sum == -1) System.out.print("");
            });
            double e = average(() -> {
                ArrayDeque<Integer> x = deque(n);
                for (int i = 0; i < 1000; i++) {
                    x.removeFirst();
                    x.addLast(i);
                }
            });
            System.out.printf(Locale.US, "%d | %.3f | %.3f | %.3f | %.3f | %.3f%n", n, a, b, c, d, e);
        }

        System.out.println("\nComplexity summary:");
        System.out.println("ArrayList: end add amortized O(1), indexed get O(1), middle/front insert/remove O(n), iteration O(n).");
        System.out.println("LinkedList: end add O(1), indexed get O(n), middle/front insertion/removal depends on locating the node; front O(1), iteration O(n).");
        System.out.println("ArrayDeque: front/back add/remove O(1) amortized; indexed access is not supported.");
    }
}
