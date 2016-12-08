package com.example.cs211.ioinsight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DisplayDetailedInfo extends AppCompatActivity {

    public void onBackPressed() {
        return;
    }

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_detailed_info);

        HashMap<String, String> hashMap = new HashMap<String, String>();

        hashMap.put("overall", "Overall");
        hashMap.put("angrybirds", "Angry Birds");
        hashMap.put("snowparty2lite", "SnowBoard");
        hashMap.put("Weather", "Weather");
        hashMap.put("IMDB", "IMDB");
        hashMap.put("Audible", "AudibleBooks");
        hashMap.put("flavyvr", "Gallery");
        hashMap.put("Gm", "Gmail");
        hashMap.put("Gbis", "GasBuddy");
        hashMap.put("Twitter", "Twitter");
        hashMap.put("YouTube", "YouTube");
        hashMap.put("Spotify", "Spotify");

        // Our own 10 Apps
        hashMap.put("Chrome", "Chrome");
        hashMap.put("WhatsApp", "WhatsApp");
        hashMap.put("Maps", "Google Maps");
        hashMap.put("Airdroid", "File Trans");
        hashMap.put("Facebook", "Facebook Mssgr");
        hashMap.put("Camera", "HD Camera");
        hashMap.put("Snapchat", "Snapchat");
        hashMap.put("instagram", "Instagram");
        hashMap.put("Epicwaronline", "Mobile Strike");

        String appName = getIntent().getStringExtra("appName");

        String applicationHeader = hashMap.get("Statistics");

        TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        TableRow tableRow = (TableRow) tableLayout.getChildAt(0);
        TextView textView = (TextView) tableRow.getChildAt(0);
        textView.setText(applicationHeader);

        Processing processing = new Processing("overall");
        processing.run();

        int totalReads = processing.finalAppInfo.getDataBlockReads() + processing.finalAppInfo.getJournalBlockReads() +
                processing.finalAppInfo.getMetaBlockReads() + processing.finalAppInfo.getAsyncBlockReads() +
                processing.finalAppInfo.getNoneBlockReads();

        int totalWrites = processing.finalAppInfo.getDataBlockWrites() + processing.finalAppInfo.getJournalBlockWrites() +
                processing.finalAppInfo.getMetaBlockWrites() + processing.finalAppInfo.getAsyncBlockWrites() +
                processing.finalAppInfo.getNoneBlockWrites();

        int totalSynchronousWrites = processing.finalAppInfo.getDataBlockSynchronousWrites() + processing.finalAppInfo.getJournalBlockSynchronousWrites() +
                processing.finalAppInfo.getMetaBlockSynchronousWrites() + processing.finalAppInfo.getAsyncBlockSynchronousWrites() +
                processing.finalAppInfo.getNoneBlockSynchronousWrites();

        List<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(totalReads + totalWrites + totalSynchronousWrites);

        arrayList.add(processing.finalAppInfo.getDataBlockReads());
        arrayList.add(processing.finalAppInfo.getDataBlockWrites());
        arrayList.add(processing.finalAppInfo.getDataBlockSynchronousWrites());

        arrayList.add(processing.finalAppInfo.getJournalBlockReads());
        arrayList.add(processing.finalAppInfo.getJournalBlockWrites());
        arrayList.add(processing.finalAppInfo.getJournalBlockSynchronousWrites());

        arrayList.add(processing.finalAppInfo.getMetaBlockReads());
        arrayList.add(processing.finalAppInfo.getMetaBlockWrites());
        arrayList.add(processing.finalAppInfo.getMetaBlockSynchronousWrites());

        arrayList.add(processing.finalAppInfo.getAsyncBlockReads());
        arrayList.add(processing.finalAppInfo.getAsyncBlockWrites());
        arrayList.add(processing.finalAppInfo.getAsyncBlockSynchronousWrites());

        arrayList.add(processing.finalAppInfo.getNoneBlockReads());
        arrayList.add(processing.finalAppInfo.getNoneBlockWrites());
        arrayList.add(processing.finalAppInfo.getNoneBlockSynchronousWrites());

        arrayList.add(processing.finalAppInfo.getDbFileReads());
        arrayList.add(processing.finalAppInfo.getDbFileWrites());
        arrayList.add(processing.finalAppInfo.getDbFileSynchronousWrites());

        arrayList.add(processing.finalAppInfo.getDbJournalFileReads());
        arrayList.add(processing.finalAppInfo.getDbJournalFileWrites());
        arrayList.add(processing.finalAppInfo.getDbJournalFileSynchronousWrites());

        arrayList.add(processing.finalAppInfo.getExecutableFileReads());
        arrayList.add(processing.finalAppInfo.getExecutableFileWrites());
        arrayList.add(processing.finalAppInfo.getExecutableFileSynchronousWrites());

        arrayList.add(processing.finalAppInfo.getResourceFileReads());
        arrayList.add(processing.finalAppInfo.getResourceFileWrites());
        arrayList.add(processing.finalAppInfo.getResourceFileSynchronousWrites());

        arrayList.add(processing.finalAppInfo.getOtherFileReads());
        arrayList.add(processing.finalAppInfo.getOtherFileWrites());
        arrayList.add(processing.finalAppInfo.getOtherFileSynchronousWrites());

        arrayList.add(processing.finalAppInfo.getFourKBReadCount());
        arrayList.add(totalReads);

        arrayList.add(processing.finalAppInfo.getFourKBWriteCount());
        arrayList.add(totalWrites);

        arrayList.add(processing.finalAppInfo.getFourKBSynchWriteCount());
        arrayList.add(totalSynchronousWrites);

        arrayList.add(processing.finalAppInfo.getTotalDataRead());
        arrayList.add(processing.finalAppInfo.getTotalDataWrite());
        arrayList.add(processing.finalAppInfo.getTotalDataSynchronousWrite());

        for(int i = 1; i < 41; i++) {

            TableRow tableRow1 = (TableRow) tableLayout.getChildAt(i);
            TextView textView0 = (TextView) tableRow1.getChildAt(0);
            TextView textView1 = (TextView) tableRow1.getChildAt(1);
            textView1.setText(String.valueOf(arrayList.get(i-1)));
        }

//        text1 = (TextView)findViewById(R.id.text1);
//
//        text1.setText("Data block read: " + processing.finalAppInfo.getDataBlockReads() +
//                "\nData block write: " + processing.finalAppInfo.getDataBlockWrites() +
//                "\nData block synchronous writes: " + processing.finalAppInfo.getDataBlockSynchronousWrites() +
//                "\nJournal block read: " + processing.finalAppInfo.getJournalBlockReads() +
//                "\nJournal block write: " + processing.finalAppInfo.getJournalBlockWrites() +
//                "\nJournal block synchronous writes: " + processing.finalAppInfo.getJournalBlockSynchronousWrites() +
//                "\nMeta block read: " + processing.finalAppInfo.getMetaBlockReads() +
//                "\nMeta block writes: " + processing.finalAppInfo.getMetaBlockWrites() +
//                "\nMeta block synchronous writes: " + processing.finalAppInfo.getMetaBlockSynchronousWrites() +
//                "\nAsync block read: " + processing.finalAppInfo.getAsyncBlockReads() +
//                "\nAsync block write: " + processing.finalAppInfo.getAsyncBlockWrites() +
//                "\nAsync block synchronous write: " + processing.finalAppInfo.getAsyncBlockSynchronousWrites() +
//                "\nNone block read: " + processing.finalAppInfo.getNoneBlockReads() +
//                "\nNone block write: " + processing.finalAppInfo.getNoneBlockWrites() +
//                "\nNone block synchronous write: " + processing.finalAppInfo.getNoneBlockSynchronousWrites() +
//
//                "DB file read: " + processing.finalAppInfo.getDbFileReads() +
//                "\nDB file write: " + processing.finalAppInfo.getDbFileWrites() +
//                "\nDB file synchronous writes: " + processing.finalAppInfo.getDbFileSynchronousWrites() +
//                "\nDB Journal file read: " + processing.finalAppInfo.getDbJournalFileReads() +
//                "\nDB Journal file write: " + processing.finalAppInfo.getDbJournalFileWrites() +
//                "\nDB Journal file synchronous writes: " + processing.finalAppInfo.getDbJournalFileSynchronousWrites() +
//                "\nExecutable file read: " + processing.finalAppInfo.getExecutableFileReads() +
//                "\nExecutable file writes: " + processing.finalAppInfo.getExecutableFileWrites() +
//                "\nExecutable file synchronous writes: " + processing.finalAppInfo.getExecutableFileSynchronousWrites() +
//                "\nResource file read: " + processing.finalAppInfo.getResourceFileReads() +
//                "\nResource file write: " + processing.finalAppInfo.getResourceFileWrites() +
//                "\nResource file synchronous write: " + processing.finalAppInfo.getResourceFileSynchronousWrites() +
//                "\nOther file read: " + processing.finalAppInfo.getOtherFileReads() +
//                "\nOther file write: " + processing.finalAppInfo.getOtherFileWrites() +
//                "\nOther file synchronous write: " + processing.finalAppInfo.getOtherFileSynchronousWrites() +
//
//                "\nTotal Read Data " + processing.finalAppInfo.totalDataRead + "KB" +
//                "\nTotal Write Data " + processing.finalAppInfo.totalDataWrite + "KB" +
//                "\nTotal Synch Write Data " + processing.finalAppInfo.totalDataSynchronousWrite + "KB");


//        TableRow tableRow1 = (TableRow) tableLayout.getChildAt(2);
//        TableRow tableRow2 = (TableRow) tableLayout.getChildAt(3);
//
//        TextView textView1 = (TextView) tableRow1.getChildAt(0);
//        textView1.setText(processing.dbFiles);
//
//        TextView textView2 = (TextView) tableRow1.getChildAt(1);
//        textView2.setText(processing.DbJournals);
//
//        TextView textView3 = (TextView) tableRow1.getChildAt(2);
//        textView3.setText(processing.metaBlocks);

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // Restart App!
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

    }
}
