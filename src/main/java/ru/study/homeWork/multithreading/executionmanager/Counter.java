package ru.study.homeWork.multithreading.executionmanager;

public class Counter {
    private int completedTaskCount;
    private int failedTaskCount;
    private int interruptedTaskCount;
    private boolean isFinished;

    Counter() {
        synchronized (this) {
            completedTaskCount = 0;
            failedTaskCount = 0;
            interruptedTaskCount = 0;
            isFinished = false;
        }
    }

    public synchronized int getCompletedTaskCount() {
        return completedTaskCount;
    }

    public synchronized int getFailedTaskCount() {
        return failedTaskCount;
    }

    public synchronized int getInterruptedTaskCount() {
        return interruptedTaskCount;
    }

    public synchronized boolean isFinished() {
        return isFinished;
    }
}
