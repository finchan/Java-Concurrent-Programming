package com.xavier.practice.concurrent.semaphore.test;

import com.xavier.practice.concurrent.semaphore.service.BaseSemaphore;
import com.xavier.practice.concurrent.semaphore.service.SemaphoreDrainPermits;

import java.util.concurrent.Semaphore;

public class RunSemaphoreDrainPermits {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);
        BaseSemaphore service = new SemaphoreDrainPermits(semaphore);
        service.testMethod();
    }
}
