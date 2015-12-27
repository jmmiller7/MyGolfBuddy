package com.personal.jmmil.mygolfbuddy;

/**
 * Created by jmmil on 12/26/2015.
 */
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CourseAdapter extends ArrayAdapter<Course> {

    private ArrayList<Course> objects;

    public CourseAdapter(Context context, int textViewResourceId, ArrayList<Course> objects) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
        }

		/*
		 * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 *
		 * Therefore, i refers to the current Item object.
		 */
        Course i = objects.get(position);

        if (i != null) {

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.

            TextView courseName = (TextView) v.findViewById(R.id.courseName);
            TextView courseAddr = (TextView) v.findViewById(R.id.courseLocation);


            // check to see if each individual textview is null.
            // if not, assign some text!
            if (courseName != null){
               courseName.setText(i.getCourse_name());
            }
            if (courseAddr != null){
                courseAddr.setText(i.getStreet());
            }
        }


        // the view must be returned to our activity
        return v;
    }

    public void swapList(ArrayList<Course> courses){
        objects.clear();
        objects.addAll(courses);
        notifyDataSetChanged();
    }
}
