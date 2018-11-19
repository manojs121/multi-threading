package multithreading;

import java.util.Scanner;

class Customer {
    int balance=10000;
    
    synchronized void withdraw(int amount){
        System.out.println("Going to withdraw ..............");
        if(balance<amount){
            System.out.println("Less Balance ; Waiting For Deposit...");
            try{
            wait();
            }catch(Exception e){}
            balance=balance-amount;
            System.err.println("Remaining Balance After Withdraw  : "+balance);
        }
    }
    synchronized void deposit(int amount){
        System.out.println("Going to deposit .....................");
        balance=balance+amount;
        System.out.println("Deposit Completed...............");
        System.out.println("Balance After Deposit : " +balance);
        System.out.println("Now Allow Withdraw : ");
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        notify();
    }
}

public class ITComm {
    public static void main(String[] args) throws Exception {
        Customer c=new Customer();
        
        Thread t1=new Thread(){
            public void run(){
                c.withdraw(25000);
            }
        };
        
        t1.start();
        
        Thread t2=new Thread(){
            public void run(){
                c.deposit(15000);
            }
        };
        t2.start();
        
       t1.join();
       t2.join();
    }
    
    
}
