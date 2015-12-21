package com.personal.jmmil.mygolfbuddy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton startRoundBtn;
    ImageButton savedRoundsBtn;
    ImageButton myStatsBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startRoundBtn = (ImageButton) this.findViewById(R.id.startRoundBtn);
        startRoundBtn.setOnClickListener(buttonListener);
        startRoundBtn.setOnTouchListener(new ButtonHighlighterOnTouchListener(startRoundBtn));

        savedRoundsBtn = (ImageButton) this.findViewById(R.id.savedRoundsBtn);
        savedRoundsBtn.setOnClickListener(buttonListener);
        savedRoundsBtn.setOnTouchListener(new ButtonHighlighterOnTouchListener(savedRoundsBtn));

        myStatsBtn = (ImageButton) this.findViewById(R.id.myStatsBtn);
        myStatsBtn.setOnClickListener(buttonListener);
        myStatsBtn.setOnTouchListener(new ButtonHighlighterOnTouchListener(myStatsBtn));
    }

    private View.OnClickListener buttonListener = new View.OnClickListener(){

        public void onClick(View v) {
            ImageButton btn = (ImageButton) v;
            btn.setColorFilter(Color.argb(255, 255, 255, 255)); // White Tint
        }
    };

    public class ButtonHighlighterOnTouchListener implements View.OnTouchListener {

        final ImageButton imageButton;

        public ButtonHighlighterOnTouchListener(final ImageButton imageButton) {
            super();
            this.imageButton = imageButton;
        }


        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    ImageButton view = (ImageButton) v;
                    view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                    v.invalidate();
                    break;
                }
                case MotionEvent.ACTION_UP:

                handleTouch(imageButton);

                case MotionEvent.ACTION_CANCEL: {
                    ImageButton view = (ImageButton) v;
                    view.getBackground().clearColorFilter();
                    view.invalidate();
                    break;
                }
            }
            return true;
        }


        private void handleTouch(ImageButton imageButton){

            switch(imageButton.getId()){
                case R.id.startRoundBtn:
                    Log.v("msg", "startRoundBtn pressed");
                    Intent intent = new Intent(imageButton.getContext(),
                            ScorecardOptionsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.savedRoundsBtn:
                    Log.v("msg", "savedRoundsBtn pressed");
                    break;
                case R.id.myStatsBtn:
                    Log.v("msg", "myStatsBtn pressed");
                    break;
                default:
                    break;
            }


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
