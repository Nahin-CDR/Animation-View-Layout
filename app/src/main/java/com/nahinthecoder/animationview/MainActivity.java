package com.nahinthecoder.animationview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageView myButton;
    View myView;
    boolean isUp;
    LinearLayout in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        in = findViewById(R.id.me);
        myView = findViewById(R.id.my_view);
        myButton = findViewById(R.id.my_button);

        // initialize as invisible (could also do in xml)
        myView.setVisibility(View.INVISIBLE);
       // myButton.setText("Slide up");
        isUp = false;
    }

    // slide the view from below itself to the current position
    public void slideUp(View view){
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                view.getHeight(),  // fromYDelta
                0);                // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

    // slide the view from its current position to below itself
    public void slideDown(View view){
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                0,                 // fromYDelta
                view.getHeight()); // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

    public void onSlideViewButtonClick(View view) {
        if (isUp) {
            slideDown(myView);
            in.setVisibility(View.VISIBLE);
            //myButton.setText("Slide up");
        } else {
            slideUp(myView);
            in.setVisibility(View.GONE);
            //myButton.setText("Slide down");
        }
        isUp = !isUp;
    }
}