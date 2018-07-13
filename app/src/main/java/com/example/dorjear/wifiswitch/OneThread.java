package com.example.dorjear.wifiswitch;

public class OneThread extends Thread {
    @Override
    public void run(){
        System.out.println("111");
        System.out.println("222");
        System.out.println("333");
        System.out.println("444");
    }

    public void doSomething(){
        System.out.println("something1");
        System.out.println("something2");
    }
}


