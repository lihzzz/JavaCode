package com.learn.tmp;

public class Job implements Runnable{
    PrintQueue printJob;

    public Job(PrintQueue printJob){
        this.printJob = printJob;
    }
    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
        printJob.printJob(new Object());
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }
}
