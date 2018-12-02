package com.xavier.practice.concurrent.exchange;

public class Book implements Exchangable {
    private int value;
    private String name;
    public Book(String name, int value) {
        this.value = value;
        this.name = name;
    }
    public String toString() {
        String format = "Book: %s($%d)";
        return String.format(format, name, value);
    }
}
