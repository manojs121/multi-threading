package multithreading;

import java.io.FileInputStream;
import static java.lang.System.out;

public class TheadTest {
public static void main(String args[]) throws Exception{

    long start=System.nanoTime();
    
    Thread t1=new Thread(new Runnable(){
    public void run(){
        try{
        FileInputStream fis1=new FileInputStream("first.txt");
        int n1;
    while((n1=fis1.read())!=-1){
        out.print((char)n1);
    }    
        }catch(Exception e){}
    }
    });
    Thread t2=new Thread(new Runnable(){
    public void run(){
        try{
        FileInputStream fis2=new FileInputStream("second.txt");
        int n1;
    while((n1=fis2.read())!=-1){
        out.print((char)n1);
    }    
        }catch(Exception e){}
    }
    });
    t1.start();
    t2.start();
    t1.join(); t2.join();
    out.println(System.nanoTime()-start);
}
}
