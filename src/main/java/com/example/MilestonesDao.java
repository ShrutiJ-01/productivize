package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdk.internal.org.jline.utils.Log;

public class MilestonesDao extends DatabaseConnector{
	private String tableName;
	
	public MilestonesDao() {
		super();
		this.tableName="Milestones";
		
	}
	
	public boolean insert(Milestone milestone) {
		
		log.info("Insert new milestone");
		try {
			PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO " + tableName 
					+ " (id, name, due_date, deliverables, project_id, status_id) VALUES (?,?,?,?,?,?);");
			insertStatement.setInt(1, milestone.id);
			insertStatement.setString(2, milestone.name);
			insertStatement.setString(3, milestone.due_date);
			insertStatement.setString(4, milestone.deliverables);
			insertStatement.setInt(5, milestone.project_id);
			insertStatement.setInt(6, milestone.status_id);
			insertStatement.executeUpdate();
			return true;
			
		}catch (SQLException e) {
			log.info("MilestonesDao :Could not insert the milestone into table");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean delete(int id) {
		log.info("Delete Milestone");
		try {
			PreparedStaement deleteStatement= connection.prepareStatement("DELETE FROM "+ "WHERE id = ?,");
			deleteStatement.setInt(1, id);
			deleteStatement.executeUpdate();
			return true;
		}catch (SQLException e) {
			log.info("MilestonesDao : Could not delete milestone from table");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Milestone milestone) {
		log.info("Update Milestone");
		try {
			PreparedStatement updateStatement= connection.prepareStatement("UPDATE" + tablename 
					+ "(id,name.dueDate,deliverables,project_id,status_id) VALUES(?,?,?,?,?,?);");
			updateStatement.setInt(1, milestone.id);
			updateStatement.setString(2, milestone.name);
			updateStatement.setString(3, milestone.due_date);
			updateStatement.setString(4, milestone.deliverables);
			updateStatement.setInt(5, milestone.project_id);
			updateStatement.setInt(6, milestone.status_id);
			updateStatement.executeUpdate();
			return true;
		}catch(SQLException e){
			Log.info("MIlestonesDao :Could not update the milestone table");
			
		}
	}
	
	
	
	
	
	
	 

}
