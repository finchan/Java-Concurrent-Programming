package com.xavier.practice.concurrent.exchange.test;

import com.xavier.practice.concurrent.exchange.Buyer;
import com.xavier.practice.concurrent.exchange.Exchangable;
import com.xavier.practice.concurrent.exchange.Seller;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<Exchangable> exchanger = new Exchanger<Exchangable>();
        Seller seller = new Seller(exchanger);
        Buyer buyer = new Buyer(exchanger);
        new Thread(seller).start();
        new Thread(buyer).start();
    }
}
