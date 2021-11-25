package com.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao extends DatabaseConnector{

    private String tableName;

    public EmployeeDao() {
        super();
        this.tableName="employees";
    }
    

    // This function inserts employees into table.
    // It takes a Employee object as an argument.
    public boolean insert(Employee employee) {

        log.info("Insert new Employee");
        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO " + tableName
                    + " (e_id, first_name, last_name, password) VALUES (?, ?, ?, ?);");
            insertStatement.setInt(1, employee.id);
            insertStatement.setString(2, employee.first_name);
            insertStatement.setString(3, employee.last_name);
            insertStatement.setString(4, employee.getPassword());
            insertStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            log.info("EmployeeDao :Could not insert employee into table");
            e.printStackTrace();
            return false;
        }

    }

     // This function deletes Employees from table.
    // It takes the worklog id as an argument.
    public boolean delete(int id) {
        log.info("Delete Employee");
        try {
            PreparedStatement deleteStatement = connection
                    .prepareStatement("DELETE FROM " + tableName + " WHERE e_id = ?;");
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            log.info("EmployeeDao :Could not delete worklog from table");
            e.printStackTrace();
            return false;
        }
    }

    // This function updates Employees in the table.
    // It takes a Employee object as an argument.
    public boolean update(Employee employee) {
        log.info("Update Emploee details");
        try {
            PreparedStatement updateStatement = connection.prepareStatement("UPDATE " + tableName
                    + " SET first_name = ?, last_name = ?, password = ? WHERE e_id = ?;");
            updateStatement.setString(1, employee.first_name);
            updateStatement.setString(2, employee.last_name);
            updateStatement.setString(3, employee.getPassword());
            updateStatement.setInt(4, employee.id);
            updateStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            log.info("EmployeeDao : Could not update employee details in table");
            e.printStackTrace();
            return false;
        }

    }
}
