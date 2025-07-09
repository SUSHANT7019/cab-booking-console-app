package cabBooking.model;

public class Rides {
	private int ride_id;
	private int user_id;
	private int driver_id;
	private String ststus;
	
	
	
	public Rides(int user_id, int driver_id, String ststus) {
	
		this.user_id = user_id;
		this.driver_id = driver_id;
		this.ststus = ststus;
	}
	public Rides(int ride_id, int user_id, int driver_id, String ststus) {
		this.ride_id = ride_id;
		this.user_id = user_id;
		this.driver_id = driver_id;
		this.ststus = ststus;
	}
	public int getRide_id() {
		return ride_id;
	}
	public void setRide_id(int rider_id) {
		this.ride_id = rider_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	public String getStstus() {
		return ststus;
	}
	public void setStstus(String ststus) {
		this.ststus = ststus;
	}
	@Override
	public String toString() {
		return "Rider [ride_id=" + ride_id + ", user_id=" + user_id + ", driver_id=" + driver_id + ", ststus="
				+ ststus + "]";
	}
	
	
	
	
	

}
