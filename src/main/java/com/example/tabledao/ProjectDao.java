package com.example.tabledao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.example.entites.Project;
import com.example.productivize.App;

public class ProjectDao{

	private String tableName;
	private Connection connection=DatabaseConnector.getConnection();
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log=Logger.getLogger(App.class.getName());
    }
	
	
	public ProjectDao() {
        super();
        this.tableName="Projects";
        
        
    }
	
	public boolean insert(Project project) {

        log.info("Insert new Project");
        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO " + tableName
                    + " (id, p_name, start, end, manager_id, status_id) VALUES (?, ?, ?, ?, ?, ?);");
            insertStatement.setInt(1, project.id);
            insertStatement.setString(2, project.name);
            insertStatement.setString(3, project.start);
            insertStatement.setString(4, project.end);
            insertStatement.setInt(5, project.manager_id);
            insertStatement.setInt(6, project.status_id);
            insertStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            log.info("ProjectDao : Could not insert Project into table");
            e.printStackTrace();
            return false;
        }

    }
	 public boolean delete(int id) {
	        log.info("Delete Project");
	        try {
	            PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM " + tableName + " WHERE id = ?;");
	            deleteStatement.setInt(1, id);
	            deleteStatement.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            log.info("ProjectDao : Could not delete project from table");
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 public boolean update(Project project) {

	        log.info("Update Project");
	        try {
	            PreparedStatement updateStatement = connection.prepareStatement("UPDATE " + tableName
	                    + " SET p_name = ?, start = ?, end = ?, manager_id = ?, status_id = ? WHERE id = ?;");
	            updateStatement.setString(1, project.name);
	            updateStatement.setString(2, project.start);
	            updateStatement.setString(3, project.end);
	            updateStatement.setInt(4, project.manager_id);
				updateStatement.setInt(5, project.status_id);
	            updateStatement.setInt(6, project.id);
	            updateStatement.executeUpdate();
	            return true;

	        } catch (SQLException e) {
	            log.info("ProjectDao : Could not update Project into table");
	            e.printStackTrace();
	            return false;
	        }

	    }
}
