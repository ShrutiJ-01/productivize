package com.example.viewsdao;

import com.example.productivize.App;
import com.example.tabledao.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class EmployeeTaskView{
	
	private String viewName;
	private int statusTodo = 401;
	private int statusDoing = 402;
	private int statusCompleted = 403;
	
    private Connection connection=DatabaseConnector.getConnection();
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log=Logger.getLogger(App.class.getName());
    }
    public EmployeeTaskView() {
        super();
        this.viewName="employee_tasks_view";
    }
    
    
    public ResultSet getTodoTasks(int employee_id)
    {  //function body
    	try  {
    		PreparedStatement todoTasks = connection.prepareStatement("select t_name,t_id,m_name,p_name from "+viewName+" WHERE e_id = ? AND status_id = "+statusTodo+"");
    		todoTasks.setInt(1,employee_id);
    		ResultSet todoTasksResult = todoTasks.executeQuery();
            if (!todoTasksResult.next()) {//if the resultSet is empty return null
                log.info("EmployeeTasksViewDao : No Matching Data found in View");
                return null;
            }
            else{ //return resultSet containing data     
            log.info("EmployeeTasksViewDao : Data found in View");
            return todoTasksResult;
            }
    	}
    	
    	catch (SQLException e) {
            log.info("Employee_tasks_view: Could not read from Employee_tasks_view");
            e.printStackTrace();
            return null;
        }
    	
    } 
    public ResultSet getDoingTasks(int employee_id)
    {  //function body
    	
    	try  {
    		PreparedStatement doingTasks = connection.prepareStatement("select t_name,t_id,m_name,p_name from "+viewName+" WHERE e_id = ? AND status_id = "+statusDoing+"");
    		doingTasks.setInt(1,employee_id);
    		ResultSet doingTasksResult = doingTasks.executeQuery();
            if (!doingTasksResult.next()) {//if the resultSet is empty return null
                log.info("EmployeeTasksViewDao : No Matching Data found in View");
                return null;
            }
            else{ //return resultSet containing data     
            log.info("EmployeeTasksViewDao : Data found in View");
            return doingTasksResult;
            }
    	}
    	
    	catch (SQLException e) {
            log.info("Employee_tasks_view: Could not read from Employee_tasks_view");
            e.printStackTrace();
            return null;
        }
        
    	
    } 
    public ResultSet getCompletedTasks(int employee_id)
    {  //function body
    	//int statusCompleted = 403;
    	
    	try  {
    		PreparedStatement completedTasks = connection.prepareStatement("select t_name,t_id,m_name,p_name from "+viewName+" WHERE e_id = ? AND status_id = "+statusCompleted+"");
    		completedTasks.setInt(1,employee_id);
    		ResultSet completedTasksresult = completedTasks.executeQuery();
            if (!completedTasksresult.next()) {//if the resultSet is empty return null
                log.info("EmployeeTasksViewDao : No Matching Data found in View");
                return null;
            }
            else{ //return resultSet containing data     
            log.info("EmployeeTasksViewDao : Data found in View");
            return completedTasksresult;
            }
    	}
    	
    	catch (SQLException e) {
            log.info("Employee_tasks_view: Could not read from Employee_tasks_view");
            e.printStackTrace();
            return null;
        }
        
    	
    } 
    public ResultSet getCustomProjects(int employee_id,int status_id,int project_id)
    {  //function body
    	//int statusCompleted = 403;
    	
    	try  {
    		PreparedStatement customProjects = connection.prepareStatement("select t_name,t_id,m_name,p_name from "+viewName+" WHERE e_id = ? AND status_id = ? AND id = ?");
    		customProjects.setInt(1,employee_id);
    		customProjects.setInt(1,status_id);
    		customProjects.setInt(1,project_id);
    		ResultSet customProjectsResult = customProjects.executeQuery();
            if (!customProjectsResult.next()) {//if the resultSet is empty return null
                log.info("EmployeeTasksViewDao : No Matching Data found in View");
                return null;
            }
            else{ //return resultSet containing data     
            log.info("EmployeeTasksViewDao : Data found in View");
            return customProjectsResult;
            }
    	}
    	
    	catch (SQLException e) {
            log.info("Employee_tasks_view: Could not read from Employee_tasks_view");
            e.printStackTrace();
            return null;
        }
        
    	
    } 


           
}
