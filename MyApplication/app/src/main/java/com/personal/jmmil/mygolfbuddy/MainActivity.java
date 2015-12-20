package com.personal.jmmil.mygolfbuddy;

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

    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imageButton1 = (ImageButton) this.findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(buttonListener);
        imageButton1.setOnTouchListener(new ButtonHighlighterOnTouchListener(imageButton1));

        ImageButton imageButton2 = (ImageButton) this.findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(buttonListener);
        imageButton2.setOnTouchListener(new ButtonHighlighterOnTouchListener(imageButton2));

        ImageButton imageButton3 = (ImageButton) this.findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(buttonListener);
        imageButton3.setOnTouchListener(new ButtonHighlighterOnTouchListener(imageButton3));

        ImageButton imageButton4 = (ImageButton) this.findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(buttonListener);
        imageButton4.setOnTouchListener(new ButtonHighlighterOnTouchListener(imageButton4));
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

                    // Your action here on button click

                case MotionEvent.ACTION_CANCEL: {
                    ImageButton view = (ImageButton) v;
                    view.getBackground().clearColorFilter();
                    view.invalidate();
                    break;
                }
            }
            return true;
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
