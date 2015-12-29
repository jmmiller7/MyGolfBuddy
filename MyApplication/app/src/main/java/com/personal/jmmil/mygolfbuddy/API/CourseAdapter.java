package com.personal.jmmil.mygolfbuddy.API;

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.personal.jmmil.mygolfbuddy.CourseSearch;
import com.personal.jmmil.mygolfbuddy.R;

public class CourseAdapter extends ArrayAdapter<Course> {

    private ArrayList<Course> courses;

    public CourseAdapter(Context context, int textViewResourceId, ArrayList<Course> courses) {
        super(context, textViewResourceId, courses);
        this.courses = courses;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
        }

        Course course = courses.get(position);

        if (course != null) {

            TextView courseName = (TextView) v.findViewById(R.id.courseName);
            TextView courseAddr = (TextView) v.findViewById(R.id.courseLocation);

            if (courseName != null){
               courseName.setText(course.getCourse_name());
            }
            if (courseAddr != null){
                courseAddr.setText(course.getStreet());
            }
        }

        v.setOnClickListener(itemListener);

        v.setTag(course);

        return v;
    }

    private OnClickListener itemListener = new OnClickListener(){
        @Override
        public void onClick(View v) {
            CourseSearch cs = (CourseSearch) v.getContext();

            Intent returnIntent = cs.getIntent();

            Course course = (Course) v.getTag();

            returnIntent.putExtra("course_id", course.getCourse_id());
            returnIntent.putExtra("course_name", course.getCourse_name());
            cs.setResult(cs.RESULT_OK, returnIntent);
            cs.finish();
        }
    };

    public void swapList(ArrayList<Course> courses){
        this.courses.clear();
        this.courses.addAll(courses);
        notifyDataSetChanged();
    }
}
