package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DatabaseConnector {
    //This class is designed to be the base class of all the Database Access Layer classes(DAO). 
    //This class makes a connection with the SQL databse hosted on Azure and the same connection 
    //object is inherited by the DAO classes when their objects are created in service classes.

    protected static final Logger log;
    protected Connection connection;

    //This just sets up the log class.This is only used to print out console logs.
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log=Logger.getLogger(App.class.getName());
    }

    //The constructor of this class is protected because we only want the sub classes to acess it. 
    //We donot want to allow creation of objects for this class.This way only the sub calsses can aces this class and 
    //the implemntation remians hidden from the rest of the classes. 
    protected DatabaseConnector() {
        log.info("Loading application properties");
        Properties properties = new Properties();
        try {
            properties.load(App.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e1) {
            log.info("Couldnot load application.properties");
            e1.printStackTrace();
        }

        //connect to the database
        log.info("Connecting to the database");
        try {
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        } catch (SQLException e) {
            log.info("Could not connect to databse");
            e.printStackTrace();
        }   
    }    
}
