package com.example.tabledao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Logger;

import com.example.productivize.App;


public class WorksForDao {

    private String tableName;
	private Connection connection=DatabaseConnector.getConnection();
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log=Logger.getLogger(App.class.getName());
    }
	
	public WorksForDao() 
	{
        super();
        this.tableName="works_for";
        
    }
    	//inserts an employee and manager Id into the table
	public boolean insert(int employee_id, int manager_id){
		log.info("Inserting into employee manager relationship table");
			try 
			{
				PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO " + tableName
						+ " (employee_id, manager_id) VALUES (?, ?);");
				insertStatement.setInt(1, employee_id);
				insertStatement.setInt(2, manager_id);
				insertStatement.executeUpdate();
				return true;
			} 
            catch(SQLIntegrityConstraintViolationException e){
                log.info("WorksForDao : Manager employee relationship already exists");
                return true;
            }			
			catch (SQLException e) 
			{
				log.info("WorksForDao: Could not insert Task into the table");
				e.printStackTrace();
				return false;
			}

    }

    public ResultSet getEmployeesWorkingForManager(int manager_id){
        log.info("WorksForDao : Querying employees for manager Id : " + manager_id);
        PreparedStatement readStatement;
        try {
            readStatement = connection
                    .prepareStatement(
                            "SELECT works_for.employee_id,CONCAT(employees.first_name,' ',employees.last_name)  FROM " + tableName
                                    + ",employees WHERE manager_id = ? AND employees.e_id=works_for.employee_id;",
                            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            readStatement.setInt(1, manager_id);
            ResultSet resultSet = readStatement.executeQuery();// execute the select query

            if (!resultSet.next()) {// if the resultSet is empty return null
                log.info("WorksForDao : No Matching Data found in Table");
                return null;
            } else { // return resultSet containing data
                log.info("WorksForDao : Data found in Table");
                return resultSet;
            }

        } catch (SQLException e) {// throw exception when database error occurs
            log.info("WorksForDao : : Could not read from Table");
            e.printStackTrace();
            return null;
        }
    }


    
}
