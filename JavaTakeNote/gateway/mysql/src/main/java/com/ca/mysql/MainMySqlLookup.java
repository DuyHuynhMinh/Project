package com.ca.mysql;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainMySqlLookup {

    public static void main(String []arg) {
        System.out.println("Start");

       writeDataWildfly();
        //writeDataWithoutWildfly();


        System.out.println("End");

    }

    public static void writeDataWildfly(){
       EntityManagerFactory emf  = Persistence.createEntityManagerFactory("primary");

    }


    //Application Manage
    public static void writeDataWithoutWildfly() {
        EntityManagerFactory emf  = Persistence.createEntityManagerFactory("primary");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        DiskDrive diskDrive = new DiskDrive();
        diskDrive.setVendor("F5");
        diskDrive.setValue(200);
        em.persist(diskDrive);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }


}
