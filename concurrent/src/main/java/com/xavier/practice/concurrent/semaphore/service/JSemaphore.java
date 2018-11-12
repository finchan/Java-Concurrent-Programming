package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;

public class JSemaphore extends ASemaphore {
    public JSemaphore() {
        super(new Semaphore(1));
    }

}
