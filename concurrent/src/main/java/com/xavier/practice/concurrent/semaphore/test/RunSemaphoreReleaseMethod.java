package com.xavier.practice.concurrent.semaphore.test;

import com.xavier.practice.concurrent.semaphore.service.BaseSemaphore;
import com.xavier.practice.concurrent.semaphore.service.SemaphoreReleaseToAddPermitCounts;

import java.util.concurrent.Semaphore;

public class RunSemaphoreReleaseMethod {
    public static void main(String args[] ) {
        Semaphore semaphore = new Semaphore(5);
        BaseSemaphore service = new SemaphoreReleaseToAddPermitCounts(semaphore);
        service.testMethod();
    }
}
