package com.example.apple.processfile;

import java.io.Serializable;

/**
 * Created by apple on 15-01-07.
 */
public class People implements Serializable{
    String name;
    int age;
    String food;
    People(String name,int age,String food){
        this.name = name;
        this.age = age;
        this.food = food;
    }
    public String getName(){
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getFood(){
        return this.food;
    }
}
