package com.example.tabledao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.example.entites.Task;
import com.example.productivize.App;
import com.example.services.Utilities;

public class TaskDao {

	private String tableName;
	private Connection connection=DatabaseConnector.getConnection();
    private static final Logger log;
	private Utilities taskUtilities=new Utilities();

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log=Logger.getLogger(App.class.getName());
    }
	
	public TaskDao() 
	{
        super();
        this.tableName="Tasks";
        
    }
	
	//takes Task object as an argument
	public boolean insert(Task task) throws Exception{

		task.id=taskUtilities.getRandomID(999999);
		if (task.id == -1) {
			// if all ids in between 0 to 999999 are taken throw exception
			log.info("TaskDao : Unable to generate a random Unique Id for task");
			throw new Exception("Unable to generate taskID");
		}
		else{
			log.info("Insert new Task");
			try 
			{
				PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO " + tableName
						+ " (t_id, t_name, employee_id, status_id, ms_id) VALUES (?, ?, ?, ?, ?);");
				insertStatement.setInt(1, task.id);
				insertStatement.setString(2, task.name);
				insertStatement.setInt(3, task.employee_id);
				insertStatement.setInt(4, task.status_id);
				insertStatement.setInt(5, task.ms_id);
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

    }
	
	 public boolean delete(int id) 
	 {
	        log.info("Delete Task");
	        try 
	        {
	            PreparedStatement deleteStatement = connection
	                    .prepareStatement("DELETE FROM " + tableName + " WHERE t_id = ?;");
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
	                    + " SET t_name = ?, employee_id = ?, status_id = ?, ms_id = ?  WHERE t_id = ?;");
	            updateStatement.setString(1, task.name);
	            updateStatement.setInt(2, task.employee_id);
	            updateStatement.setInt(3, task.status_id);
	            updateStatement.setInt(4, task.ms_id);
				updateStatement.setInt(5, task.id);
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
		public boolean update(int task_id,int task_status) 
		{
   
			   log.info("Update Task");
			   try 
			   {
				   PreparedStatement updateStatement = connection.prepareStatement("UPDATE " + tableName
						   + " SET status_id = ?  WHERE t_id = ?;");
				   updateStatement.setInt(1, task_status);
				   updateStatement.setInt(2, task_id);
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
