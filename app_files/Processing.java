package com.example.cs211.ioinsight;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by deosaur on 12/5/16.
 */

public class Processing implements  Runnable {

    String appName;
    List<String> trackedProcesses;
    HashMap<String, AppInfo> hashMap = new HashMap<String, AppInfo>();
    AppInfo finalAppInfo;

    public Processing(String appName) {
        this.appName = appName;
    }

    public void run() {
        try {
            String otherProcesses = "other";
            String totalProcesses = "overall";

            trackedProcesses = new ArrayList<String>();
            trackedProcesses.add(appName);


            hashMap.put(otherProcesses, new AppInfo(new HashMap<Integer, Integer>(), new HashMap<String, Integer>(), new HashSet<Integer>(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new HashMap<String, Integer>(), new HashMap<String, Integer>(), new HashMap<String, Integer>(), new HashMap<Integer, Integer>(), 0, 0, 0, 0, 0, 0));
            hashMap.put(totalProcesses, new AppInfo(new HashMap<Integer, Integer>(), new HashMap<String, Integer>(), new HashSet<Integer>(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new HashMap<String, Integer>(), new HashMap<String, Integer>(), new HashMap<String, Integer>(), new HashMap<Integer, Integer>(), 0, 0, 0, 0, 0, 0));
            hashMap.put(appName, new AppInfo(new HashMap<Integer, Integer>(), new HashMap<String, Integer>(), new HashSet<Integer>(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new HashMap<String, Integer>(), new HashMap<String, Integer>(), new HashMap<String, Integer>(), new HashMap<Integer, Integer>(), 0, 0, 0, 0, 0, 0));

            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/storage/emulated/0/dev_tools/log.txt")));
            StringBuffer stringBuffer = new StringBuffer();
            String currentLine = null;
            while ((currentLine = bufferedReader.readLine()) != null) {
                stringBuffer.append(currentLine);
            }

            Pattern pattern = Pattern.compile("\\+(\\d)\\,(\\d+)\\,(\\d+)\\,(\\d+)\\,(\\d+)\\,(.*?)\\,(.*?)\\,(\\d+)\\,(\\d+)\\,(.*?)\\,(.*?)\\,(.*?)\\,(.*?)\\,(.*?)\\,(\\d+)\\,(\\d+)\\!");
            Matcher matcher = pattern.matcher(stringBuffer);

            while (matcher.find()) {

                String processNameUpperCase = matcher.group(6).trim().toUpperCase();
                boolean isFound = false;

                for (String p : trackedProcesses) {
                    if (processNameUpperCase.contains(p.toUpperCase())) {
                        isFound = true;
                        updateAppInfo(p, matcher);
                    }
                }
                if (!isFound) {
                    updateAppInfo(otherProcesses, matcher);
                }
                updateAppInfo(totalProcesses, matcher);
                matcher.end();
            }

            bufferedReader.close();

            AppInfo appInfoProcess1 = hashMap.get(appName);

//            dataBlocks = String.valueOf(appInfoProcess1.getDataBlockReads() + appInfoProcess1.getDataBlockSynchronousWrites() +
//                    appInfoProcess1.getDataBlockWrites());
//
//            journalBLocks = String.valueOf(appInfoProcess1.getJournalBlockReads() + appInfoProcess1.getJournalBlockSynchronousWrites() +
//                    appInfoProcess1.getJournalBlockWrites());
//
//            metaBlocks = String.valueOf(appInfoProcess1.getMetaBlockReads() + appInfoProcess1.getMetaBlockSynchronousWrites() +
//                    appInfoProcess1.getMetaBlockWrites());
//
//            resultString = "Total reads: " + (appInfoProcess1.getDataBlockReads() +
//                    appInfoProcess1.getJournalBlockReads() +
//                    appInfoProcess1.getMetaBlockReads() +
//                    appInfoProcess1.getAsyncBlockReads() +
//                    appInfoProcess1.getNoneBlockReads()) +
//
//                    "Total writes: " + (appInfoProcess1.getDataBlockWrites() +
//                    appInfoProcess1.getJournalBlockWrites() +
//                    appInfoProcess1.getMetaBlockWrites() +
//                    appInfoProcess1.getAsyncBlockWrites() +
//                    appInfoProcess1.getNoneBlockWrites()) +
//
//                    "Total sync writes: " + (appInfoProcess1.getDataBlockSynchronousWrites() +
//                    appInfoProcess1.getJournalBlockSynchronousWrites() +
//                    appInfoProcess1.getMetaBlockSynchronousWrites() +
//                    appInfoProcess1.getAsyncBlockSynchronousWrites() +
//                    appInfoProcess1.getNoneBlockSynchronousWrites());



//            System.out.println();
//
//            System.out.println("Total data reads: " + appInfoProcess1.getTotalDataRead());
//            System.out.println("Total data writes: " + appInfoProcess1.getTotalDataWrite());
//            System.out.println("Total data writes Sync: " + appInfoProcess1.getTotalDataSynchronousWrite());
//            System.out.println();
//
//            for (Entry<String, Integer> entry : appInfoProcess1.getFilenames().entrySet()) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
//            System.out.println();
//
//            for (Integer f : appInfoProcess1.getFid()) {
//                System.out.println(f);
//            }
//            System.out.println();
//
//            for (Entry<String, Integer> entry : appInfoProcess1.getSql().entrySet()) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
//            System.out.println();
//
//            for (Entry<String, Integer> entry : appInfoProcess1.getFsync().entrySet()) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
//            System.out.println();
//
//            for (Entry<String, Integer> entry : appInfoProcess1.getFdatasync().entrySet()) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
//            System.out.println();
//
//            for (Entry<Integer, Integer> entry : appInfoProcess1.getBlklen().entrySet()) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
//            System.out.println();
//
//
//            System.out.println("For other processes: ");
//
//            System.out.println("Total reads: " + (hashMap.get(otherProcesses).getDataBlockReads() +
//                    hashMap.get(otherProcesses).getJournalBlockReads() +
//                    hashMap.get(otherProcesses).getMetaBlockReads() +
//                    hashMap.get(otherProcesses).getAsyncBlockReads() +
//                    hashMap.get(otherProcesses).getNoneBlockReads()));
//            System.out.println("Total writes: " + (hashMap.get(otherProcesses).getDataBlockWrites() +
//                    hashMap.get(otherProcesses).getJournalBlockWrites() +
//                    hashMap.get(otherProcesses).getMetaBlockWrites() +
//                    hashMap.get(otherProcesses).getAsyncBlockWrites() +
//                    hashMap.get(otherProcesses).getNoneBlockWrites()));
//            System.out.println("Total sync writes: " + (hashMap.get(otherProcesses).getDataBlockSynchronousWrites() +
//                    hashMap.get(otherProcesses).getJournalBlockSynchronousWrites() +
//                    hashMap.get(otherProcesses).getMetaBlockSynchronousWrites() +
//                    hashMap.get(otherProcesses).getAsyncBlockSynchronousWrites() +
//                    hashMap.get(otherProcesses).getNoneBlockSynchronousWrites()));
//
//            System.out.println("Total data reads: " + hashMap.get(otherProcesses).getTotalDataRead());
//            System.out.println("Total data writes: " + hashMap.get(otherProcesses).getTotalDataWrite());
//            System.out.println("Total data writes Sync: " + hashMap.get(otherProcesses).getTotalDataSynchronousWrite());
//            System.out.println();
//
//            for (Entry<String, Integer> entry : hashMap.get(otherProcesses).getFilenames().entrySet()) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
//            System.out.println();
//
//            for (Integer f : hashMap.get(otherProcesses).getFid()) {
//                System.out.println(f);
//            }
//            System.out.println();
//
//            for (Entry<String, Integer> entry : hashMap.get(otherProcesses).getSql().entrySet()) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
//            System.out.println();
//
//            for (Entry<String, Integer> entry : hashMap.get(otherProcesses).getFsync().entrySet()) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
//            System.out.println();
//
//            for (Entry<String, Integer> entry : hashMap.get(otherProcesses).getFdatasync().entrySet()) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
//            System.out.println();
//
//            for (Entry<Integer, Integer> entry : hashMap.get(otherProcesses).getBlklen().entrySet()) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
//            System.out.println();
            finalAppInfo = appInfoProcess1;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updateAppInfo(String processName, Matcher matcher) {
        AppInfo appInfo = hashMap.get(processName);
        String mode = matcher.group(10).trim();
        String blockType = matcher.group(11).trim();

        Integer is_Issue = Integer.valueOf(matcher.group(1).trim());
        if(appInfo.getIs_issue().containsKey(is_Issue)) {
            appInfo.getIs_issue().put(is_Issue, appInfo.getIs_issue().get(is_Issue) + 1);
        } else {
            appInfo.getIs_issue().put(is_Issue, 1);
        }

        String file = matcher.group(7).trim();
        if(appInfo.getFilenames().containsKey(file)) {
            appInfo.getFilenames().put(file, appInfo.getFilenames().get(file) + 1);
        } else {
            appInfo.getFilenames().put(file, 1);
        }

        appInfo.getFid().add(Integer.valueOf(matcher.group(9).trim()));

        Integer blockLength = Integer.valueOf(matcher.group(16).trim());
        if(appInfo.getBlklen().containsKey(blockLength)) {
            appInfo.getBlklen().put(blockLength, appInfo.getBlklen().get(blockLength) + 1);
        } else {
            appInfo.getBlklen().put(blockLength, 1);
        }

        switch(mode) {
            case "R":
                appInfo.setTotalDataRead(appInfo.getTotalDataRead() + blockLength/2);
                Log.d("Read 4K", String.valueOf(appInfo.getFourKBReadCount()));
                if(blockLength == 8) {
                    Log.d("here" , "here");
                    appInfo.setFourKBReadCount(appInfo.getFourKBReadCount() + 1);
                }
                Log.d("Update 4K", String.valueOf(appInfo.getFourKBReadCount()));
                switch(blockType) {
                    case "D":
                        appInfo.setDataBlockReads(appInfo.getDataBlockReads() + 1);
                        break;
                    case "J":
                        appInfo.setJournalBlockReads(appInfo.getJournalBlockReads() + 1);
                        break;
                    case "M":
                        appInfo.setMetaBlockReads(appInfo.getMetaBlockReads() + 1);
                        break;
                    case "A":
                        appInfo.setAsyncBlockReads(appInfo.getAsyncBlockReads() + 1);
                        break;
                    case "N":
                        appInfo.setNoneBlockReads(appInfo.getNoneBlockReads() + 1);
                        break;
                }
                if(file.endsWith("db")) {
                    appInfo.setDbFileReads(appInfo.getDbFileReads() + 1);
                } else if(file.contains("db-")) {
                    appInfo.setDbJournalFileReads(appInfo.getDbJournalFileReads() + 1);
                } else if(file.endsWith("dex") || file.endsWith("apk") || file.endsWith("so")) {
                    appInfo.setExecutableFileReads(appInfo.getExecutableFileReads() + 1);
                } else if(file.endsWith("xml") || file.endsWith("dat") || file.endsWith("local")) {
                    appInfo.setResourceFileReads(appInfo.getResourceFileReads() + 1);
                } else {
                    appInfo.setOtherFileReads(appInfo.getOtherFileReads() + 1);
                }
                break;
            case "W":
                appInfo.setTotalDataWrite(appInfo.getTotalDataWrite() + blockLength/2);
                if(blockLength == 8) {
                    appInfo.setFourKBWriteCount(appInfo.getFourKBWriteCount() + 1);
                }
                switch(blockType) {
                    case "D":
                        appInfo.setDataBlockWrites(appInfo.getDataBlockWrites() + 1);
                        break;
                    case "J":
                        appInfo.setJournalBlockWrites(appInfo.getJournalBlockWrites() + 1);
                        break;
                    case "M":
                        appInfo.setMetaBlockWrites(appInfo.getMetaBlockWrites() + 1);
                        break;
                    case "A":
                        appInfo.setAsyncBlockWrites(appInfo.getAsyncBlockWrites() + 1);
                        break;
                    case "N":
                        appInfo.setNoneBlockWrites(appInfo.getNoneBlockWrites() + 1);
                        break;
                }
                if(file.endsWith("db")) {
                    appInfo.setDbFileWrites(appInfo.getDbFileWrites() + 1);
                } else if(file.endsWith("db-journal")) {
                    appInfo.setDbJournalFileWrites(appInfo.getDbJournalFileWrites() + 1);
                } else if(file.endsWith("dex") || file.endsWith("apk") || file.endsWith("so")) {
                    appInfo.setExecutableFileWrites(appInfo.getExecutableFileWrites() + 1);
                } else if(file.endsWith("xml") || file.endsWith("dat") || file.endsWith("local")) {
                    appInfo.setResourceFileWrites(appInfo.getResourceFileWrites() + 1);
                } else {
                    appInfo.setOtherFileWrites(appInfo.getOtherFileWrites() + 1);
                }
                break;
            case "WS":

                appInfo.setTotalDataSynchronousWrite(appInfo.getTotalDataSynchronousWrite() + blockLength/2);
                if(blockLength == 8) {
                    appInfo.setFourKBSynchWriteCount(appInfo.getFourKBSynchWriteCount() + 1);
                }
                switch(blockType) {
                    case "D":
                        appInfo.setDataBlockSynchronousWrites(appInfo.getDataBlockSynchronousWrites() + 1);
                        break;
                    case "J":
                        appInfo.setJournalBlockSynchronousWrites(appInfo.getJournalBlockSynchronousWrites() + 1);
                        break;
                    case "M":
                        appInfo.setMetaBlockSynchronousWrites(appInfo.getMetaBlockSynchronousWrites() + 1);
                        break;
                    case "A":
                        appInfo.setAsyncBlockSynchronousWrites(appInfo.getAsyncBlockSynchronousWrites() + 1);
                        break;
                    case "N":
                        appInfo.setNoneBlockSynchronousWrites(appInfo.getNoneBlockSynchronousWrites() + 1);
                        break;
                }
                if(file.endsWith("db")) {
                    appInfo.setDbFileSynchronousWrites(appInfo.getDbFileSynchronousWrites() + 1);
                } else if(file.endsWith("db-journal")) {
                    appInfo.setDbJournalFileSynchronousWrites(appInfo.getDbJournalFileSynchronousWrites() + 1);
                } else if(file.endsWith("dex") || file.endsWith("apk") || file.endsWith("so")) {
                    appInfo.setExecutableFileSynchronousWrites(appInfo.getExecutableFileSynchronousWrites() + 1);
                } else if(file.endsWith("xml") || file.endsWith("dat") || file.endsWith("local")) {
                    appInfo.setResourceFileSynchronousWrites(appInfo.getResourceFileSynchronousWrites() + 1);
                } else {
                    appInfo.setOtherFileSynchronousWrites(appInfo.getOtherFileSynchronousWrites() + 1);
                }
                break;
        }
        String sql = matcher.group(12).trim();
        if(appInfo.getSql().containsKey(sql)) {
            appInfo.getSql().put(sql, appInfo.getSql().get(sql) + 1);
        } else {
            appInfo.getSql().put(sql, 1);
        }

        String fsync = matcher.group(13).trim();
        if(appInfo.getFsync().containsKey(fsync)) {
            appInfo.getFsync().put(fsync, appInfo.getFsync().get(fsync) + 1);
        } else {
            appInfo.getFsync().put(fsync, 1);
        }

        String fdatasync = matcher.group(14).trim();
        if(appInfo.getFdatasync().containsKey(fdatasync)) {
            appInfo.getFdatasync().put(fdatasync, appInfo.getFdatasync().get(fdatasync) + 1);
        } else {
            appInfo.getFdatasync().put(fdatasync, 1);
        }
    }
}