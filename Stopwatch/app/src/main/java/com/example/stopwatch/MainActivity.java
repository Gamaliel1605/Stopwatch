package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private Chronometer stopwatch;
    private long pauseOffset;
    private boolean run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stopwatch = findViewById(R.id.chronometer);
    }

    public void startbtn(View v){
        if(!run){
            stopwatch.setBase(SystemClock.elapsedRealtime() - pauseOffset );
            stopwatch.start();
            run = true;
        }
    }

    public void pausebtn(View v){
        if(run){
            stopwatch.stop();
            pauseOffset = SystemClock.elapsedRealtime() - stopwatch.getBase();
            run = false;
        }
    }

    public void restart(View v){
        stopwatch.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }
}