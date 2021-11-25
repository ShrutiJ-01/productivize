package com.example.viewsdao;

import com.example.*;
import com.example.productivize.App;
import com.example.tabledao.DatabaseConnector;

import java.sql.Connection;
import java.util.logging.Logger;

public class Employee_task_view{
    
    private Connection connection=DatabaseConnector.getConnection();
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log=Logger.getLogger(App.class.getName());
    }
           
}
