package com.ca.client;

import com.ca.mysql.DiskDrive;
import com.ca.mysqlEJB.DiskDriveEJBRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClient {
    public static void main(String []arg) {
        System.out.println("Start");

        writeDataWildfly();
        //writeDataWithoutWildfly();


        System.out.println("End");
}

public static void writeDataWildfly() {
    try {

        Context context = new InitialContext();
        DiskDriveEJBRemote diskEJB = (DiskDriveEJBRemote)context.lookup("mysql-1.0-SNAPSHOT/DiskDriveEJB!com.ca.mysqlEJB.DiskDriveEJBRemote");

        System.out.println(diskEJB + "\n");

        DiskDrive diskDrive = new DiskDrive();


        diskDrive.setVendor("Juniper");
        diskDrive.setValue(500);

        diskEJB.addData(diskDrive);

    } catch (NamingException e) {
        e.printStackTrace();
    }

}

    public static void writeDataWithoutWildfly() {
        EntityManagerFactory emf  = Persistence.createEntityManagerFactory("primary");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        DiskDrive diskDrive = new DiskDrive();
        diskDrive.setVendor("Cisco");
        diskDrive.setValue(100);
        em.persist(diskDrive);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
