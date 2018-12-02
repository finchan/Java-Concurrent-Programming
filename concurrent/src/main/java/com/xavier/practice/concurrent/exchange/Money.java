package com.xavier.practice.concurrent.exchange;

public class Money implements Exchangable {
    private int value;
    public Money(int value) {
        this.value = value;
    }
    public String toString() {
        return "$" +value;
    }
}
