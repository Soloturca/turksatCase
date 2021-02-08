package com.saf.framework;

import java.sql.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.saf.framework.HashMapNew;

public class DataBase {

	public ExtentReports oExtentReports;
	public ExtentTest oExtentTest;
	public HashMapNew dictionary;
	
	public enum DBType
	{
		ORACLE, MYSQL, MSACCESS;
	}
	
	DBType oDBType;
	
	public DataBase(ExtentReports oExtentReports, ExtentTest oExtentTest, HashMapNew dictionary, DBType oDBType) {
		this.oExtentReports = oExtentReports;
		this.oExtentTest = oExtentTest;
		this.dictionary = dictionary;
		this.oDBType = oDBType;
	}
	
		public Statement DataBaseConn(String connectionString){
			
			switch(oDBType)
			{
			case ORACLE:
				try {
					
					//Load the driver class 
					String DBClass = "oracle.jdbc.driver.OracleDriver";
					Class.forName(DBClass).newInstance();

					//Create the connection object  
					Connection con = DriverManager.getConnection(connectionString.split("\\,")[0],connectionString.split("\\,")[1],connectionString.split("\\,")[2]);
					
					//Create the statement object  
					Statement stmt = con.createStatement();
					return stmt;
					
					//Execute query  
					//ResultSet rs = stmt.executeQuery("select logical_date from logical_date");
								
					//if (!rs.next()) {                            //if rs.next() returns false
	                    //then there are no rows.
						//System.out.println("No records found");

					//}
					//else {
						//do {
							//System.out.println(rs.getRow());
							//System.out.println(rs.getString(1));
						//} while (rs.next());
					//}
					
					//String strExpected = dictionary.get("PASSWORD");	
					
					//con.close();  
				}
				
				catch(Exception e){
					e.printStackTrace();
				}
				break;
				
			case MYSQL:
				try {
					
					//Load the driver class 
					String DBClass = "com.mysql.jdbc.Driver";
					Class.forName(DBClass).newInstance();

					//Create the connection object  
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:port/ServiceName", "UserID", "Password");
					
					//Create the statement object  
					Statement stmt = con.createStatement();
					return stmt;
					
				}
				
				catch(Exception e){
					e.printStackTrace();
				}
				break;
				
			case MSACCESS:
				try {
					
					//Load the driver class 
					String DBClass = "oracle.jdbc.driver.OracleDriver";
					Class.forName(DBClass).newInstance();

					//Create the connection object  
					Connection con = DriverManager.getConnection("connection details","UserId","Password");
					
					//Create the statement object  
					Statement stmt = con.createStatement();
					return stmt;
					
				}
				
				catch(Exception e){
					e.printStackTrace();
				}
				break;			
				
				
			}
			return null;
			
			
			
		}
	
	
}


