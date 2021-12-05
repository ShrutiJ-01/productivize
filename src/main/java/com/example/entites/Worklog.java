package com.example.entites;

import java.sql.Timestamp;

public class Worklog {

    // entity class modelled after worklog.
    // it is used to wrap the incoming tuples from database table into Worklog
    // objects.
    public int id;
    public int task_id;
    public int project_id;
    public String work_done;
    public Timestamp timestamp;
    public int employee_id;

    public Worklog(int task_id, int project_id, String work_done,int employee_id) {
        this.task_id = task_id;
        this.project_id = project_id;
        this.work_done = work_done;
        this.employee_id = employee_id;
    }
    public Worklog(int id,int task_id, int project_id, String work_done,int employee_id) {
        this.id=id;
        this.task_id = task_id;
        this.project_id = project_id;
        this.work_done = work_done;
        this.employee_id = employee_id;
    }

}
