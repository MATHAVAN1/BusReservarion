package BusReresvation;
import java.sql.*;

public class BusDAO {      
	
	 public void displayBusInfo() throws SQLException {
	     String query ="select * from bus";
	     Connection con=DbConnection.getConnection();
	     Statement stmt = con.createStatement();
	     ResultSet rs = stmt.executeQuery(query);
	     
	     
	     while(rs.next()) {
	    	 System.out.println("Bus No : " + rs.getInt(1));
	    	 if(rs.getInt(2)==0) 
	    		 System.out.println("AC : No ");
	    	 else
	    		 System.out.println("AC : Yes ");
	    	 System.out.println("Capacity : "+ rs.getInt(3)); 
	    	 System.out.println();
	     }
	     System.out.println("**************************************");
	 }
	 
	 
	 
	 public int getCapacity(int id) throws SQLException {
		 String Query="Select capacity from bus where id =" + id;
		 Connection con = DbConnection.getConnection();
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(Query);
		 rs.next();
		 return rs.getInt(1);
	 }
	
	
}


