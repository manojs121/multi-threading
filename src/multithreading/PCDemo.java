package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

class Utility {
    int num=0;
    boolean valueSet=false;
    public synchronized void put(int num){
        while(valueSet){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.num=num;
        valueSet=true;
        System.out.println("Put  : "+num);
        notify();
        try {
            Thread.sleep(250);
        } catch (InterruptedException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public synchronized int get(){
        while(!valueSet){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Get  : "+num);
        valueSet=false;
        notify();
        try {
            Thread.sleep(250);
        } catch (InterruptedException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return num;
    }
}


public class PCDemo {
    public static void main(String[] args) throws Exception {
        
        Utility util=new Utility();
        
        Thread t1=new Thread(){
            public void run(){
                int n=0;
                while(true){
                    util.put(n++);
                }
            }
        };
        t1.start();
        
        Thread t2=new Thread(){
            public void run(){
                int n=0;
                while(true){
                   util.get();
                }
            }
        };
        t2.start();
        
        t1.join();
        t2.join();
        
        
    }
    
}
