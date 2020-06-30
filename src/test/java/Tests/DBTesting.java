package Tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DBTesting {
	
	
  @Test
  public void f() {
	  /*Connection con = null;
	  Statement stat = null;
	  try {
		// load DB drivers.
		  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		  
		  // Create a connection
		  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "Apple@123");
		  
		  // Create a statement
		  stat = con.createStatement();
		  
		  String sQuery = "SELECT * FROM world.city where Population < 1000";
		  
		  // Execute query using statement and get ResultSet
		  ResultSet rs = stat.executeQuery(sQuery);
		  
		  while (rs.next()){
//			  int country_ID = rs.getInt("ID");
			  int country_ID = (int) rs.getObject("ID");
//			  String sCountry_Code = rs.getString("CountryCode");
			  String sCountry_Code = (String) rs.getObject("CountryCode");
			  
			  
			  System.out.println("country_ID: "+ country_ID + "| CountryCode: "+ sCountry_Code);
		  }
		  
		  rs.close();
		  
		  
	} catch (Exception e) {
		e.printStackTrace();
	} finally{
		
		try {
			if (con != null){
				con.close();
			}
			
			if (stat != null){
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}*/
	  
	  
  }


}
