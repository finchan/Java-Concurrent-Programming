package com.xavier.test.file;

import java.util.concurrent.Semaphore;

public class ThreadCut extends Thread {
    private FilesMoving fileMoving;
    private int threadIndex;
    private Semaphore semaphore;

    public ThreadCut(FilesMoving filesMoving, int threadIndex, Semaphore semaphore) {
        this.fileMoving = filesMoving;
        this.threadIndex = threadIndex;
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            FilesMoving.cut(FilesMoving.folderArrayList, threadIndex, semaphore);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
