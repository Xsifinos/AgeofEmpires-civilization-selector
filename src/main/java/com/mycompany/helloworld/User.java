package com.mycompany.helloworld;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author syggouroglou@gmail.com
 */
public class User {

    private String name;

    private String username;

    public User() {
    }

    public User(String name, String username) {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "(Name):" + this.name + " " + "(Username):" + this.username;
    }
}
