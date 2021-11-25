package com.example.productivize;
import com.example.entites.Employee;
import com.example.tabledao.Authenticate;
import java.util.logging.Logger;

//Starting point of our application

public final class App {

    private static final Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log =Logger.getLogger(App.class.getName());
    }

    public static void main(String[] args) throws Exception {
        
        Authenticate authenticate=new Authenticate();
        Employee emp=authenticate.registerEmployee("singleton", "pattern", "new");
        log.info("Id of the registration sucessful? " + emp.id);
        log.info("check login for emplyee");
        Employee emp2=authenticate.loginEmployee(emp.id, "new");
        log.info("employee logged in is : "+emp2.first_name+" "+emp2.last_name);
    }

}
