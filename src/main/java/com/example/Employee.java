package com.example;

public class Employee {
    public int id;
    public String first_name;
    public String last_name;
    private String password;
    public Employee(int id, String first_name, String last_name, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.setPassword(password);
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        
        this.password = password;
    }

    

}
