package com.personal.jmmil.mygolfbuddy.API;

import android.os.AsyncTask;
import android.util.Log;
import com.personal.jmmil.mygolfbuddy.API.DatabaseObjects.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class MyGolfBuddyAPI {

    // private static String BASE_URL = "http://10.57.78.100/mygolfbuddy/";
    private static String BASE_URL = "http://192.168.43.83:1234/mygolfbuddy/";


    HttpURLConnection urlConnection = null;

    public ArrayList<Course> searchCourse(String courseName) {
        String url = BASE_URL + "search_course.php?search=" + courseName;

        try {
            ArrayList<?> data = new getInternetData(DbObj.Course).execute(url).get();
            return (ArrayList<Course>) data;

        } catch(ExecutionException e){
            Log.v("ExecutionException", e.getMessage());
        } catch(InterruptedException e){
            Log.v("InterruptedException", e.getMessage());
        }

        return null;
    }

    public ArrayList<Course> getCourseList() {
        String url = BASE_URL + "get_course_list.php";

        try {
            ArrayList<?> data = new getInternetData(DbObj.Course).execute(url).get();
            return (ArrayList<Course>) data;
        } catch (ExecutionException e){
            Log.v("ExecutionException", e.getMessage());
        } catch (InterruptedException e){
            Log.v("InterruptedException", e.getMessage());
        }

        return null;
    }

    public ArrayList<Yardage> getCourseTees(int courseId) {
        String url = BASE_URL + "get_course_tees.php?course_id=" + courseId;

        try {
            ArrayList<?> data = new getInternetData(DbObj.Hole).execute(url).get();
            return (ArrayList<Yardage>) data;
        } catch (ExecutionException e){
            Log.v("ExecutionException", e.getMessage());
        } catch (InterruptedException e){
            Log.v("InterruptedException", e.getMessage());
        }

        return null;
    }

    public static void setBaseUrl(String addr) {
        BASE_URL = "http://" + addr + "/mygolfbuddy/";
    }

    private class getInternetData extends AsyncTask<String, Integer, ArrayList<?>>{

        BufferedReader reader = null;
        ArrayList<?> data = null;
        InputStream is = null;
        DbObj objType = null;

        public getInternetData(DbObj objType) {
            this.objType = objType;
        }

        protected ArrayList<?> doInBackground(String... params) {

            String theUrl = params[0];

            try {

                URL url = new URL(theUrl);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();

                is = urlConnection.getInputStream();

                switch (objType) {
                    case Course:
                        CourseToObj cto = new CourseToObj();
                        data = cto.parseresponse(is);
                        break;
                    case Hole:
                        YardageToObj cth = new YardageToObj();
                        data = cth.parseresponse(is);
                        break;
                }

                return data;
            } catch (IOException e) {
                // do nothing
            }

            return data;
        }
    }
}


