package com.example.penn.attemptone;

/**
 * Created by Penn on 10/7/2017.
 */

public class User {
    private String username;
    private String password;
    private Employee id;

    public User(String u, String p) {
        username = u;
        password = p;
        //TODO: replace this with actually loading in employee data
        id = new Employee("First","Last",u,p,Employee.RANK.ALL);
    }

    public Employee getID() {
        return id;
    }

    public void clearID() {
        id = null;
    }
}
