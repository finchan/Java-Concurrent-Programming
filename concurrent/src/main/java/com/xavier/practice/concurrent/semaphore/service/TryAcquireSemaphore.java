package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TryAcquireSemaphore extends BaseSemaphore {
    private String methodName = "";

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public TryAcquireSemaphore(Semaphore semaphore) {
        super(semaphore);
    }

    public void testMethod() {
        if(getMethodName() == "1") {
            if(semaphore.tryAcquire()){
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " starts.");
                for(int i=0; i< 100000; i++) {
                    String str = new String();
                    Math.random();
                }
                semaphore.release();
            } else{
                try {
                    semaphore.tryAcquire(5, TimeUnit.SECONDS);
                    System.out.println("Thread B");
                    System.out.println("Thread Name: " + Thread.currentThread().getName() + " starts.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }



            }
        } else if(getMethodName() == "2") {
            if(semaphore.tryAcquire(3)){
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " starts.");
                for(int i=0; i< 100000; i++) {
                    String str = new String();
                    Math.random();
                }
                semaphore.release(3);
            } else{
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " doesn't start.");
            }
        } else {
            try {
                if(semaphore.tryAcquire(3,20, TimeUnit.SECONDS)){
                    System.out.println("Thread Name: " + Thread.currentThread().getName() + " starts.");
                    for(int i=0; i< 1000000; i++) {
                        String str = new String();
                        Math.random();
                    }
                    semaphore.release(3);
                } else{
                    System.out.println("Thread Name: " + Thread.currentThread().getName() + " doesn't start.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
