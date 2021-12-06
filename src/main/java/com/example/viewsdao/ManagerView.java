package com.example.viewsdao;

import com.example.productivize.App;
import com.example.tabledao.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ManagerView {

    private String viewName;
    private String tableName;
    private Connection connection = DatabaseConnector.getConnection();
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log = Logger.getLogger(App.class.getName());
    }

    public ManagerView() {
        super();
        this.viewName = "manager_view";
        this.tableName = "task_status";
    }

    public ResultSet getTasksofProject(int project_id) {
        log.info("ManagerViewDao : Querying tasks for project Id : " + project_id);
        PreparedStatement readStatement;
        try {
            readStatement = connection
                    .prepareStatement(
                            "SELECT employee_id,CONCAT(first_name,' ',last_name),t_id,t_name,m_name,task_status.status  FROM " + viewName
                                    + ", " + tableName +" WHERE project_id = ? AND task_status.id = status_id;",
                            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            readStatement.setInt(1, project_id);
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
