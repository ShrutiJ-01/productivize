package com.example.tabledao;

import java.util.logging.*;

import com.example.entites.Milestone;
import com.example.productivize.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MilestonesDao{
	private String tableName;
	private Connection connection=DatabaseConnector.getConnection();
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log=Logger.getLogger(App.class.getName());
    }
	
	public MilestonesDao() {
		super();
		this.tableName="milestones";
		
	}
	
	public boolean insert(Milestone milestone) {
		
		log.info("Insert new milestone");
		try {
			PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO " + tableName 
					+ " (id, m_name, due_date, deliverables, project_id, status_id) VALUES (?,?,?,?,?,?);");
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
			PreparedStatement deleteStatement= connection.prepareStatement("DELETE FROM "+tableName+" WHERE id = ?;");
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
			PreparedStatement updateStatement= connection.prepareStatement("UPDATE " + tableName 
					+ " SET m_name = ?, due_date = ?, deliverables = ?, project_id = ?,status_id = ? WHERE id = ?;");
			updateStatement.setString(1, milestone.name);
			updateStatement.setString(2, milestone.due_date);
			updateStatement.setString(3, milestone.deliverables);
			updateStatement.setInt(4, milestone.project_id);
			updateStatement.setInt(5, milestone.status_id);
			updateStatement.setInt(6, milestone.id);
			updateStatement.executeUpdate();
			return true;
		}catch(SQLException e){
			log.info("MIlestonesDao :Could not update the milestone table");
			e.printStackTrace();
			return false;
		}
	} 

	public ResultSet getMilestonesForProject(int project_id)
	{  
		log.info("MilestonesDao : Querying milestones for project Id :  "+project_id);
		PreparedStatement readStatement;
		try {
			readStatement = connection.prepareStatement("SELECT milestones.m_name,milestones.id,milestones.due_date,milestones.deliverables,ms_status.status FROM milestones,ms_status WHERE milestones.project_id = ? AND milestones.status_id=ms_status.id;");
			readStatement.setInt(1,project_id);
			ResultSet resultSet = readStatement.executeQuery();//execute the select query

			if (!resultSet.next()) {//if the resultSet is empty return null
				log.info("MilestonesDao : No Matching Data found in table");
				return null;
			}
			else{ //return resultSet containing data     
			log.info("MilestonesDao : Data found in table");
			return resultSet;
			}

		} catch (SQLException e) {//throw exception when database error occurs
			log.info("MilestonesDao : Could not read from table");
			e.printStackTrace();
			return null;
		}
		
	}

}
