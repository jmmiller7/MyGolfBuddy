package com.personal.jmmil.mygolfbuddy.API;

import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class MyGolfBuddyAPI {

    //private static String BASE_URL = "http://10.57.78.100/mygolfbuddy/";
    private static String BASE_URL = "http://192.168.43.83:1234/mygolfbuddy/";

    HttpURLConnection urlConnection = null;


    public ArrayList<Course> searchCourse(String courseName){
        String url = BASE_URL + "search_course.php?search=" + courseName;

        try {
            ArrayList<Course> data = new getInternetData().execute(url).get();
            return data;
        } catch(ExecutionException e){
            Log.v("ExecutionException", e.getMessage());
        } catch(InterruptedException e){
            Log.v("InterruptedException", e.getMessage());
        }

        return null;
    }

    public ArrayList<Course> getCourseList(){
        String url = BASE_URL + "get_course_list.php";

        try {
            ArrayList<Course> data = new getInternetData().execute(url).get();
            return data;
        } catch(ExecutionException e){

        } catch(InterruptedException e){

        }

        return null;
    }



    public static void setBaseUrl(String addr){
        BASE_URL = "http://" + addr + "/mygolfbuddy/";
        Log.v("BaseURL",BASE_URL);
    }


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


