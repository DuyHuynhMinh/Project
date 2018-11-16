package com.ca.mysql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainMySQL {

    private static  StandardServiceRegistry standardRegistry= null;
    private static Metadata metadata =null;
    private static SessionFactory sessionFactory= null;
    private static Session session =null;

    public static void main(String []arg) {

        System.out.println("Start");

        init();

        writeData();

        System.out.println("Finish");


    }

    public static void init() {
        standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg").build();
        metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        session = sessionFactory.openSession();
        session.getTransaction().begin();
    }


    public static void writeData() {
        DiskDrive diskDrive = new DiskDrive();
        diskDrive.setVendor("F5");
        diskDrive.setValue(1500);
        session.save(diskDrive);
        session.getTransaction().commit();
        session.close();
    }


}
