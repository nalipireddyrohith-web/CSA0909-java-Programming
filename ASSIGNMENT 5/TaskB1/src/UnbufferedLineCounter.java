import java.io.*;

public class UnbufferedLineCounter {
    public static long countLines(File file) throws IOException {
        long lines = 0;
        try (FileInputStream in = new FileInputStream(file)) {
            int b;
            while ((b = in.read()) != -1) {
                if (b == '\n') lines++;
            }
        }
        return lines;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java UnbufferedLineCounter <file>");
            return;
        }
        long start = System.nanoTime();
        long lines = countLines(new File(args[0]));
        long end = System.nanoTime();
        System.out.println("Lines = " + lines);
        System.out.println("Time (ms) = " + ((end - start) / 1_000_000.0));
    }
}
