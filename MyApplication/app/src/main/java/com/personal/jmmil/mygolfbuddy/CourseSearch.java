package com.personal.jmmil.mygolfbuddy;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

import com.personal.jmmil.mygolfbuddy.API.DatabaseObjects.Course;
import com.personal.jmmil.mygolfbuddy.API.CourseAdapter;
import com.personal.jmmil.mygolfbuddy.API.MyGolfBuddyAPI;

import java.util.ArrayList;


public class CourseSearch extends ListActivity {

    EditText searchEditText;
    ImageButton searchButton;
    ArrayList<Course> courseList;
    CourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_search);

        searchEditText = (EditText) findViewById(R.id.searchEditText);

        searchButton = (ImageButton) findViewById(R.id.searchImageButton);
        searchButton.setOnClickListener(searchButtonListener);

        courseList = new ArrayList<>();

        adapter = new CourseAdapter(this, R.layout.course_list_item, courseList);

        setListAdapter(adapter);

        searchEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    EditText et = (EditText) v;
                    et.setText("");
                }
            }
        });
    }

    private OnClickListener searchButtonListener = new OnClickListener(){

        public void onClick(View v) {
            MyGolfBuddyAPI api = new MyGolfBuddyAPI();

            courseList = api.searchCourse(searchEditText.getText().toString());

            adapter.swapList(courseList);
        }
    };
}
