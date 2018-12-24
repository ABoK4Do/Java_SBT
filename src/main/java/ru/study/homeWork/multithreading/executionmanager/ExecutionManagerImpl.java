package ru.study.homeWork.multithreading.executionmanager;

public class ExecutionManagerImpl implements ExecutionManager {
    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        Counter counter = new Counter();
        TaskHandler taskHandler = new TaskHandler(counter, tasks);
        taskHandler.start();
        return new ContextImpl(taskHandler, counter);
    }
}
