package com.example.tabledao;

import java.util.logging.Logger;

import com.example.entites.Employee;
import com.example.entites.Manager;
import com.example.productivize.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticate{
    private String employeeTableName;
    private String managerTableName;
    private Connection connection=DatabaseConnector.getConnection();
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log=Logger.getLogger(App.class.getName());
    }
    
    public Authenticate(){
        employeeTableName="employees";
        managerTableName="managers";
    }

    //This method verifies if an employee of entered credentials
    //exists in the database. Returns employee object for correct 
    //credentials and throws exception otherwise
    public Employee loginEmployee(int Uid, String password)throws Exception{

        log.info("Authenticate : Verifying employee credentials");
        PreparedStatement readStatement;
        try {
            readStatement = connection.prepareStatement("SELECT first_name, last_name FROM " +employeeTableName+ " WHERE e_id = ? and password = ?;");
            readStatement.setInt(1,Uid);
            readStatement.setString(2,password);
            ResultSet resultSet = readStatement.executeQuery();//execute the select query

            if (!resultSet.next()) {//if the resultset is empty throw exception
               throw new Exception("Authenticate : Incorrect Credentials");
            }
            else{ //return employee if resultSet contains corresponding data     
            log.info("Authenticate  : Data found in table");
            return new Employee(Uid,resultSet.getString("first_name"),resultSet.getString("last_name"),true);
            }

        } catch (SQLException e) {//throw exception when database error occurs
            log.info("EntityStatusDao  : Could not read from task status table ");
            e.printStackTrace();
            throw new Exception("Authenticate : Unabel to login because of databse Error");
        }

    }

    //This method inserts an employee into employee table using employee daos insert method
    //It throws an exception if the employee couldnit be inserted.
    public Employee registerEmployee(String first_name, String last_name,String password) throws Exception{

        log.info("Autheticate : Registering employee in database");

        EmployeeDao employeeDao = new EmployeeDao();
        Employee new_employee=new Employee(9678,first_name,last_name,false);//1 is used as a dummy value here=>The uniqueId generator will be called here
        new_employee.setPassword(password);

        //insert employee into database
        boolean isRegistered=employeeDao.insert(new_employee);

        if(isRegistered){
            //if registered successfully return new employee
            return new_employee;
        }
        else{

            //if registration fails throw exception
            log.info("Autheticate : Employee Not registered");
            throw new Exception("Unable to register employee");
        }

    }

     //This method verifies if an employee of entered credentials
    //exists in the database. Returns employee object for correct 
    //credentials and throws exception otherwise
    public Manager loginManager(int Uid, String password)throws Exception{

        log.info("Authenticate : Verifying manager credentials");
        PreparedStatement readStatement;
        try {
            readStatement = connection.prepareStatement("SELECT first_name, last_name FROM " +managerTableName+ " WHERE id = ? and password = ?;");
            readStatement.setInt(1,Uid);
            readStatement.setString(2,password);
            ResultSet resultSet = readStatement.executeQuery();//execute select query

            if (!resultSet.next()) {//if the resultset is empty throw exception
               throw new Exception("Authenticate : Incorrect Credentials");
            }
            else{//return the manager if resultSet contains corresponding data
            log.info("Authenticate  : Data found in table");
            return new Manager(Uid,resultSet.getString("first_name"),resultSet.getString("last_name"),true);
            }

        } catch (SQLException e) {//throw exception when database error occurs
            log.info("EntityStatusDao  : Could not read from task status table ");
            e.printStackTrace();
            throw new Exception("Authenticate : Unabel to login because of databse Error");
        }

    }

    //This method inserts an manager into employee table using employee daos insert method
    //It throws an exception if the employee couldnit be inserted.
    public Manager registerManager(String first_name, String last_name,String password) throws Exception{

        log.info("Autheticate : Registering manager in database");

        ManagerDao managerDao = new ManagerDao();
        Manager new_manager = new Manager(9678,first_name,last_name,false);//1 is used as a dummy value here=>The uniqueId generator will be called here
        new_manager.setPassword(password);

        //insert employee into database
        boolean isRegistered=managerDao.insert(new_manager);

        if(isRegistered){
            //if registered successfully return new employee
            return new_manager;
        }
        else{

            //if registration fails throw exception
            log.info("Autheticate : Manager Not registered");
            throw new Exception("Unable to register maanger");
        }

    }
}
