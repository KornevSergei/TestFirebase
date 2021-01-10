package com.example.testfirebase;


//класс для хранения данных о пользователях
public class User {

    public String id;
    public String name;
    public String secondName;
    public String email;


    public User() {
    }

    public User(String id, String name, String secondName, String email) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
