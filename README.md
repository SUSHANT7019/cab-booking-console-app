🚖 Cab Booking App (Console-Based)
A simple console-based Java application that simulates a basic cab booking system using:

✅ Core Java (OOP, JDBC, Exception Handling)

✅ PostgreSQL Database

✅ Maven Project Structure

📂 Project Structure
cab-booking-app/

├── pom.xml

└── src/

    └── main/
    
        └── java/
            └── cabbooking/
                ├── Main.java
                ├── DBConnection.java
                ├── dao/
                │   ├── UserDAO.java
                │   ├── DriverDAO.java
                │   └── RideDAO.java
                └── model/
                    ├── User.java
                    ├── Driver.java
                    └── Ride.java
🗃️ Database Setup (PostgreSQL)

CREATE TABLE if not exists  users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    phone VARCHAR(15)
);

CREATE TABLE if not exists  drivers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    available BOOLEAN DEFAULT TRUE
);

CREATE TABLE if not exists rides (
    ride_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    driver_id INT REFERENCES drivers(id) ON DELETE SET NULL,
    status VARCHAR(20)
);

⚙️ Configuration
Edit the PostgreSQL credentials in DBConnection.java:

String url = "jdbc:postgresql://localhost:5432/cab_booking_app";
String user = "postgres";
String password = "root123";
🚀 How to Run
Clone the repo or copy the project folder.

Set up PostgreSQL and create the required tables.

Open the project in Eclipse, IntelliJ, or any IDE with Maven support.

Run Main.java to start the app.

Use the console menu to:

![ER Diagram](./Screenshot%202025-07-09%20193232.png)





🧠 Features
Register users & drivers

Book a ride with the first available driver

View all available drivers

View all rides

PostgreSQL JDBC with basic DAO pattern

📦 Dependencies (in pom.xml)

<dependencies>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.1</version>
    </dependency>
</dependencies>

🧑‍💻 Author
Made with 💡 by Sushant Thadge

