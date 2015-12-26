package com.personal.jmmil.mygolfbuddy;

public class Course {
    int course_id;
    String course_name;
    String street;

    public String toString(){
        return course_id + " - " + course_name;
    }
}