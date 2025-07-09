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
import cabBooking.model.Driver;



public class DriverDOA {

	public static void createTableDriver() {
		String sql="CREATE TABLE  if not exists drivers ( drivers_id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL,available BOOLEAN NOT NULL DEFAULT TRUE)";
		try(Connection con=DataBaseConnection.getConnection();
				Statement stmt=con.createStatement();){
			 
			 stmt.executeUpdate(sql);
		 }
		 catch(SQLException e) {e.printStackTrace();}
	}//createTable
	


	public static void registerDriver(Collection<Driver> driver) {
		String sql ="INSERT INTO drivers(name,available) values (?,?)";
		try(Connection con =DataBaseConnection.getConnection()){
			PreparedStatement pstm = con.prepareStatement(sql);
			for(Driver d:driver) {
				pstm.setString(1, d.getName());
				pstm.setBoolean(2, d.isAvaliable());
				pstm.addBatch();
			}
			int [] lines=pstm.executeBatch();
			System.out.println(lines.length+" driver added");
		}catch(SQLException e) {
			System.out.println("Can not add driver");
			e.printStackTrace();
			}
	  }//add driver
	
	public static List<Driver> getAvalibleDriver() {
		List<Driver>  driverList = new ArrayList<>();
		String sql = "SELECT * FROM drivers WHERE available=TRUE";
		try(Connection con = DataBaseConnection.getConnection()){
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
			driverList.add(new Driver(rs.getInt("drivers_id"),rs.getString("name"),rs.getBoolean("available")));	
			}
		}catch(SQLException e) {e.printStackTrace();}
		
		return driverList;
		
	}//getAvalibleDriver
	
	public static List<Driver> getAllDriver() {
		List<Driver>  driverList = new ArrayList<>();
		String sql = "SELECT * FROM drivers";
		try(Connection con = DataBaseConnection.getConnection()){
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs= pstm.executeQuery();
			while(rs.next()) {
			driverList.add(new Driver(rs.getInt("drivers_id"),rs.getString("name"),rs.getBoolean("available")));	
			}
		}catch(SQLException e) {e.printStackTrace();}
		
		return driverList;
		
	}//getAllDriver
	
	public static void removeDriver(int id) {
		String sql ="DELETE FROM drivers where drivers_id=?";
		try(Connection con=DataBaseConnection.getConnection();
				PreparedStatement pstm = con.prepareStatement(sql);){
			pstm.setInt(1, id);
			int n = pstm.executeUpdate();
			System.out.println(n +" Driver deleted");
			
		}catch(SQLException e) {
			System.out.println("Can not remove driver");
			e.printStackTrace();}
	}//remove Driver
	
	public static void changeAvailability(int id) {
		String sql ="Update drivers set available = false where drivers_id=?";
		try(Connection con = DataBaseConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement(sql)
					){
			pstm.setInt(1, id);
			int n= pstm.executeUpdate();
			
			System.out.println(n+" driver updated");
		}catch(SQLException e) {
			System.out.println("Can't update"+e);
			//e.printStackTrace();
			}
	}//changeAvailability
}
