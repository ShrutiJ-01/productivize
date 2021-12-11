package com.example.entites;

import java.sql.Timestamp;

public class Worklog {

    // entity class modelled after worklog.
    // it is used to wrap the incoming tuples from database table into Worklog
    // objects.
    public int id;
    public int task_id;
    public String work_done;
    public Timestamp timestamp;

    public Worklog(int task_id, String work_done) {
        this.task_id = task_id;
        this.work_done = work_done;
    }
    public Worklog(int id,int task_id, String work_done) {
        this.id=id;
        this.task_id = task_id;
        this.work_done = work_done;
    }

}
