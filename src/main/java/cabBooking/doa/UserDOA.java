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
import cabBooking.model.User;


public class UserDOA {

	public static void createTableUser() {
		String sql="CREATE TABLE if not exists users (user_id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL, phone VARCHAR(15) NOT NULL)";
		try(Connection con=DataBaseConnection.getConnection()){
			 Statement stmt=con.createStatement();
			 stmt.executeUpdate(sql);
		 }
		 catch(SQLException e) {e.printStackTrace();}
	}//createTable
	
	public static void registerUser(Collection<User> user) {
		String sql ="INSERT INTO users(name,phone) values (?,?)";
		try(Connection con =DataBaseConnection.getConnection()){
			PreparedStatement pstm = con.prepareStatement(sql);
			for(User u:user) {
				pstm.setString(1, u.getName());
				pstm.setString(2, u.getPhone());
				pstm.addBatch();
			}
			int [] lines=pstm.executeBatch();
			System.out.println(lines.length+" user register");
		}catch(SQLException e) {
			System.out.println("Can not register user");
			e.printStackTrace();
			}
	  }//register user
	   
	  public static void removeUser(int id) {
		  String sql ="DELETE FROM USERS Where User_id=?";
		  try(Connection con = DataBaseConnection.getConnection()){
			  PreparedStatement pstm =con.prepareStatement(sql);
			  pstm.setInt(1, id);
			  int n=pstm.executeUpdate();
			  System.out.println(n+" user removed");
		  }catch(SQLException e) {
			  System.out.println("Can not remove user");
			  e.printStackTrace();}
	  }//removeUser
	  
	  
	  
	  
	  public static List<User> getUser(){
	  	 List<User> userlist=new ArrayList<>();
	  	 String sql ="SELECT * FROM USERS";
	  	 try(Connection con =DataBaseConnection.getConnection();
	  			 PreparedStatement stm=con.prepareStatement(sql);
	  			 ResultSet rs=stm.executeQuery();){
	  		
	  		 while(rs.next()) {
	  			 User user=new User(rs.getInt("user_id"),rs.getString("name"),rs.getString("phone"));
	  			 userlist.add(user);
	  			  }
	  		
	  	 }
	  	 catch(SQLException e) {e.printStackTrace();}
	  	 return userlist;
	  }//GetUser
	
	
}
