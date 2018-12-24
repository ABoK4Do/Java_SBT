package ru.study.homeWork.multithreading.executionmanager;

public class ContextImpl implements Context {
    private final TaskHandler taskHandler;
    private final Counter counter;

    ContextImpl(TaskHandler taskHandler, Counter counter) {
        this.taskHandler = taskHandler;
        this.counter = counter;
    }

    @Override
    public int getCompletedTaskCount() {
        synchronized (counter) {
            return counter.getCompletedTaskCount();
        }
    }

    @Override
    public synchronized int getFailedTaskCount() {
        synchronized (counter) {
            return counter.getFailedTaskCount();
        }
    }

    @Override
    public synchronized int getInterruptedTaskCount() {
        synchronized (counter) {
            return counter.getInterruptedTaskCount();
        }
    }

    @Override
    public void interrupt() {
        taskHandler.interrupt();
    }

    @Override
    public boolean isFinished() {
        synchronized (counter) {
            return counter.isFinished();
        }
    }
}
