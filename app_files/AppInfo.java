package com.example.cs211.ioinsight;

/**
 * Created by deosaur on 12/5/16.
 */

import java.util.HashMap;
import java.util.Set;

public class AppInfo {

    HashMap<Integer, Integer> is_issue;
    HashMap<String, Integer> filenames; //occurrences per files + RW mode + Block Type
    Set<Integer> fid;

    int dataBlockReads;
    int dataBlockWrites;
    int dataBlockSynchronousWrites;

    int journalBlockReads;
    int journalBlockWrites;
    int journalBlockSynchronousWrites;

    int metaBlockReads;
    int metaBlockWrites;
    int metaBlockSynchronousWrites;

    int asyncBlockReads;
    int asyncBlockWrites;
    int asyncBlockSynchronousWrites;

    int noneBlockReads;
    int noneBlockWrites;
    int noneBlockSynchronousWrites;

    int dbFileReads;
    int dbFileWrites;
    int dbFileSynchronousWrites;

    int dbJournalFileReads;
    int dbJournalFileWrites;
    int dbJournalFileSynchronousWrites;

    int executableFileReads;
    int executableFileWrites;
    int executableFileSynchronousWrites;

    int otherFileReads;
    int otherFileWrites;
    int otherFileSynchronousWrites;

    int resourceFileReads;
    int resourceFileWrites;
    int resourceFileSynchronousWrites;

    HashMap<String, Integer> sql; //occurrences per files
    HashMap<String, Integer> fsync; //occurrences per files
    HashMap<String, Integer> fdatasync; //occurrences per files
    HashMap<Integer, Integer> blklen;  // block number

    int fourKBReadCount;
    int totalDataRead;

    int fourKBWriteCount;
    int totalDataWrite;

    int fourKBSynchWriteCount;
    int totalDataSynchronousWrite;

    public int getFourKBReadCount() { return fourKBReadCount;}
    public void setFourKBReadCount(int fourKBReadCount) { this.fourKBReadCount = fourKBReadCount;}

    public int getFourKBWriteCount() { return fourKBWriteCount;}
    public void setFourKBWriteCount(int fourKBWriteCount) { this.fourKBWriteCount = fourKBWriteCount;}

    public int getFourKBSynchWriteCount() { return fourKBSynchWriteCount;}
    public void setFourKBSynchWriteCount(int fourKBSynchWriteCount) { this.fourKBSynchWriteCount = fourKBSynchWriteCount;}

    public HashMap<Integer, Integer> getIs_issue() {
        return is_issue;
    }
    public void setIs_issue(HashMap<Integer, Integer> is_issue) {
        this.is_issue = is_issue;
    }
    public HashMap<String, Integer> getFilenames() {
        return filenames;
    }
    public void setFilenames(HashMap<String, Integer> filenames) {
        this.filenames = filenames;
    }
    public Set<Integer> getFid() {
        return fid;
    }
    public void setFid(Set<Integer> fid) {
        this.fid = fid;
    }
    public int getDataBlockReads() {
        return dataBlockReads;
    }
    public void setDataBlockReads(int dataBlockReads) {
        this.dataBlockReads = dataBlockReads;
    }
    public int getDataBlockWrites() {
        return dataBlockWrites;
    }
    public void setDataBlockWrites(int dataBlockWrites) {
        this.dataBlockWrites = dataBlockWrites;
    }
    public int getDataBlockSynchronousWrites() {
        return dataBlockSynchronousWrites;
    }
    public void setDataBlockSynchronousWrites(int dataBlockSynchronousWrites) {
        this.dataBlockSynchronousWrites = dataBlockSynchronousWrites;
    }
    public int getJournalBlockReads() {
        return journalBlockReads;
    }
    public void setJournalBlockReads(int journalBlockReads) {
        this.journalBlockReads = journalBlockReads;
    }
    public int getJournalBlockWrites() {
        return journalBlockWrites;
    }
    public void setJournalBlockWrites(int journalBlockWrites) {
        this.journalBlockWrites = journalBlockWrites;
    }
    public int getJournalBlockSynchronousWrites() {
        return journalBlockSynchronousWrites;
    }
    public void setJournalBlockSynchronousWrites(int journalBlockSynchronousWrites) {
        this.journalBlockSynchronousWrites = journalBlockSynchronousWrites;
    }
    public int getMetaBlockReads() {
        return metaBlockReads;
    }
    public void setMetaBlockReads(int metaBlockReads) {
        this.metaBlockReads = metaBlockReads;
    }
    public int getMetaBlockWrites() {
        return metaBlockWrites;
    }
    public void setMetaBlockWrites(int metaBlockWrites) {
        this.metaBlockWrites = metaBlockWrites;
    }
    public int getMetaBlockSynchronousWrites() {
        return metaBlockSynchronousWrites;
    }
    public void setMetaBlockSynchronousWrites(int metaBlockSynchronousWrites) {
        this.metaBlockSynchronousWrites = metaBlockSynchronousWrites;
    }
    public int getAsyncBlockReads() {
        return asyncBlockReads;
    }
    public void setAsyncBlockReads(int asyncBlockReads) {
        this.asyncBlockReads = asyncBlockReads;
    }
    public int getAsyncBlockWrites() {
        return asyncBlockWrites;
    }
    public void setAsyncBlockWrites(int asyncBlockWrites) {
        this.asyncBlockWrites = asyncBlockWrites;
    }
    public int getAsyncBlockSynchronousWrites() {
        return asyncBlockSynchronousWrites;
    }
    public void setAsyncBlockSynchronousWrites(int asyncBlockSynchronousWrites) {
        this.asyncBlockSynchronousWrites = asyncBlockSynchronousWrites;
    }
    public int getNoneBlockReads() {
        return noneBlockReads;
    }
    public void setNoneBlockReads(int noneBlockReads) {
        this.noneBlockReads = noneBlockReads;
    }
    public int getNoneBlockWrites() {
        return noneBlockWrites;
    }
    public void setNoneBlockWrites(int noneBlockWrites) {
        this.noneBlockWrites = noneBlockWrites;
    }
    public int getNoneBlockSynchronousWrites() {
        return noneBlockSynchronousWrites;
    }
    public void setNoneBlockSynchronousWrites(int noneBlockSynchronousWrites) {
        this.noneBlockSynchronousWrites = noneBlockSynchronousWrites;
    }
    public int getDbFileReads() {
        return dbFileReads;
    }
    public void setDbFileReads(int dbFileReads) {
        this.dbFileReads = dbFileReads;
    }
    public int getDbFileWrites() {
        return dbFileWrites;
    }
    public void setDbFileWrites(int dbFileWrites) {
        this.dbFileWrites = dbFileWrites;
    }
    public int getDbFileSynchronousWrites() {
        return dbFileSynchronousWrites;
    }
    public void setDbFileSynchronousWrites(int dbFileSynchronousWrites) {
        this.dbFileSynchronousWrites = dbFileSynchronousWrites;
    }
    public int getDbJournalFileReads() {
        return dbJournalFileReads;
    }
    public void setDbJournalFileReads(int dbJournalFileReads) {
        this.dbJournalFileReads = dbJournalFileReads;
    }
    public int getDbJournalFileWrites() {
        return dbJournalFileWrites;
    }
    public void setDbJournalFileWrites(int dbJournalFileWrites) {
        this.dbJournalFileWrites = dbJournalFileWrites;
    }
    public int getDbJournalFileSynchronousWrites() {
        return dbJournalFileSynchronousWrites;
    }
    public void setDbJournalFileSynchronousWrites(int dbJournalFileSynchronousWrites) {
        this.dbJournalFileSynchronousWrites = dbJournalFileSynchronousWrites;
    }
    public int getExecutableFileReads() {
        return executableFileReads;
    }
    public void setExecutableFileReads(int executableFileReads) {
        this.executableFileReads = executableFileReads;
    }
    public int getExecutableFileWrites() {
        return executableFileWrites;
    }
    public void setExecutableFileWrites(int executableFileWrites) {
        this.executableFileWrites = executableFileWrites;
    }
    public int getExecutableFileSynchronousWrites() {
        return executableFileSynchronousWrites;
    }
    public void setExecutableFileSynchronousWrites(int executableFileSynchronousWrites) {
        this.executableFileSynchronousWrites = executableFileSynchronousWrites;
    }
    public int getOtherFileReads() {
        return otherFileReads;
    }
    public void setOtherFileReads(int otherFileReads) {
        this.otherFileReads = otherFileReads;
    }
    public int getOtherFileWrites() {
        return otherFileWrites;
    }
    public void setOtherFileWrites(int otherFileWrites) {
        this.otherFileWrites = otherFileWrites;
    }
    public int getOtherFileSynchronousWrites() {
        return otherFileSynchronousWrites;
    }
    public void setOtherFileSynchronousWrites(int otherFileSynchronousWrites) {
        this.otherFileSynchronousWrites = otherFileSynchronousWrites;
    }
    public int getResourceFileReads() {
        return resourceFileReads;
    }
    public void setResourceFileReads(int resourceFileReads) {
        this.resourceFileReads = resourceFileReads;
    }
    public int getResourceFileWrites() {
        return resourceFileWrites;
    }
    public void setResourceFileWrites(int resourceFileWrites) {
        this.resourceFileWrites = resourceFileWrites;
    }
    public int getResourceFileSynchronousWrites() {
        return resourceFileSynchronousWrites;
    }
    public void setResourceFileSynchronousWrites(int resourceFileSynchronousWrites) {
        this.resourceFileSynchronousWrites = resourceFileSynchronousWrites;
    }
    public HashMap<String, Integer> getSql() {
        return sql;
    }
    public void setSql(HashMap<String, Integer> sql) {
        this.sql = sql;
    }
    public HashMap<String, Integer> getFsync() {
        return fsync;
    }
    public void setFsync(HashMap<String, Integer> fsync) {
        this.fsync = fsync;
    }
    public HashMap<String, Integer> getFdatasync() {
        return fdatasync;
    }
    public void setFdatasync(HashMap<String, Integer> fdatasync) {
        this.fdatasync = fdatasync;
    }
    public HashMap<Integer, Integer> getBlklen() {
        return blklen;
    }
    public void setBlklen(HashMap<Integer, Integer> blklen) {
        this.blklen = blklen;
    }
    public int getTotalDataRead() { return totalDataRead; }
    public void setTotalDataRead(int totalDataRead) {
        this.totalDataRead = totalDataRead;
    }
    public int getTotalDataWrite() {
        return totalDataWrite;
    }
    public void setTotalDataWrite(int totalDataWrite) {
        this.totalDataWrite = totalDataWrite;
    }
    public int getTotalDataSynchronousWrite() {return totalDataSynchronousWrite; }
    public void setTotalDataSynchronousWrite(int totalDataSynchronousWrite) { this.totalDataSynchronousWrite = totalDataSynchronousWrite; }
    public AppInfo(HashMap<Integer, Integer> is_issue, HashMap<String, Integer> filenames, Set<Integer> fid,
                   int dataBlockReads, int dataBlockWrites, int dataBlockSynchronousWrites, int journalBlockReads,
                   int journalBlockWrites, int journalBlockSynchronousWrites, int metaBlockReads, int metaBlockWrites,
                   int metaBlockSynchronousWrites, int asyncBlockReads, int asyncBlockWrites, int asyncBlockSynchronousWrites,
                   int noneBlockReads, int noneBlockWrites, int noneBlockSynchronousWrites, int dbFileReads, int dbFileWrites,
                   int dbFileSynchronousWrites, int dbJournalFileReads, int dbJournalFileWrites,
                   int dbJournalFileSynchronousWrites, int executableFileReads, int executableFileWrites,
                   int executableFileSynchronousWrites, int otherFileReads, int otherFileWrites,
                   int otherFileSynchronousWrites, int resourceFileReads, int resourceFileWrites,
                   int resourceFileSynchronousWrites, HashMap<String, Integer> sql, HashMap<String, Integer> fsync,
                   HashMap<String, Integer> fdatasync, HashMap<Integer, Integer> blklen, int fourKBDataRead, int totalDataRead,
                   int fourKBDataWrite, int totalDataWrite, int fourKBDataSynchWrite, int totalDataSynchronousWrite   ) {
        super();
        this.is_issue = is_issue;
        this.filenames = filenames;
        this.fid = fid;
        this.dataBlockReads = dataBlockReads;
        this.dataBlockWrites = dataBlockWrites;
        this.dataBlockSynchronousWrites = dataBlockSynchronousWrites;
        this.journalBlockReads = journalBlockReads;
        this.journalBlockWrites = journalBlockWrites;
        this.journalBlockSynchronousWrites = journalBlockSynchronousWrites;
        this.metaBlockReads = metaBlockReads;
        this.metaBlockWrites = metaBlockWrites;
        this.metaBlockSynchronousWrites = metaBlockSynchronousWrites;
        this.asyncBlockReads = asyncBlockReads;
        this.asyncBlockWrites = asyncBlockWrites;
        this.asyncBlockSynchronousWrites = asyncBlockSynchronousWrites;
        this.noneBlockReads = noneBlockReads;
        this.noneBlockWrites = noneBlockWrites;
        this.noneBlockSynchronousWrites = noneBlockSynchronousWrites;
        this.dbFileReads = dbFileReads;
        this.dbFileWrites = dbFileWrites;
        this.dbFileSynchronousWrites = dbFileSynchronousWrites;
        this.dbJournalFileReads = dbJournalFileReads;
        this.dbJournalFileWrites = dbJournalFileWrites;
        this.dbJournalFileSynchronousWrites = dbJournalFileSynchronousWrites;
        this.executableFileReads = executableFileReads;
        this.executableFileWrites = executableFileWrites;
        this.executableFileSynchronousWrites = executableFileSynchronousWrites;
        this.otherFileReads = otherFileReads;
        this.otherFileWrites = otherFileWrites;
        this.otherFileSynchronousWrites = otherFileSynchronousWrites;
        this.resourceFileReads = resourceFileReads;
        this.resourceFileWrites = resourceFileWrites;
        this.resourceFileSynchronousWrites = resourceFileSynchronousWrites;
        this.sql = sql;
        this.fsync = fsync;
        this.fdatasync = fdatasync;
        this.blklen = blklen;
        this.fourKBReadCount = fourKBDataRead;
        this.totalDataRead = totalDataRead;

        this.fourKBWriteCount = fourKBDataWrite;
        this.totalDataWrite = totalDataWrite;

        this.fourKBSynchWriteCount = fourKBDataSynchWrite;
        this.totalDataSynchronousWrite = totalDataSynchronousWrite;

    }
}
