package multithreading;

public class Passenger extends Thread {

    String name;
    int seatReq;
    static BusReservation bs=new BusReservation();

    public Passenger(String name, int seatReq) {
        super(name);
        this.name = name;
        this.seatReq = seatReq;
    }
    
    public void run(){
        bs.bookSeat(seatReq, name);
    }
    
    public static void main(String args[]) throws Exception {
        
        Passenger p1=new Passenger("AAA",2);
        Passenger p2=new Passenger("BBB",2);
        p1.start();
        p2.start();
        
    }
    
}
