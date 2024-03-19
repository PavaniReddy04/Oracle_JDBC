package com.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class App {

	public static void main(String[] args) {
		final Properties properties = new Properties();
		properties.setProperty("user", "C##EmployeeManagement");
		properties.setProperty("password", "123");
		try {
			//Using property file in getConnection method
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",properties);
			
			//Using only URL as parameter to getConnection method
			//Connection connection= DriverManager.getConnection("jdbc:oracle:thin:C##EmployeeManagement/123@localhost:1521:orcl");
			
			//Using only URL, username, password as parameters to getConnection method
			//Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","C##EmployeeManagement","123");
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from client");
			
			//need to use the methods getInt/ getString/ getFloat etc correctly. 
			//For example if getInt is used while retrieving String, it throws "SQLException: Fail to convert"
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
