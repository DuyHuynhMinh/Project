package com.ca.client;



import com.ca.mysqlEJB.HardwareEntity;
import com.ca.mysqlEJB.HardwareRemote;

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

            HardwareRemote diskEJB = InitialContext.doLookup("oc/gateway-mysql-ejb-1.0-SNAPSHOT/HardwareBeanFadace!com.ca.mysqlEJB.HardwareRemote");

        HardwareEntity hardware = new HardwareEntity();
        hardware.setVendor("Cisco");
        hardware.setValue(500);
        diskEJB.addData(hardware);

    } catch (NamingException e) {
        e.printStackTrace();
    }



}

    public static void writeDataWithoutWildfly() {
        /*EntityManagerFactory emf  = Persistence.createEntityManagerFactory("brokerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        DiskDrive diskDrive = new DiskDrive();
        diskDrive.setVendor("Cisco");
        diskDrive.setValue(100);
        em.persist(diskDrive);
        em.getTransaction().commit();
        em.close();
        emf.close();*/
    }
}
