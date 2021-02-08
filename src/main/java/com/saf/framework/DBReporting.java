package com.saf.framework;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.text.*;

public class DBReporting {
	private static Connection connectDB() {
		Connection con = null;
		try {
			String path = System.getProperty("user.dir") + "/Reports/DB_Reports/";
			File f = new File(path);
			if(!f.exists()) {
				f.mkdir();
			}
			String dbPath = path + AutomationConstants.reportsDBName;
			String url = "jdbc:sqlite:" + dbPath;
			con = DriverManager.getConnection(url);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	private static Connection connectGrafanaDB() {
		Connection con = null;
		try {
		
			final String host = "inpnqautdev01"; 
			
			final String user = "root"; 
			final String passwd = "@amd0cs";
			final String database = "amdocsdemo"; 
			
			con = DriverManager.getConnection("jdbc:mysql://" + host + "/"
					+ database + "?" + "user=" + user + "&password=" + passwd);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

	public static void insertExecutionDetailsIntoDB(int testID, String status, String message, String testName, String user) {
		String sql = "INSERT INTO TestExecutionDetails(TC_ID, TC_NAME, TEST_STEP, STATUS, EXECUTED_BY, EXECUTION_TIMESTAMP) VALUES(?,?,?,?,?,?)";
		try {
			Connection con = connectDB();
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, testID);
			pStmt.setString(2, testName);
			pStmt.setString(3, message);
			pStmt.setString(4, status);
			pStmt.setString(5, user);
			pStmt.setString(6, new Date().toString());
			int res = pStmt.executeUpdate();
			if (res == 0) {
				System.out.println("No Records were added for reporting!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void updateExecutionDetailsIntoGrafanaDB(int passPercent, String testStep, String stepStatus, int testCaseId) {
				
		String sql = "Update Auto_run Set PASS_PERCENTAGE = " + passPercent + ", EXECUTED_TILL = '" + testStep + "'" + ",EXECUTION_STATUS = '" + stepStatus + "'" + " where RNID = " + testCaseId;

		try {
			Connection con = connectGrafanaDB();
			PreparedStatement pStmt = con.prepareStatement(sql);
			int res = pStmt.executeUpdate();
			if (res == 0) {
				System.out.println("No Records were updated for reporting!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static int insertExecutionRecord(String testName) {
		int testCaseId = 0;
		String sql = "INSERT INTO TestExecution(TC_NAME, LAST_EXECUTION_DATE) VALUES(?,?)";
		try {
			String executionDate = new Date().toString();
			Connection con = connectDB();
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, testName);
			pStmt.setString(2, executionDate);
			int res = pStmt.executeUpdate();
			if (res == 0) {
				System.out.println("No Records were added for reporting!");
			}
			
			//Get the TC ID back for the test case execution record that was created
			Statement stmt = con.createStatement();
			ResultSet rs  = stmt.executeQuery("SELECT TC_ID FROM TestExecution where LAST_EXECUTION_DATE='" + executionDate + "'");
			
			while(rs.next()) {
				testCaseId = rs.getInt("TC_ID");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return testCaseId;
	}
	
	public static int insertExecutionRecordInGrafana(String testName) {
		int testCaseId = 0;
		String strDate;
		Calendar calendar = Calendar.getInstance();
		
		String strMonth = ("0" + (calendar.get(calendar.MONTH)+1));
		if (strMonth.length() > 2)
		{
			strMonth = strMonth.substring(1, strMonth.length());
		}
		String strDay = ("0" + (calendar.get(calendar.DAY_OF_MONTH)));
		if (strDay.length() > 2) {
			strDay = strDay.substring(1, strDay.length());
		}
		strDate = Integer.toString(calendar.get(calendar.YEAR)) + strMonth + strDay;
		System.out.println("String: " + strDate);
		//String sql = "INSERT INTO ATA_AMD (RELEASE_NAME, FLOW_EXECUTED, EXECUTION_DATE) VALUES(?,?,?)";
		//String sql = "INSERT into ATA_AMD (RELEASE_NAME,FLOW_EXECUTED,DATA_CATEGORY,USER_NAME,ENV,PASS_PERCENTAGE,EXECUTED_TILL,EXECUTION_STATUS,EXECUTION_DATE) values (?,?,?,?,?,?,?,?,?)";
		//String sql = "INSERT into ATA_AMD (RELEASE_NAME,FLOW_EXECUTED,DATA_CATEGORY,USER_NAME,ENV,PASS_PERCENTAGE,EXECUTED_TILL,EXECUTION_STATUS,EXECUTION_DATE,DATA,EXE_TIME,ISSUE_TYPE,ROOT_CAUSE,COMMENTS,SYS_CREATION_DATE) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql = "INSERT into Auto_run (RELEASE_NAME,FLOW_EXECUTED,DATA_CATEGORY,USER_NAME,ENV,PASS_PERCENTAGE,EXECUTED_TILL,EXECUTION_STATUS,EXECUTION_DATE,DATA,ISSUE_TYPE,ROOT_CAUSE,COMMENTS,SYS_CREATION_DATE) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			//String executionDate = new Date().toString();
			/*Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMDD");
			String executionDate = formatter.format(date);
			*/
			Connection con = connectGrafanaDB();
			PreparedStatement pStmt = con.prepareStatement(sql);
			//pStmt.setInt(1, testID);
			pStmt.setString(1, "D1");
			pStmt.setString(2, testName);
			pStmt.setString(3, "Demo");
			pStmt.setString(4, System.getProperty("user.name"));
			pStmt.setString(5, "test_env");
			pStmt.setInt(6, 0);
			pStmt.setString(7, "Execution Start");
			pStmt.setString(8, "Not Started");
			//pStmt.setString(9, new Date().toString());
			pStmt.setString(9, strDate);
			pStmt.setString(10, "D");
			//pStmt.setString(11,  "21.2");
			pStmt.setString(11, "I");
			pStmt.setString(12, "R");
			pStmt.setString(13, "C");
			SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			pStmt.setString(14, formatter.format(calendar.getTime()));
			int res = pStmt.executeUpdate();
			
			if (res == 0) {
				System.out.println("No Records were added for reporting!");
			}
			
			//Get the TC ID back for the test case execution record that was created
			Statement stmt = con.createStatement();
			ResultSet rs  = stmt.executeQuery("SELECT RNID FROM Auto_run where EXECUTION_STATUS='Not Started' AND USER_NAME='"+System.getProperty("user.name")+"'");
			
			while(rs.next()) {
				testCaseId = rs.getInt("RNID");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return testCaseId;
	}

}
