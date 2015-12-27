package com.personal.jmmil.mygolfbuddy;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
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

        adapter = new CourseAdapter(this, R.layout.list_item, courseList);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_course_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
