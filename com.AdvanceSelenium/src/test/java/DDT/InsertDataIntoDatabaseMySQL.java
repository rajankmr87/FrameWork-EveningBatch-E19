package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoDatabaseMySQL {

	public static void main(String[] args) throws Throwable {

				//Step 1:- Register driver/load mysql database
				Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
				
				//Step 2:- get connect to database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdb", "root", "Admin@123");
				
				//Step 3:- create SQL statement to Insert
				Statement state = conn.createStatement();
				String query = "insert into employee values(1,'Rajan','Kumar','Gurgaon')";
				
				int result = state.executeUpdate(query);
				if(result==1)
				{
					System.out.println("Data inserted");
				}
				else
				{
					System.out.println("Data not inserted.");
				}
				conn.close();
				
	}

}
