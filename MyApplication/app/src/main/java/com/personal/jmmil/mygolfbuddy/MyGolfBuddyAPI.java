package com.personal.jmmil.mygolfbuddy;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.google.gson.Gson;

/**
 * Created by jmmil on 12/22/2015.
 */
public class MyGolfBuddyAPI {

    private static final String BASE_URL = "http://10.57.78.100/android_connect/";
    HttpURLConnection urlConnection = null;


    public ArrayList<Course> searchCourse(String courseName){
        String url = BASE_URL + "search_course.php?search=" + courseName;
        //ArrayList<Course> data = getInternetData(url);
        try {
            ArrayList<Course> data = new getInternetData().execute(url).get();
            return data;
        } catch(ExecutionException e){

        } catch(InterruptedException e){

        }

        return null;
    }

    public ArrayList<Course> getCourseList(){
        String url = BASE_URL + "get_course_list.php";
        //ArrayList<Course> data = getInternetData(url);
        try {
            ArrayList<Course> data = new getInternetData().execute(url).get();
            return data;
        } catch(ExecutionException e){

        } catch(InterruptedException e){

        }

        return null;
    }

   /*
    public ArrayList<Course> getInternetData(String theUrl){
       BufferedReader reader = null;
       ArrayList<Course> data = null;
       InputStream is = null;

       try{
           Log.v("TheURL",theUrl);
           URL url = new URL(theUrl);
           urlConnection = (HttpURLConnection) url.openConnection();
           urlConnection.connect();
           is = urlConnection.getInputStream();
           CourseToObj cto = new CourseToObj();
           data = cto.parseresponse(is);
           return data;
       }catch(IOException e) {
           Log.v("IOException", e.getMessage());
       }

       return data;
   }
   */


    private class getInternetData extends AsyncTask<String, Integer, ArrayList<Course>>{

        BufferedReader reader = null;
        ArrayList<Course> data = null;
        InputStream is = null;

        protected ArrayList<Course> doInBackground(String... params) {

            String theUrl = params[0];

            try{
                Log.v("TheURL",theUrl);
                URL url = new URL(theUrl);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                is = urlConnection.getInputStream();
                CourseToObj cto = new CourseToObj();
                data = cto.parseresponse(is);
                return data;
            }catch(IOException e) {
                Log.v("IOException", e.getMessage());
            }

            return data;
        }
    }
}


