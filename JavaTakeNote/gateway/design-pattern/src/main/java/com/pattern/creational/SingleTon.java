package com.pattern.creational;

public class SingleTon {

    private SingleTon(){}
    private static final SingleTon instance = new SingleTon();

    public static SingleTon getInstance() {

        System.out.println ("CODE HERE SINGLETON");

        return instance;
    }


    public void process() {
        System.out.println("CODE HERE");
    }
}
