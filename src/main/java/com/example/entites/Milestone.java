package com.example.entites;

public class Milestone {
	
	public int id;
	public String name;
	public String due_date;
	public String deliverables;
	public int project_id;
	public int status_id;
		public Milestone(int id, String name, String due_date, String deliverables, int project_id, int status_id) {
			this.id=id;
			this.name=name;
			this.due_date=due_date;
			this.deliverables=deliverables;
			this.project_id=project_id;
			this.status_id=status_id;
		}

}
