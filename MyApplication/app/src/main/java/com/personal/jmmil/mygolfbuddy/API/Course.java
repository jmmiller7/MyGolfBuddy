package com.personal.jmmil.mygolfbuddy.API;

public class Course {
    int course_id;
    String course_name;
    String street;
    String course_city;
    String course_state;
    String course_zip;
    String course_numholes;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCourse_city() {
        return course_city;
    }

    public void setCourse_city(String course_city) {
        this.course_city = course_city;
    }

    public String getCourse_state() {
        return course_state;
    }

    public void setCourse_state(String course_state) {
        this.course_state = course_state;
    }

    public String getCourse_zip() {
        return course_zip;
    }

    public void setCourse_zip(String course_zip) {
        this.course_zip = course_zip;
    }

    public String getCourse_numholes() {
        return course_numholes;
    }

    public void setCourse_numholes(String course_numholes) {
        this.course_numholes = course_numholes;
    }

    public String toString(){
        return course_id + " - " + course_name;
    }


}