package com.example.cs211.ioinsight;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.HashMap;


public class AppRWTrack extends AppCompatActivity {

    HashMap<String, String> hashMap = new HashMap<String, String>();

    public void onBackPressed() {
        return;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Log.v("TAG","Permission: "+permissions[0]+ "was "+grantResults[0]);
        }
    }

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_rwtrack);

//        try {
//            Process process_first = Runtime.getRuntime().exec("su");
//            process_first.waitFor();
//        } catch(Exception e) {
//            Log.d("exception", "Process cannot be started");
//        }

        // Paper 10 Apps
        hashMap.put("Overall", "overall");
        hashMap.put("Angry Birds", "angrybirds");
        hashMap.put("SnowBoard", "snowparty2lite");
        hashMap.put("Weather", "Weather");
        hashMap.put("IMDB", "IMDB");
        hashMap.put("AudibleBooks", "Audible");
        hashMap.put("Gallery", "flavyvr");
        hashMap.put("Gmail", "Gm");
        hashMap.put("GasBuddy", "Gbis");
        hashMap.put("Twitter", "Twitter");
        hashMap.put("YouTube", "YouTube");
        hashMap.put("Spotify", "Spotify");

        // Our own 10 Apps
        hashMap.put("Chrome", "Chrome");
        hashMap.put("WhatsApp", "WhatsApp");
        hashMap.put("Google Maps", "Maps");
        hashMap.put("File Trans", "Airdroid");
        hashMap.put("Facebook Mssgr", "Facebook");
        hashMap.put("HD Camera", "Camera");
        hashMap.put("Snapchat", "Snapchat");
        hashMap.put("Instagram", "instagram");
        hashMap.put("Mobile Strike", "Epicwaronline");

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);

        //Start processing
        final TableLayout tableLayout = (TableLayout) findViewById(R.id.mainLayout);

        for(int i=1; i<tableLayout.getChildCount(); i++) {

            final TableRow tableRow = (TableRow) tableLayout.getChildAt(i);
            TextView textView = (TextView) tableRow.getChildAt(0);
            Log.d("logcheck", String.valueOf(textView.getText().toString()));

            tableRow.setOnClickListener(new TableRow.OnClickListener() {
                @Override
                public void onClick(View w) {

                    Intent intent = new Intent(AppRWTrack.this, TimerScreen.class).putExtra("appName", hashMap.get(((TextView) tableRow.getChildAt(0)).getText().toString()));

                    try {
                        Log.d("start", "process going to be executed");
                          Process process = Runtime.getRuntime().exec("su -c sh /storage/emulated/0/dev_tools/loggingscript.sh");

                        Log.d("start", "process executed");
                    } catch (Exception e) {
                        // nothing
                        Log.e("exception", "Process cannot be started" + e.getMessage());
                    }

                    startActivity(intent);
                }
            });
        }



    }
}
