package cabBooking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import cabBooking.doa.DriverDOA;
import cabBooking.doa.RidesDOA;
import cabBooking.doa.UserDOA;
import cabBooking.model.Driver;
import cabBooking.model.Rides;
import cabBooking.model.User;

public class Main {
static Scanner sc = new Scanner(System.in);

 public static void createTables() {
	 DriverDOA.createTableDriver();
	 UserDOA.createTableUser();
	 RidesDOA.createTableRider();
 }
 public static void Exexute() {
	 int choice = 0;
	 do {System.out.println("\n\n========= CAB BOOKING MENU =========");
	 System.out.println("1. Register User");
	 System.out.println("2. Remove user");
	 System.out.println("3. view users");
	 
	 System.out.println("4. Register Driver");
	 System.out.println("5. Remove driver");
	 System.out.println("6. View Available Drivers");
	 System.out.println("7. View All Drivers");
	 
	 System.out.println("8. Book a Cab");
	 System.out.println("9. Add rides");
	 System.out.println("10. View All Rides");
	 System.out.println("11. Exit");
	 System.out.print("Enter your choice: ");
	 choice=sc.nextInt();
	 sc.nextLine();
	 
	 switch(choice) {
	 case 1://register user
		 	Collection <User> u = new ArrayList<>();
		 	System.out.print("Enter no of users that you want to register:");
		 	int n=sc.nextInt();
		 	sc.nextLine();
		 	for(int i =1;i<=n;i++) {
		 	System.out.print("Enter Name for user "+i+" :");
		 	String name =sc.nextLine();
		 	System.out.print("Enter phone for user "+i+" :");
		 	String phone =sc.nextLine();
		 	u.add(new User(name,phone));
		 	}
		 	UserDOA.registerUser(u);
		 	break;
	 case 2://Remove user
		 	System.out.print("Enter id of user that you want to remove:");
		 	int id=sc.nextInt();
		 	sc.nextLine();
		 	UserDOA.removeUser(id);
		 	break;
	 case 3://getUser
		 
		  	List<User> usersList= UserDOA.getUser();
		  	if(usersList.isEmpty()) {System.out.println("\nNo any users please insert user");}
		 	
		  	usersList.forEach(System.out::println);
		  	break;
		  
	 case 4://register driver
		 	Collection <Driver> d = new ArrayList<>();
		 	System.out.print("Enter no of drivers that you want to register:");
		 	n=sc.nextInt();
		 	sc.nextLine();
		 	for(int i =1;i<=n;i++) {
		 	System.out.print("Enter Name for driver "+i+" :");
		 	String name =sc.nextLine();
		 	
		 	System.out.print("Is user "+i+"avaliable [true/false] :");
		 	boolean avaliable=sc.nextBoolean();
		 	sc.nextLine();
		 	d.add(new Driver(name, avaliable));
		 	}
		 	DriverDOA.registerDriver(d);
		 	break;
	 case 5://remove driver
		 	System.out.print("Enter id of driver that you want to remove:");
		 	id=sc.nextInt();
		 	sc.nextLine();
		 	DriverDOA.removeDriver(id);
		 	break;
	
	 case 6: //getAvalibleDriver
		 	List<Driver> driverList =DriverDOA.getAvalibleDriver();
		 	if(driverList.isEmpty()) {System.out.println("\nNo Driver available");}
		 	driverList.forEach(System.out::println);
		 	break;
	 case 7://getAllDriver
		 	List<Driver> driverListAll =DriverDOA.getAllDriver();
		 	if(driverListAll.isEmpty()) {System.out.println("\nNo any  Driver ...please insert driver");}
		 	
		 	driverListAll.forEach(System.out::println);
		 	break;
	 case 8://BookRide
		 	List<Driver> driver =DriverDOA.getAvalibleDriver();
		 	if(driver.isEmpty())
			{
			System.out.println("\nNO driver available...try after some time ");
			}else 
			{
			System.out.print("\nEnter your user id[register user to get user id]:");
			id=sc.nextInt();
			sc.nextLine();
			
			Driver assignDriver = driver.get(0);
			DriverDOA.changeAvailability(assignDriver.getDrivers_id());
			List<Rides> rider=new ArrayList<>(); 
			rider.add(new Rides (id,assignDriver.getDrivers_id()," BOOKED "));
			System.out.println("\nYour cab booked with driver :"+assignDriver.getName());
			}
			break;
		
		
	 case 9://addrides
		 
		 	Collection <Rides> r = new ArrayList<>();
		 	System.out.print("Enter no of rides that you want to add:");
		 	n=sc.nextInt();
		 	sc.nextLine();
		 	for(int i=1;i<=n;i++) {
		 		System.out.println("Enter Userid for ride "+i);
		 		int user_id=sc.nextInt();
		 		sc.nextLine();
		 		System.out.println("Enter driver_id for ride "+i);
		 		int driver_id=sc.nextInt();
		 		sc.nextLine();
		 		System.out.println("Enter status of ride "+i);
		 		String status = sc.nextLine();
		 		
		 		r.add(new Rides(user_id,driver_id,status));
		 	}
		 	RidesDOA.addRides(r);
		 	
		 	break;
		 
		 
		 
	 case 10://View all rides
		 	List<Rides> ridesListAll =RidesDOA.showRides();
		 	ridesListAll.forEach(System.out::println);
		 	break;

	 case 11:
		 	System.out.println("Exiting...");
		 	break;
	 default:
		 	System.out.println("Please Enter valid input ");
		 	break;

	 	}
	 }while(choice !=11);
 }
 public static void main(String[] args) {
	Main.createTables();
	Main.Exexute();
}
}
