package cabBooking.model;

public class User {
	private int user_id;
	private String name;
	private String phone;
	
	
	
	public User(String name, String phone) {
		
		this.name = name;
		this.phone = phone;
	}

	public User(int user_id, String name, String phone) {
		this.user_id = user_id;
		this.name = name;
		this.phone = phone;
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
}
