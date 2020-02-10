package com.bernard;

public class User {
    private String name;
    private String email;
    private String userType;
    private int level;

    //empty constructor
    public User(){}

    //constructor accepting arguments
    public User(String name, String email, String userType, int level) {
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.level = level;
    }

    //setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setUserType(String userType) { this.userType = userType; }
    public void setLevel(int level) { this.level = level; }

    //getters
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getUserType(){
        return userType;
    }
    public int getLevel(){ return level; }

    //To override the toString() method
    public String toString(){
        return name+" "+email+" "+userType+" ";
    }

    public void borrowBook(){}
    public void returnBook(){}
}
