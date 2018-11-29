package com.pattern.creational;

public enum EnumSingleTon {

    INSTANCE;

    private EnumSingleTon(){}

    public static void process() {
        System.out.println("CODE HERE ENUM SINGLETON");
    }

}
