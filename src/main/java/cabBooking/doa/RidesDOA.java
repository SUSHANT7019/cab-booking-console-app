package cabBooking.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cabBooking.DataBaseConnection;
import cabBooking.model.Rides;

public class RidesDOA {

	public static void createTableRider() {
		String sql="CREATE TABLE if not exists rides (ride_id SERIAL PRIMARY KEY, user_id INT NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,"
				+ "driver_id INT NOT NULL REFERENCES drivers(drivers_id) ON DELETE SET NULL, status VARCHAR(20) NOT NULL)";
		try(Connection con=DataBaseConnection.getConnection();
			Statement stmt=con.createStatement();
			)
			{
			 stmt.executeUpdate(sql);
			
			}
		 catch(SQLException e) {
			 System.out.println("User or Drier does not Exist");
			 e.printStackTrace();}
	}//createTable
	
	public static void addRides(Collection<Rides> rides) {
		String sql ="INSERT INTO rides(user_id , driver_id ,status) values(?,?,?)";
		try(Connection con = DataBaseConnection.getConnection();
				PreparedStatement pstm = con.prepareStatement(sql);
				)
			{
			for(Rides r : rides)
					{
				pstm.setInt(1, r.getUser_id());
				pstm.setInt(2, r.getDriver_id());
				pstm.setString(3, r.getStstus());
				pstm.addBatch();
					}
			int lines[]=pstm.executeBatch();
			System.out.println(lines.length + " Rides added");
		}
		catch(SQLException e)
		{
			System.out.println("Can not add rides"+e.getMessage());
		}
	}//add rides
	
	public static List<Rides> showRides() {
		String sql ="SELECT * FROM rides";
		List<Rides> ridelist = new ArrayList<>();
		
		try(Connection con =DataBaseConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();){
			while(rs.next()) {
				ridelist.add(new Rides(rs.getInt("ride_id"),rs.getInt("user_id"),rs.getInt("driver_id"),rs.getString("status")));
			}
			
			
		}catch(SQLException e) {e.printStackTrace();}
		return ridelist;
	}//showRides


}
