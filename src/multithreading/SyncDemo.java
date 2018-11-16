package multithreading;
import static java.lang.System.out;
class Counter {
    int count;
    public synchronized void increment(){
        count++;
    }
}
public class SyncDemo {
    public static void main(String args[]) throws Exception{ 
        Counter counter=new Counter();
        Thread t1=new Thread(){
            public void run(){
                for(int i=1;i<=10000;i++){
                counter.increment();
                }
            }
        };
         Thread t2=new Thread(){
            public void run(){
                for(int i=1;i<=10000;i++){
                counter.increment();
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        out.println(counter.count);
    }
}
