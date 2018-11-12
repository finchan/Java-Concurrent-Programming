package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;

public class JSemaphorePermits extends ASemaphore {

    public JSemaphorePermits() {
        super(new Semaphore(2));
    }

}
