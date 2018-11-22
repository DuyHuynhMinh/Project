package com.ca.camel;

public class MainCamel {
    public static void main(String []arg) {

        System.out.println("Start ");


        ManageCamel manageCamel = ManageCamel.getInstance();

        manageCamel.getObject(new CopyFile()).process();

        System.out.println("End ");
    }
}
