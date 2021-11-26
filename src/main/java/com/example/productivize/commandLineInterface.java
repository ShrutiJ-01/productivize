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
import com.example.viewsdao.Employee_task_view;
import com.example.viewsdao.Manager_view;
import com.example.viewsdao.Worklog_view;

public class commandLineInterface {

    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log =Logger.getLogger(App.class.getName());
    }

    public static void main(String[] args) throws Exception {
        boolean result;

        log.info("---------------------------------------------------------");
        log.info("AUTHENTICATE.JAVA ");       
        Authenticate authenticate=new Authenticate();
        Employee emp=authenticate.registerEmployee("singleton", "pattern", "new");
        log.info("Id of the registration " + emp.id);
        log.info("LOGIN FOR EMPLOYEE");
        Employee emp2=authenticate.loginEmployee(emp.id, "new");
        log.info("employee logged in is : "+emp2.first_name+" "+emp2.last_name);

        Manager manager1=authenticate.registerManager("singleton", "pattern", "new");
        log.info("Id of the registration " + manager1.id);
        log.info("LOGIN FOR MANAGER");
        Manager manager2=authenticate.loginManager(manager1.id, "new");
        log.info("manager logged in is : "+manager2.first_name+" "+manager2.last_name);


        log.info("---------------------------------------------------------");
        log.info("EMPLOYEEDAO.JAVA ");   
        Employee employee=new Employee(emp2.id,"update","successfull",true);
        EmployeeDao employeeDao=new EmployeeDao();
        result=employeeDao.update(employee);  
        log.info("Update succesful ? : "+result); 
        boolean res=employeeDao.delete(employee.id);
        log.info("Delete succesful ? : "+res);

        log.info("---------------------------------------------------------");
        log.info("TASKSDAO.JAVA ");   
        Task task=new Task(71, "check employee dao", 108, 402, 301, 11);
        TaskDao taskDao=new TaskDao();
        result=taskDao.update(task);  
        log.info("Update succesful ? : "+result); 
        result=employeeDao.delete(task.id);
        log.info("Delete succesful ? : "+result);

        log.info("---------------------------------------------------------");
        log.info("PROJECTSDAO.JAVA ");   
        Project project=new Project(11, "kijugo", "05/11/21","08/11/21", 207, 997);
        ProjectDao projectDao=new ProjectDao();
        result=projectDao.update(project);
        log.info("Update succesful ? : "+result); 
        result= projectDao.insert(new Project(8765, "new project", "some start", "some end", 207, 997));
        log.info("Insert succesful ? : "+result);
        result=projectDao.delete(8765);
        log.info("Delete succesful ? : "+result);

        log.info("---------------------------------------------------------");
        log.info("MILESTONESDAO.JAVA ");   
        Milestone milestone=new Milestone(301, "Release Build", "09/09/21", "create release build", 11, 52);
        MilestonesDao milestoneDao=new MilestonesDao();
        result=milestoneDao.update(milestone);
        log.info("Update succesful ? : "+result); 
        result= milestoneDao.insert(new Milestone(352, "Debug Build", "09/09/21", "create release build", 11, 52));
        log.info("Insert succesful ? : "+result);
        result=milestoneDao.delete(352);
        log.info("Delete succesful ? : "+result);

        log.info("---------------------------------------------------------");
        log.info("WORKLOGDAO.JAVA ");   
        Worklog worklog=new Worklog(1, 71, 11, "new worklog created", 108);
        WorklogDao worklogDao=new WorklogDao();
        result=worklogDao.update(worklog);
        log.info("Update succesful ? : "+result); 
        result= worklogDao.insert(new Worklog(352, 71, 11, "new worklog created", 101));
        log.info("Insert succesful ? : "+result);
        result=worklogDao.delete(352);
        log.info("Delete succesful ? : "+result);

        log.info("---------------------------------------------------------");
        log.info("MANAGER_VIEW.JAVA ");   
        Manager_view manager_view= new Manager_view();
        ResultSet resultSet=manager_view.getTasksofProject(11);
        result=worklogDao.delete(352);
        log.info(resultSet.getString("first_name"));
        while (resultSet.next()) {
            log.info(resultSet.getString("first_name"));
        }
        log.info("---------------------------------------------------------");

        log.info("---------------------------------------------------------");
        log.info("EMPLOYEE_TASKS_VIEW.JAVA ");   
        Employee_task_view employee_task_view= new Employee_task_view();
        ResultSet todoTasksResult=employee_task_view.getCompletedTasks(102);
        
        log.info(todoTasksResult.getString("t_name"));
        while (todoTasksResult.next()) {
            log.info(todoTasksResult.getString("t_name"));
        }
        log.info("---------------------------------------------------------");
 
        log.info("---------------------------------------------------------");
        log.info("WORKLOG_VIEW.JAVA ");   
        Worklog_view worklog_view= new Worklog_view();
        ResultSet worklogResult=worklog_view.getWorklogsOfEmployee(102);
        
        log.info(worklogResult.getString("p_name"));
        while (worklogResult.next()) {
            log.info(worklogResult.getString("p_name"));
        }
        log.info("---------------------------------------------------------");




    }
    
}
