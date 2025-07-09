package cabBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	
	private static final String URL="jdbc:postgresql://localhost:5432/mydb";
	private static final String USER="postgres";
	private static final String PASSWD="root123";
	 
	public static Connection getConnection() throws SQLException{
		 return DriverManager.getConnection(URL, USER, PASSWD);
	}
	 
}
