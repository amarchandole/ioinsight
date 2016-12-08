package com.example.cs211.ioinsight;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class TimerScreen extends AppCompatActivity {

    public void onBackPressed() {
        return;
    }

    TextView text1, text0;
    private static final String FORMAT = "%02d:%02d:%02d";

    int seconds, minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String appName = getIntent().getStringExtra("appName");
        setContentView(R.layout.activity_timer_screen);
        new CountDownTimer(35000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                text1 = (TextView)findViewById(R.id.text1);
                text1.setSingleLine(false);
                //text0 = (TextView)findViewById(R.id.text0);

                //text0.setText("" + appName);
                text1.setText("Time Left: " + String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                /*text1.setText("done!"); */

                Intent intent = new Intent(TimerScreen.this, DisplayDetailedInfo.class).putExtra("appName", appName);
                startActivity(intent);
            }
        }.start();

    }

}
