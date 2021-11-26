package com.example.viewsdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Logger;

import com.example.productivize.App;
import com.example.tabledao.DatabaseConnector;

public class Worklog_view {
	
//	public int id;
//	public int employee_id;
//	public Timestamp time; 
//	public String work_done;
//	public int task_id;
//	public String t_name;
//	public int project_id;
//	public String p_name;
//        public Worklog_view(int id, int employee_id,Timestamp time, String  work_done, int task_id, String t_name, int project_id, String p_name){
//        	this.id = id;
//        	this.employee_id = employee_id;
//        	this.time = time;
//        	this.work_done = work_done;
//        	this.task_id = task_id;
//        	this.t_name = t_name;
//        	this.project_id = project_id;
//        	this.p_name=  p_name;
//        	
//        	
//        }
        private String viewName;
        private Connection connection=DatabaseConnector.getConnection();
        private static final Logger log;

        static {
            System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
            log=Logger.getLogger(App.class.getName());
        }

        public Worklog_view() {
            super();
            this.viewName="worklog_view";
        }
        
        public ResultSet getWorklogsOfEmployee(int employee_id)
        {  
            log.info("WorklogViewDao : Querying tasks for project Id : "+employee_id);
            PreparedStatement readStatement;
            try {
                readStatement = connection.prepareStatement("SELECT time,work_done,t_name,p_name FROM "+viewName+" WHERE employee_id = ? ORDER BY time");
                readStatement.setInt(1,employee_id);
                ResultSet resultSet = readStatement.executeQuery();//execute the select query

                if (!resultSet.next()) {//if the resultSet is empty return null
                    log.info("WorklogViewDao : No Matching Data found in View");
                    return null;
                }
                else{ //return resultSet containing data     
                log.info("WorklogViewDao : Data found in View");
                return resultSet;
                }

            } catch (SQLException e) {//throw exception when database error occurs
                log.info("WorklogViewDao : Could not read from worklog_view");
                e.printStackTrace();
                return null;
            } 
        	
        } 
        
}
