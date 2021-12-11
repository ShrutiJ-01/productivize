package com.example.viewsdao;

import com.example.productivize.App;
import com.example.tabledao.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class EmployeeTaskView {

    private String viewName;
    private int statusTodo = 1;
    private int statusDoing = 2;
    private int statusCompleted = 3;

    private Connection connection = DatabaseConnector.getConnection();
    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log = Logger.getLogger(App.class.getName());
    }

    public EmployeeTaskView() {
        super();
        this.viewName = "employee_tasks_view";
    }

    //This function returns all the tasks of an employee of status "To Do" i.e task_status=1
    public ResultSet getTodoTasks(int employee_id) {
        try {
            PreparedStatement todoTasks = connection.prepareStatement("select task_id,task_name,ms_id,milestone_name,project_name from "
                    + viewName + " WHERE employee_id = ? AND task_status = " + statusTodo + ";",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            todoTasks.setInt(1, employee_id);
            ResultSet todoTasksResult = todoTasks.executeQuery();
            if (!todoTasksResult.next()) {// if the resultSet is empty return null
                log.info("EmployeeTasksViewDao : No Matching Data found in View");
                return null;
            } else { // return resultSet containing data
                log.info("EmployeeTasksViewDao : Data found in View");
                return todoTasksResult;
            }
        }

        catch (SQLException e) {
            log.info("Employee_tasks_view: Could not read from Employee_tasks_view");
            e.printStackTrace();
            return null;
        }

    }

    //This function returns all the tasks of an employee of status "Doing" i.e task_status=2
    public ResultSet getDoingTasks(int employee_id) { 
        try {
            PreparedStatement doingTasks = connection.prepareStatement("select task_id,task_name,ms_id,milestone_name,project_name from "
                    + viewName + " WHERE employee_id = ? AND task_status = " + statusDoing + ";",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            doingTasks.setInt(1, employee_id);
            ResultSet doingTasksResult = doingTasks.executeQuery();
            if (!doingTasksResult.next()) {// if the resultSet is empty return null
                log.info("EmployeeTasksViewDao : No Matching Data found in View");
                return null;
            } else { // return resultSet containing data
                log.info("EmployeeTasksViewDao : Data found in View");
                return doingTasksResult;
            }
        }

        catch (SQLException e) {
            log.info("Employee_tasks_view: Could not read from Employee_tasks_view");
            e.printStackTrace();
            return null;
        }

    }

    //This function returns all the tasks of an employee of status "Completed" i.e task_status=3
    public ResultSet getCompletedTasks(int employee_id) {
        try {
            PreparedStatement completedTasks = connection.prepareStatement("select task_id,task_name,ms_id,milestone_name,project_name from "
                    + viewName + " WHERE employee_id = ? AND task_status = " + statusCompleted + ";",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            completedTasks.setInt(1, employee_id);
            ResultSet completedTasksresult = completedTasks.executeQuery();
            if (!completedTasksresult.next()) {// if the resultSet is empty return null
                log.info("EmployeeTasksViewDao : No Matching Data found in View");
                return null;
            } else { // return resultSet containing data
                log.info("EmployeeTasksViewDao : Data found in View");
                return completedTasksresult;
            }
        }

        catch (SQLException e) {
            log.info("Employee_tasks_view: Could not read from Employee_tasks_view");
            e.printStackTrace();
            return null;
        }

    }

    //This function returns all the tasks of an employee of given status and projectId
    public ResultSet getCustomProjects(int employee_id, int status_id, int project_id) { 
        try {
            PreparedStatement customProjects = connection.prepareStatement("select t_name,t_id,m_name,p_name from "
                    + viewName + " WHERE e_id = ? AND status_id = ? AND id = ?;", ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            customProjects.setInt(1, employee_id);
            customProjects.setInt(1, status_id);
            customProjects.setInt(1, project_id);
            ResultSet customProjectsResult = customProjects.executeQuery();
            if (!customProjectsResult.next()) {// if the resultSet is empty return null
                log.info("EmployeeTasksViewDao : No Matching Data found in View");
                return null;
            } else { // return resultSet containing data
                log.info("EmployeeTasksViewDao : Data found in View");
                return customProjectsResult;
            }
        }

        catch (SQLException e) {
            log.info("Employee_tasks_view: Could not read from Employee_tasks_view");
            e.printStackTrace();
            return null;
        }

    }

}
