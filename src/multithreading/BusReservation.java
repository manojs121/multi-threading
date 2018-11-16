package multithreading;
public class BusReservation {
    private int totalSeatsAvailable=2;
    
    public  void bookSeat(int seats, String name){
        if(seats>getTotalSeatsAvailable()){
            System.out.println("Sorry "+Thread.currentThread().getName());
            System.out.println("Seats Not Available For : "+Thread.currentThread().getName());
        }else{
            System.out.println("Welcome "+Thread.currentThread().getName());
            System.out.println("Seats Available For "+Thread.currentThread().getName()+" : "+getTotalSeatsAvailable());
            totalSeatsAvailable=totalSeatsAvailable-seats;
            System.out.println("Seats Available After Booking Of : "+Thread.currentThread().getName()+" : "+getTotalSeatsAvailable());
        }
    }
    public int getTotalSeatsAvailable() {
        return totalSeatsAvailable;
    }
    
}
