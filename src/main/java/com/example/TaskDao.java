package com.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDao extends DatabaseConnector 
{

	private String tableName;
	
	public TaskDao() 
	{
        super();
        this.tableName="Tasks";
        
    }
	
	//takes Task object as an argument
	public boolean insert(Task task) 
	{

        log.info("Insert new Task");
        try 
        {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO " + tableName
                    + " (id, name, employee_id, status_id, ms_id, project_id) VALUES (?, ?, ?, ?, ?, ?);");
            insertStatement.setInt(1, task.id);
            insertStatement.setString(2, task.name);
            insertStatement.setInt(3, task.employee_id);
            insertStatement.setInt(4, task.status_id);
            insertStatement.setInt(5, task.ms_id);
            insertStatement.setInt(6, task.project_id);
            insertStatement.executeUpdate();
            return true;
        } 
        
        catch (SQLException e) 
        {
            log.info("TaskDao: Could not insert Task into the table");
            e.printStackTrace();
            return false;
        }

    }
	
	 public boolean delete(int id) 
	 {
	        log.info("Delete Task");
	        try 
	        {
	            PreparedStatement deleteStatement = connection
	                    .prepareStatement("DELETE FROM " + tableName + " WHERE id = ?;");
	            deleteStatement.setInt(1, id);
	            deleteStatement.executeUpdate();
	            return true;
	        } 
	        catch (SQLException e) 
	        {
	            log.info("TaskDao: Could not delete task from the table");
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 //takes a Task object as an argument
	 public boolean update(Task task) 
	 {

	        log.info("Update Task");
	        try 
	        {
	            PreparedStatement updateStatement = connection.prepareStatement("UPDATE " + tableName
	                    + " (id, name, employee_id, status_id, ms_id, project_id) VALUES (?, ?, ?, ?, ?, ?);");
	            updateStatement.setInt(1, task.id);
	            updateStatement.setString(2, task.name);
	            updateStatement.setInt(3, task.employee_id);
	            updateStatement.setInt(4, task.status_id);
	            updateStatement.setInt(5, task.ms_id);
	            updateStatement.setInt(6, task.project_id);
	            updateStatement.executeUpdate();
	            return true;

	        } 
	        catch (SQLException e) 
	        {
	            log.info("TaskDao: Could not update task in the table");
	            e.printStackTrace();
	            return false;
	        }

	    }
}
