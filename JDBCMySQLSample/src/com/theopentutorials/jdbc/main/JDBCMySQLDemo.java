package com.theopentutorials.jdbc.main;


import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.theopentutorials.jdbc.db.JDBCMySQLConnection;


public class JDBCMySQLDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		   try {	           
	            JDBCMySQLDemo demo = new JDBCMySQLDemo();	            
	                      
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	        }
		   
			ResultSet rs = null;
		    Connection connection = null;
		    Statement statement = null; 
		   String query = "SELECT * FROM usuarios";

 
		  
		   
		    try {           
				 connection = JDBCMySQLConnection.getConnection();
				 statement = connection.createStatement();
				 rs = statement.executeQuery(query);
		         
		        while (rs.next()) {
		            
		            System.out.println("EL id: "+rs.getInt("id")+" corresponde a: "+ rs.getString("nombre"));
		  
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        if (connection != null) {
		            try {
		                connection.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		    }

	}  


}
