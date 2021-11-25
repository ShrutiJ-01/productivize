package com.views;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.DatabaseConnector;

public class Manager_view extends DatabaseConnector{
	private String viewName;

    public Manager_view() {
        super();
        this.viewName="manager_view";
    }
    
    public ResultSet getWorklog(int project_id)
    {  //function body
    	String manager_query = "select employee_id,first_name,last_name,t_id,t_name,m_name from viewName WHERE project_id = project_id";
    	try  {
    		PreparedStatement manager = connection.prepareStatement(manager_query);
    		ResultSet worklog_result = manager.executeQuery(manager_query);
            return worklog_result;
    	}
    	
    	catch (SQLException e) {
            log.info("manager_view: Could not show projects");
            e.printStackTrace();
            return null;
        }
        
    	
    } 
}
