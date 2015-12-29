package com.personal.jmmil.mygolfbuddy.API;

import java.util.ArrayList;

public class Response {
    //private String numFound;
    private ArrayList<Course> courses;

    @Override
    public String toString() {
        return courses.toString();
    }
    public ArrayList getDocs(){
        return courses;
    }
}
