public class BookingBenchmark {
    static class Unsync { boolean[] b; int count; Unsync(int n){b=new boolean[n];} void book(int s){ if(!b[s]){b[s]=true;count++;} } }
    static class Sync { boolean[] b; int count; Sync(int n){b=new boolean[n];} synchronized void book(int s){ if(!b[s]){b[s]=true;count++;} } }
    static long run(boolean sync) throws Exception {
        final int seats=100, users=10000; Thread[] ts=new Thread[users]; long t=System.nanoTime();
        if(sync){Sync x=new Sync(seats); for(int i=0;i<users;i++){final int s=i%seats;ts[i]=new Thread(()->x.book(s));ts[i].start();}for(Thread z:ts)z.join();}
        else{Unsync x=new Unsync(seats); for(int i=0;i<users;i++){final int s=i%seats;ts[i]=new Thread(()->x.book(s));ts[i].start();}for(Thread z:ts)z.join();}
        return (System.nanoTime()-t)/1_000_000;
    }
    public static void main(String[] args)throws Exception{for(int i=1;i<=5;i++)System.out.println(i+","+run(false)+","+run(true));}
}
