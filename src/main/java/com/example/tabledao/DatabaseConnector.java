package com.example.tabledao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import com.example.productivize.App;

public class DatabaseConnector {
    //This class is a singleton which provides us with a connection object to be used everywhere
    //across the application.

    protected static final Logger log;
    static Connection connection=null;

    //This just sets up the log class.This is only used to print out console logs.
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log=Logger.getLogger(App.class.getName());
    }

    //private constructor so that class cannot be insatntiated.
    private DatabaseConnector(){}


    //This application returns the connection object which was created at the start of the 
    //appplication.
    public static Connection getConnection()
    {
        if (connection != null) {//return existing connection object
            return connection;
        }
        else{//if a connection has not been created yet
            return connectToDatabase();
        }
    }

    //This private methods establishes a connection with the database and returns
    //a connection object.It is made private because we want no other class to
    //access it.This means only the getConnection method is accesible to other classes
    //hence the same connection object is used everywhere across the application.
    private static Connection connectToDatabase() {

        log.info("Loading application properties");
        Properties properties = new Properties();
        try {
            properties.load(App.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e1) {
            log.info("Database Connector : Couldnot load application.properties");
            e1.printStackTrace();
        }

        //connect to the database
        log.info("Database Connector : Connecting to the database");
        try {
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
            return connection;
        } catch (SQLException e) {
            log.info("Database Connector : Could not connect to databse");
            e.printStackTrace();
            return null;
        }   
    }    
}
