package com.personal.jmmil.mygolfbuddy.API;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.personal.jmmil.mygolfbuddy.API.DatabaseObjects.Course;

public class CourseToObj {

    public ArrayList<Course> parseresponse(InputStream response)throws IOException{

        try{
            Reader reader = new InputStreamReader(response, "UTF-8");

            Gson gson = new GsonBuilder().create();

            CourseResponse p = gson.fromJson(reader, CourseResponse.class);

            ArrayList<Course> courses = p.getDocs();

            return courses;
        } catch(IOException e){
            // do nothing
        }

        return null;
    }
}
