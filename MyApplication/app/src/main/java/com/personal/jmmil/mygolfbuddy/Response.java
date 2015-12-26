package com.personal.jmmil.mygolfbuddy;

import java.util.ArrayList;

public class Response {
    //private String numFound;
    private ArrayList<Course> products;

    @Override
    public String toString() {
        return products.toString();
    }
    public ArrayList getDocs(){
        return products;
    }
}
