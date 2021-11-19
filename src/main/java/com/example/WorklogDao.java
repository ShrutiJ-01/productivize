package com.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorklogDao extends DatabaseConnector {

    // This class contains all database operations on the "worklogs" table in the
    // database.
    // It will contain methods to insert update, delete and query the worklogs from
    // the database.

    private String tableName;

    public WorklogDao() {
        // constructor
        super();
        tableName = "worklogs";
    }

    // This function inserts worklogs into table.
    // It takes a Worklog object as an argument.
    public boolean insert(Worklog worklog) {

        log.info("Insert worklog");
        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO " + tableName
                    + " (id, timestamp, work_done, task_id, employee_id, project_id) VALUES (?, ?, ?, ?, ?, ?);");
            insertStatement.setInt(1, worklog.id);
            insertStatement.setString(2, worklog.timestamp);
            insertStatement.setString(3, worklog.work_done);
            insertStatement.setInt(4, worklog.task_id);
            insertStatement.setInt(5, worklog.employee_id);
            insertStatement.setInt(6, worklog.project_id);
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
                    + " SET timestamp = ?, work_done = ?, task_id = ?, employee_id = ?, project_id= ? WHERE id = ?;");
            updateStatement.setString(1, worklog.timestamp);
            updateStatement.setString(2, worklog.work_done);
            updateStatement.setInt(3, worklog.task_id);
            updateStatement.setInt(4, worklog.employee_id);
            updateStatement.setInt(5, worklog.project_id);
            updateStatement.setInt(6, worklog.id);
            updateStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            log.info("WorklogDao : Could not update worklog in table");
            e.printStackTrace();
            return false;
        }

    }
}
