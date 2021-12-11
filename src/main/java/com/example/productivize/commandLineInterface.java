package com.example.productivize;

import java.sql.ResultSet;
import java.util.logging.Logger;

import com.example.entites.Employee;
import com.example.entites.Manager;
import com.example.entites.Milestone;
import com.example.entites.Project;
import com.example.entites.Task;
import com.example.entites.Worklog;
import com.example.tabledao.Authenticate;
import com.example.tabledao.EmployeeDao;
import com.example.tabledao.MilestonesDao;
import com.example.tabledao.ProjectDao;
import com.example.tabledao.TaskDao;
import com.example.tabledao.WorklogDao;
import com.example.viewsdao.EmployeeTaskView;
import com.example.viewsdao.ManagerTaskView;
import com.example.viewsdao.EmployeeWorklogView;

public class commandLineInterface {

    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log =Logger.getLogger(App.class.getName());
    }

    public static void main(String[] args) throws Exception {
        boolean result;
        ResultSet queryResultSet;

        log.info("---------------------------------------------------------");
        log.info("AUTHENTICATE.JAVA ");       
        Authenticate authenticate=new Authenticate();
        Employee emp=authenticate.registerEmployee("singleton", "pattern", "new");
        log.info("Id of the registration " + emp.id);
        log.info("LOGIN FOR EMPLOYEE");
        Employee emp2=authenticate.loginEmployee(emp.id, "new");
        log.info("employee logged in is : "+emp2.first_name+" "+emp2.last_name);

        // Manager manager1=authenticate.registerManager("singleton", "pattern", "new");
        // log.info("Id of the registration " + manager1.id);
        // log.info("LOGIN FOR MANAGER");
        // Manager manager2=authenticate.loginManager(manager1.id, "new");
        // log.info("manager logged in is : "+manager2.first_name+" "+manager2.last_name);


        log.info("---------------------------------------------------------");
        log.info("EMPLOYEEDAO.JAVA ");   
        Employee employee=new Employee(emp2.id,"update","successfull",true);
        EmployeeDao employeeDao=new EmployeeDao();
        result=employeeDao.update(employee);  
        log.info("Update succesful ? : "+result); 
        boolean res=employeeDao.delete(employee.id);
        log.info("Delete succesful ? : "+res);

        // log.info("---------------------------------------------------------");
        // log.info("PROJECTSDAO.JAVA ");   
        // Project project=new Project("kijugo", "05/11/21","08/11/21", manager1.id, 1);
        // ProjectDao projectDao=new ProjectDao();
        // result= projectDao.insert(project);
        // log.info("Insert succesful ? : "+result);
        // result=projectDao.update(project);
        // log.info("Update succesful ? : "+result); 
        // result=projectDao.delete(project.id);
        // log.info("Delete succesful ? : "+result);
        // log.info("Querying ongoing projects for manager_id 997 | Entries expected : 1 ");
        // queryResultSet=projectDao.getOngoingProjectsForManager(997);
        // log.info("Entries found :  "+queryResultSet.getRow());
        // log.info("Querying blocked projects for manager_id 12 | Entries expected : 1 ");
        // queryResultSet=projectDao.getBlockedProjectsForManager(207);
        // log.info("Entries found :  "+queryResultSet.getRow());
        // log.info("Querying completed projects for manager_id 12 | Entries expected : 1 ");
        // queryResultSet=projectDao.getCompletedProjectsForManager(207);
        // log.info("Entries found :  "+queryResultSet.getRow());

        // log.info("---------------------------------------------------------");
        // log.info("MILESTONESDAO.JAVA ");   
        // Milestone milestone=new Milestone("Release Build", "09/09/21", "create release build", 500, 2);
        // MilestonesDao milestoneDao=new MilestonesDao();
        // result= milestoneDao.insert(milestone);
        // log.info("Insert succesful ? : "+result);
        // milestone.name="updated name of milestone";
        // result=milestoneDao.update(milestone);
        // log.info("Update succesful ? : "+result); 
        // result=milestoneDao.delete(milestone.id);
        // log.info("Delete succesful ? : "+result);
        // log.info("Querying Milestones for project_id 500 | Entries expected : 2 ");
        // queryResultSet= milestoneDao.getMilestonesForProject(500);
        // queryResultSet.last();
        // log.info("Entries found :  "+queryResultSet.getRow());


        // log.info("---------------------------------------------------------");
        // log.info("TASKSDAO.JAVA ");   
        // Task task=new Task("check employee dao", 180, 2, 301);
        // TaskDao taskDao=new TaskDao();
        // result=taskDao.insert(task);
        // log.info("Insert succesful ? : "+result); 
        // task.name="updated task name";
        // result=taskDao.update(task);  
        // log.info("Update succesful ? : "+result); 
        // result=taskDao.delete(task.id);
        // log.info("Delete succesful ? : "+result);

        // log.info("---------------------------------------------------------");
        // log.info("WORKLOGDAO.JAVA ");   
        // Worklog worklog=new Worklog(71,"new worklog created");
        // WorklogDao worklogDao=new WorklogDao();
        // result= worklogDao.insert(worklog);
        // log.info("Insert succesful ? : "+result);
        // worklog.work_done="updated worklog";
        // result=worklogDao.update(worklog);
        // log.info("Update succesful ? : "+result); 
        // result=worklogDao.delete(worklog.id);
        // log.info("Delete succesful ? : "+result);

        log.info("---------------------------------------------------------");
        log.info("MANAGER_VIEW.JAVA ");   
        ManagerTaskView manager_view= new ManagerTaskView();
        ResultSet resultSet=manager_view.getTasksforMilestone(301);
        log.info(resultSet.getString("task_name"));
        while (resultSet.next()) {
            log.info(resultSet.getString("task_name"));
        }
        log.info("---------------------------------------------------------");

        // log.info("---------------------------------------------------------");
        // log.info("EMPLOYEE_TASKS_VIEW.JAVA ");   
        // EmployeeTaskView employee_task_view= new EmployeeTaskView();
        // queryResultSet=employee_task_view.getCompletedTasks(180);
        
        // log.info(queryResultSet.getString("task_name"));
        // while (queryResultSet.next()) {
        //     log.info(queryResultSet.getString("task_name"));
        // }
        // log.info("---------------------------------------------------------");
 
        // log.info("---------------------------------------------------------");
        // log.info("WORKLOG_VIEW.JAVA ");   
        // EmployeeWorklogView worklog_view= new EmployeeWorklogView();
        // ResultSet worklogResult=worklog_view.getWorklogsForTask(72);
        
        // log.info(worklogResult.getString("project_name"));
        // while (worklogResult.next()) {
        //     log.info(worklogResult.getString("project_name"));
        // }
        // log.info("---------------------------------------------------------");




    }
    
}
