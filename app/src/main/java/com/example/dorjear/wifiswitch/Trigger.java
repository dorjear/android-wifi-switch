package com.example.dorjear.wifiswitch;

public class Trigger {
    public static void main(String[] args){
        OneThread thread1 = new OneThread();
        thread1.start();
        thread1.doSomething();
        System.out.println("main");
    }
}
