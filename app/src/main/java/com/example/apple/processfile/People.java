package com.example.apple.processfile;

/**
 * Created by apple on 15-01-07.
 */
public class People {
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
