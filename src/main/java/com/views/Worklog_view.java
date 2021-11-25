package com.views;

import java.sql.Timestamp;

public class Worklog_view {
	
	public int id;
	public int employee_id;
	public Timestamp time; 
	public String work_done;
	public int task_id;
	public String t_name;
	public int project_id;
	public String p_name;
        public Worklog_view(int id, int employee_id,Timestamp time, String  work_done, int task_id, String t_name, int project_id, String p_name){
        	this.id = id;
        	this.employee_id = employee_id;
        	this.time = time;
        	this.work_done = work_done;
        	this.task_id = task_id;
        	this.t_name = t_name;
        	this.project_id = project_id;
        	this.p_name=  p_name;
        	
        	
        }
}
