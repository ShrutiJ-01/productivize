package com.example.entites;

public class Task 

{

	public int id;
	public String name;
	public int employee_id;
	public int status_id;
    public int ms_id;

    public Task(String name, int employee_id, int status_id, int ms_id)

    {
    	this.name = name;
    	this.employee_id = employee_id;
    	this.status_id = status_id;
    	this.ms_id = ms_id;
    }
	public Task(int id,String name, int employee_id, int status_id, int ms_id)

    {
    	this.id=id;
		this.name = name;
    	this.employee_id = employee_id;
    	this.status_id = status_id;
    	this.ms_id = ms_id;
    }

}