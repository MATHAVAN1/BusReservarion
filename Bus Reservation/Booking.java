package BusReresvation;
import java.util.*;    
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	
	Booking(){
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter Your Name: ");
		passengerName=scanner.next();
		System.out.println("Enter Bus No: ");
		busNo=scanner.nextInt();
		System.out.println("Enter date dd-mm-yy");
		String dateInput=scanner.next();
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd-mm-yyyy");       
		
		try {
			date=dateFormat.parse(dateInput);
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
	
	
	public boolean isAvailable() throws SQLException {
		BusDAO busdao = new BusDAO();
		int capacity =busdao.getCapacity(busNo);
		
		BookingDAO bookingdao = new BookingDAO();
		int booked = bookingdao.getBookedCount(busNo,date);
		
		return booked<capacity;
	}

}
