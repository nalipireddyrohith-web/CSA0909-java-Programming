import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentProcessor {
    static class Result { final boolean success; final String message; Result(boolean s, String m){success=s;message=m;} }
    static Result process(Path file) {
        try {
            String text = Files.readString(file).trim();
            if (!text.matches("\\d+")) throw new IllegalArgumentException("Corrupt score");
            int score = Integer.parseInt(text);
            if (score < 0 || score > 100) throw new IllegalArgumentException("Score out of range");
            return new Result(true, file.getFileName()+" -> score="+score);
        } catch (Exception e) {
            return new Result(false, file.getFileName()+" -> "+e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        Path dir = Path.of("input");
        Files.createDirectories(dir);
        for (int i = 0; i < 100; i++) Files.writeString(dir.resolve("student"+i+".txt"), String.valueOf(i % 101));
        Files.writeString(dir.resolve("corrupt.txt"), "ABC");
        List<Path> files = new ArrayList<>();
        try (var stream = Files.list(dir)) { stream.filter(p -> p.toString().endsWith(".txt")).forEach(files::add); }
        files.add(dir.resolve("missing.txt"));
        int pool = 4;
        ExecutorService executor = Executors.newFixedThreadPool(pool);
        List<Future<Result>> futures = new ArrayList<>();
        for (Path file : files) futures.add(executor.submit(() -> process(file)));
        AtomicInteger ok = new AtomicInteger(), failed = new AtomicInteger();
        for (Future<Result> f : futures) { Result r = f.get(); if (r.success) ok.incrementAndGet(); else failed.incrementAndGet(); }
        executor.shutdown();
        System.out.println("Files processed: " + files.size());
        System.out.println("Successful: " + ok.get());
        System.out.println("Failed: " + failed.get());
        System.out.println("Thread pool size: " + pool);
        System.out.println("Summary complete: " + (ok.get() + failed.get() == files.size()));
    }
}
