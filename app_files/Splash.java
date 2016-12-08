package com.example.cs211.ioinsight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Splash extends Activity {

    Button next;

    @Override
    protected void onCreate(Bundle my_bundle) {
        super.onCreate(my_bundle);
        setContentView(R.layout.activity_splash);

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent start_point = new Intent(".AppRWTrack");
                    startActivity(start_point);
                }
            }
        };
        timer.start();
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
    }
}