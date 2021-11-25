package com.example.tabledao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.example.entites.Worklog;
import com.example.productivize.App;

public class WorklogDao{

    // This class contains all database operations on the "worklogs" table in the
    // database.
    // It will contain methods to insert update, delete and query the worklogs from
    // the database.

    private String tableName;
    private Connection connection=DatabaseConnector.getConnection();
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log=Logger.getLogger(App.class.getName());
    }

    public WorklogDao() {
        tableName = "worklogs";
    }

    // This function inserts worklogs into table.
    // It takes a Worklog object as an argument.
    public boolean insert(Worklog worklog) {

        log.info("Insert worklog");
        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO " + tableName
                    + " (id, work_done, task_id, employee_id, project_id) VALUES (?, ?, ?, ?, ?);");
            insertStatement.setInt(1, worklog.id);
            insertStatement.setString(2, worklog.work_done);
            insertStatement.setInt(3, worklog.task_id);
            insertStatement.setInt(4, worklog.employee_id);
            insertStatement.setInt(5, worklog.project_id);
            insertStatement.executeUpdate();
            return true;

        } catch (Exception e) {
            log.info("WorklogDao :Could not insert worklog into table");
            e.printStackTrace();
            return false;
        }

    }

    // This function deleted worklogs from table.
    // It takes the worklog id as an argument.
    public boolean delete(int id) {
        log.info("Delete Worklog");
        try {
            PreparedStatement deleteStatement = connection
                    .prepareStatement("DELETE FROM " + tableName + " WHERE id = ?;");
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            log.info("WorklogDao :Could not delete worklog from table");
            e.printStackTrace();
            return false;
        }
    }

    // This function updates worklogs in the table.
    // It takes a Worklog object as an argument.
    public boolean update(Worklog worklog) {
        log.info("Update data");
        try {
            PreparedStatement updateStatement = connection.prepareStatement("UPDATE " + tableName
                    + " SET work_done = ?, task_id = ?, employee_id = ?, project_id= ? WHERE id = ?;");
            updateStatement.setString(1, worklog.work_done);
            updateStatement.setInt(2, worklog.task_id);
            updateStatement.setInt(3, worklog.employee_id);
            updateStatement.setInt(4, worklog.project_id);
            updateStatement.setInt(5, worklog.id);
            updateStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            log.info("WorklogDao : Could not update worklog in table");
            e.printStackTrace();
            return false;
        }

    }
}