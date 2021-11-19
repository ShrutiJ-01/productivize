package com.example;

public class Manager {
    public int id;
    public String first_name;
    public String last_name;
    private String password;
    
    public Manager(int id, String first_name, String last_name, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }    

}
