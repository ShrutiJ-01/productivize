package com.example.entites;

public class Employee {
    public int id;
    public String first_name;
    public String last_name;
    public boolean login_status;
    private String password;

    //default constructor
    //login_status initialized as false
    public Employee() {
        id=0;
        first_name="";
        last_name="";
        login_status=false;
    }

    //parameterized constructor
    public Employee(int id, String first_name, String last_name,boolean login_status) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.login_status = login_status;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        
        this.password = password;
    }

    

}
