package com.example;

public class Project {
	public int id;
	public String name;
	public String start;
	public String end;
	public int manager_id;
	public int status_id;
        public Project(int id, String name, String start, String end,int manager_id,int status_id){
        	this.id=id;
            this.name=name;
            this.start=start;
            this.end=end;
            this.manager_id = manager_id;
            this.status_id = status_id;
        }
}