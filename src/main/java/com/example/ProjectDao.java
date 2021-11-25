package com.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectDao extends DatabaseConnector {

	private String tableName;
	
	
	public ProjectDao() {
        super();
        this.tableName="Projects";
        
        
    }
	
	public boolean insert(Project project) {

        log.info("Insert new Project");
        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO " + tableName
                    + " (id, p_name, start, end, manager_id, status_id) VALUES (?, ?, ?, ?);");
            insertStatement.setInt(1, project.id);
            insertStatement.setString(2, project.name);
            insertStatement.setString(3, project.start);
            insertStatement.setString(4, project.end);
            insertStatement.setInt(4, project.manager_id);
            insertStatement.setInt(4, project.status_id);
            insertStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            log.info("ProjectDao :Could not insert Project into table");
            e.printStackTrace();
            return false;
        }

    }
	 public boolean delete(int id) {
	        log.info("Delete Project");
	        try {
	            PreparedStatement deleteStatement = connection
	                    .prepareStatement("DELETE FROM " + tableName + " WHERE id = ?;");
	            deleteStatement.setInt(1, id);
	            deleteStatement.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            log.info("projectDao :Could not delete project from table");
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 public boolean update(Project project) {

	        log.info("Update Project");
	        try {
	            PreparedStatement updateStatement = connection.prepareStatement("UPDATE " + tableName
	                    + " (id, p_name, start, end, manager_id, status_id) VALUES (?, ?, ?, ?);");
	            updateStatement.setInt(1, project.id);
	            updateStatement.setString(2, project.name);
	            updateStatement.setString(3, project.start);
	            updateStatement.setString(4, project.end);
	            updateStatement.setInt(4, project.manager_id);
	            updateStatement.setInt(4, project.status_id);
	            updateStatement.executeUpdate();
	            return true;

	        } catch (SQLException e) {
	            log.info("ProjectDao :Could not insert Project into table");
	            e.printStackTrace();
	            return false;
	        }

	    }
}
