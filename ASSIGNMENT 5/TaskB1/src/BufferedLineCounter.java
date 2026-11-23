import java.io.*;

public class BufferedLineCounter {
    public static long countLines(File file) throws IOException {
        long lines = 0;
        try (BufferedReader r = new BufferedReader(new FileReader(file))) {
            while (r.readLine() != null) lines++;
        }
        return lines;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java BufferedLineCounter <file>");
            return;
        }
        long start = System.nanoTime();
        long lines = countLines(new File(args[0]));
        long end = System.nanoTime();
        System.out.println("Lines = " + lines);
        System.out.println("Time (ms) = " + ((end - start) / 1_000_000.0));
    }
}
