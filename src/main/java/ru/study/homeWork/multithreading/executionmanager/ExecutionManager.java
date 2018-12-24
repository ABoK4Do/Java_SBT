package ru.study.homeWork.multithreading.executionmanager;


public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
