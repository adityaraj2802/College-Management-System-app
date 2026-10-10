package com.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;
public class dbConnection {
	

    private static final Dotenv dotenv = Dotenv.configure()
            .directory("C:/Users/hp/eclipse-workspace/02-College-management-system app/.env")
            .load();

    private static final String URL =
            dotenv.get("DB_URL");

    private static final String USERNAME =
            dotenv.get("DB_USERNAME");

    private static final String PASSWORD =
            dotenv.get("DB_PASSWORD");

    public static Connection getConnection()
            throws SQLException {
          try {
        	  Class.forName("com.mysql.cj.jdbc.Driver");
          }catch(Exception e) {
        	  System.out.println("Driver not loaded");
          }

        return DriverManager.getConnection(
                URL, USERNAME, PASSWORD
        );
    }


	
}
