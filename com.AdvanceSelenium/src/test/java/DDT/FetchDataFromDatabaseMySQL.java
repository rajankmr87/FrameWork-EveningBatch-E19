package DDT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class FetchDataFromDatabaseMySQL {

	public static void main(String[] args) throws Throwable {
		//Step 1:- Register driver/load mysql database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2:- get connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdb", "root", "Admin@123");
		
		//Step 3:- create SQL statement
		Statement state = conn.createStatement();
		String query = "select * from employee"; //table_name
		
		//Step 4:- Execute statement/query
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		

		//Step 5:- close the database
		conn.close();
		
	}

}
