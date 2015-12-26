package com.personal.jmmil.mygolfbuddy;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class CourseToObj {

    public static ArrayList<Course> parseresponse(InputStream response)throws IOException{
        try(Reader reader = new InputStreamReader(response, "UTF-8")){
            Gson gson = new GsonBuilder().create();
            Response p = gson.fromJson(reader, Response.class);


            ArrayList<Course> courses = p.getDocs();

            return courses;
        }
    }
}
