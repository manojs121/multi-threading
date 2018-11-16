package multithreading;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DmnDemo {
public static void main(String args[]) throws Exception {
    Thread t1=new Thread(new Runnable(){
    public void run(){
        for(int i=1; i<=20; i++){
            out.println(Thread.currentThread().getName()+"=>"+i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(DmnDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    });
    Thread t2=new Thread(new Runnable(){
    public void run(){
        try{
            FileOutputStream fos=new FileOutputStream("data.txt");
            while(true){
            String s=new java.util.Date().toString();
            out.println(s);
            fos.write(s.getBytes());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    });
    
    
    t2.setDaemon(true);
    t1.start();
    t2.start();
    
    //Thread.currentThread().stop();
    out.println("End-of-main");
}
}
