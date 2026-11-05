import java.nio.file.*;import java.util.*;import java.util.concurrent.*;
public class PoolBenchmark{
 static void process(Path p){try{String s=Files.readString(p).trim();if(!s.matches("\\d+"))throw new Exception();}catch(Exception ignored){}}
 public static void main(String[] a)throws Exception{Path d=Path.of("input");List<Path> fs=new ArrayList<>();try(var st=Files.list(d)){st.filter(p->p.toString().endsWith(".txt")).forEach(fs::add);}fs.add(d.resolve("missing.txt"));for(int pool:new int[]{1,2,4,8}){long t=System.nanoTime();ExecutorService e=Executors.newFixedThreadPool(pool);for(Path p:fs)e.submit(()->process(p));e.shutdown();e.awaitTermination(1,TimeUnit.MINUTES);System.out.println(pool+","+((System.nanoTime()-t)/1_000_000.0));}}
}
