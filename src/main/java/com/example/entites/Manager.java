package com.example.entites;

public class Manager {
    public int id;
    public String first_name;
    public String last_name;
    private String password;
    public boolean login_status;
    //parameterized constructor
    public Manager(int id, String first_name, String last_name, boolean login_status) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.login_status = login_status;
    }
    
    //default constructor
    //login_status initialized as false
    public Manager() {
        id=0;
        first_name="";
        last_name = "";
        login_status=false;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }    

}
