package cabBooking.model;

public class Driver {

	private int drivers_id;
	private String name;
	private boolean avaliable;
	
	
	
	public Driver(String name, boolean avaliable) {
		
		this.name = name;
		this.avaliable = avaliable;
	}

	public Driver(int drivers_id, String name, boolean avaliable) {
		this.drivers_id = drivers_id;
		this.name = name;
		this.avaliable = avaliable;
	}

	public int getDrivers_id() {
		return drivers_id;
	}

	public void setDrivers_id(int drivers_id) {
		this.drivers_id = drivers_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvaliable() {
		return avaliable;
	}

	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}

	@Override
	public String toString() {
		return "Driver [drivers_id=" + drivers_id + ", name=" + name + ", avaliable=" + avaliable + "]";
	}
	
	
}
