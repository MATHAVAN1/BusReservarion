package BusReresvation;
import java.sql.*;

public class DbConnection {
	private static final  String url="jdbc:mysql://localhost:3306/busreserve";
	private static final  String userName="root";
	private static final  String password="maddy@01";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,userName,password);
	}

}