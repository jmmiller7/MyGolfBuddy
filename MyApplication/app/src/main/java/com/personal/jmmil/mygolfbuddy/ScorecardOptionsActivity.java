package com.personal.jmmil.mygolfbuddy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.personal.jmmil.mygolfbuddy.API.CourseAdapter;
import com.personal.jmmil.mygolfbuddy.API.DatabaseObjects.Yardage;
import com.personal.jmmil.mygolfbuddy.API.DatabaseObjects.YardageAdapter;
import com.personal.jmmil.mygolfbuddy.API.MyGolfBuddyAPI;

import java.util.ArrayList;

public class ScorecardOptionsActivity extends AppCompatActivity {

    ImageButton searchImageButton;
    TextView courseTextView;
    Spinner teeMarkerSpinner;
    String course_name;
    int course_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorecard_options);

        searchImageButton = (ImageButton) this.findViewById(R.id.searchImageButton);
        searchImageButton.setOnClickListener(searchButtonListener);

        courseTextView = (TextView) this.findViewById(R.id.courseTextView);

        teeMarkerSpinner = (Spinner) this.findViewById(R.id.teeMarkerSpinner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scorecard_options, menu);
        return true;
    }

    public OnClickListener searchButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), CourseSearch.class);
            startActivityForResult(intent, 1);
        }
    };

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                course_id = data.getIntExtra("course_id",0);
                populateTeeList(course_id);

                course_name = data.getStringExtra("course_name");
                courseTextView.setText(course_name);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    private void populateTeeList(int courseId){
        MyGolfBuddyAPI api = new MyGolfBuddyAPI();
        ArrayList<Yardage> teeList = api.getCourseTees(courseId);

        for(Yardage yrd : teeList)
            Log.v("Yardage", yrd.getYd_difficulty());

        YardageAdapter adapter = new YardageAdapter(this, R.layout.tee_list_item, teeList);
        Log.v("Adapter", adapter.toString());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teeMarkerSpinner.setAdapter(adapter);
    }
}
