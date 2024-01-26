package BusReresvation;
import java.sql.*;
import java.util.Date;

public class BookingDAO {
	
	public int getBookedCount(int busNo,Date date) throws SQLException{
		String Query="Select count(passanger_name) from booking where bus_no=? and travel_date=?";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Query);
		pst.setInt(1, busNo);
	    java.sql.Date sqldate = new java.sql.Date(date.getTime());
	    pst.setDate(2, sqldate);
	    ResultSet rs = pst.executeQuery();
	    rs.next();
	    return rs.getInt(1); 
	}
	
	
	public void addBooking(Booking booking) throws SQLException {
		String Query = "insert into booking values(?,?,?)";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(Query);
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.busNo);
	    java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
		pst.setDate(3, sqldate);
		pst.executeUpdate();
	}

}
