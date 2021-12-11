package com.example.viewsdao;

import com.example.productivize.App;
import com.example.tabledao.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ManagerTaskView {

    private String viewName;
    private Connection connection = DatabaseConnector.getConnection();
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log = Logger.getLogger(App.class.getName());
    }

    public ManagerTaskView() {
        super();
        this.viewName = "manager_task_view";
    }

    public ResultSet getTasksforMilestone(int milestone_id) {
        log.info("ManagerViewDao : Querying tasks for milestone Id : " + milestone_id);
        PreparedStatement readStatement;
        try {
            readStatement = connection
                    .prepareStatement(
                            "SELECT employee_id,CONCAT(first_name,' ',last_name),task_id,task_name,status_id  FROM " + viewName
                                    + " WHERE ms_id = ?;",
                            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            readStatement.setInt(1, milestone_id);
            ResultSet resultSet = readStatement.executeQuery();// execute the select query

            if (!resultSet.next()) {// if the resultSet is empty return null
                log.info("ManagerViewDao : No Matching Data found in View");
                return null;
            } else { // return resultSet containing data
                log.info("ManagerViewDao : Data found in View");
                return resultSet;
            }

        } catch (SQLException e) {// throw exception when database error occurs
            log.info("ManagerViewDao : Could not read from manager_view");
            e.printStackTrace();
            return null;
        }

    }
}
