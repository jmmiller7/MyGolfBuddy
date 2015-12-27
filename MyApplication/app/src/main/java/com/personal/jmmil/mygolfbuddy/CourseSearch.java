package com.personal.jmmil.mygolfbuddy;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.internal.view.menu.MenuView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

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

        adapter = new CourseAdapter(this, R.layout.list_item, courseList);

        setListAdapter(adapter);
    }

    private OnClickListener searchButtonListener = new OnClickListener(){

        public void onClick(View v) {
            MyGolfBuddyAPI api = new MyGolfBuddyAPI();

            //courseList = api.getCourseList();

            courseList = api.searchCourse(searchEditText.getText().toString());

            adapter.swapList(courseList);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
