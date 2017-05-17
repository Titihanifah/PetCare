package com.example.goofygoober.ta;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);


       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent mainIntent = new Intent(MainActivity.this, Main2Activity.class);
               MainActivity.this.startActivity(mainIntent);
               MainActivity.this.finish();
           }
       }, SPLASH_DISPLAY_LENGTH);


    }
}
