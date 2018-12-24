package ru.study.homeWork.multithreading.executionmanager;

public class TaskHandler extends Thread{
    private final Counter counter;
    private final Runnable[] tasks;

    public TaskHandler(Counter counter, Runnable[] tasks) {
        this.counter = counter;
        this.tasks = tasks;
    }

    @Override
    public void run(){
    //mainLogic
    }


    public void interrupt() {

    }
}
