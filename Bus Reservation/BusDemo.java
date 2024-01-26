package BusReresvation;
import java.util.Scanner;
import java.sql.SQLException;

public class BusDemo {
	
	public static void main(String[]args) throws SQLException {
		
		
		BusDAO busdao = new BusDAO();
		busdao.displayBusInfo();
		
		int userGiven=1;
		while(userGiven==1) {
			System.out.println("Enter 1 to Book Enter 2 to Exit");
			Scanner scanner =new Scanner(System.in);
			userGiven=scanner.nextInt();
			if(userGiven==1) {
				Booking booking = new Booking();
				if(booking.isAvailable()) {
					BookingDAO bookingdao = new BookingDAO();
					bookingdao.addBooking(booking);
				
					System.out.println("Your booking is confirmed");
				}
				else {
					System.out.println("Soory this bus is full, try another bus or date");
				}
			}
			if(userGiven==2) {
				System.out.println("Exit........");;
			}
		}
		
	}
}
