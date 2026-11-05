import java.lang.management.*;
public class DeadlockDemo {
    static final Object A=new Object(), B=new Object();
    public static void main(String[] args)throws Exception{
        Thread t1=new Thread(()->{synchronized(A){try{Thread.sleep(100);}catch(Exception ignored){} synchronized(B){}}},"Transfer-A-B");
        Thread t2=new Thread(()->{synchronized(B){try{Thread.sleep(100);}catch(Exception ignored){} synchronized(A){}}},"Transfer-B-A");
        t1.start();t2.start();Thread.sleep(300);
        long[] ids=ManagementFactory.getThreadMXBean().findDeadlockedThreads();
        System.out.println("Deadlock detected: "+(ids!=null));
        if(ids!=null) System.out.println("Threads: Transfer-A-B, Transfer-B-A");
        t1.interrupt(); t2.interrupt();
        System.exit(0);
    }
}
