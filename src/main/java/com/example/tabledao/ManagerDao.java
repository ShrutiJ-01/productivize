package com.example.tabledao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.example.entites.Manager;
import com.example.productivize.App;


//TODO : make delete and update functions return codes if given id doesnt exist.

public class ManagerDao{
    private String tableName;
    private Connection connection=DatabaseConnector.getConnection();
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log=Logger.getLogger(App.class.getName());
    }

    public ManagerDao() {
        super();
        this.tableName="managers";
    }
    

    // This function inserts Managers into table.
    // It takes a Manager object as an argument.
    public boolean insert(Manager manager) {

        log.info("Insert new Employee");
        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO " + tableName
                    + " (id, first_name, last_name, password) VALUES (?, ?, ?, ?);");
            insertStatement.setInt(1, manager.id);
            insertStatement.setString(2, manager.first_name);
            insertStatement.setString(3, manager.last_name);
            insertStatement.setString(4, manager.getPassword());
            insertStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            log.info("ManagerDao :Could not insert employee into table");
            e.printStackTrace();
            return false;
        }

    }

     // This function deletes Managers from table.
    // It takes the Manager id as an argument.
    public boolean delete(int id) {
        log.info("Delete Manager");
        try {
            PreparedStatement deleteStatement = connection
                    .prepareStatement("DELETE FROM " + tableName + " WHERE id = ?;");
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            log.info("ManagerDao :Could not delete worklog from table");
            e.printStackTrace();
            return false;
        }
    }

    // This function updates Managers in the table.
    // It takes a Manager object as an argument.
    public boolean update(Manager manager) {
        log.info("Update Manager details");
        try {
            PreparedStatement updateStatement = connection.prepareStatement("UPDATE " + tableName
                    + " SET first_name = ?, last_name = ?, password = ? WHERE id = ?;");
            updateStatement.setString(1, manager.first_name);
            updateStatement.setString(2, manager.last_name);
            updateStatement.setString(3, manager.getPassword());
            updateStatement.setInt(4, manager.id);
            updateStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            log.info("ManagerDao : Could not update employee details in table");
            e.printStackTrace();
            return false;
        }

    }
}