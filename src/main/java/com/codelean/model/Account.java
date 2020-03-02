package com.codelean.model;

public class Account {
    private String fullname;
    private String password;

    public Account() {
    }

    public Account( String fullname, String password) {
        this.fullname = fullname;
        this.password = password;
    }
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}

