package com.ca.client;



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

        //try {

           /* DiskDriveEJBRemote diskEJB = InitialContext.doLookup("jms/RemoteConnectionFactory");

        DiskDrive diskDrive = new DiskDrive();
        diskDrive.setVendor("Cisco");
        diskDrive.setValue(400);
        diskEJB.addData(diskDrive);

        Hardware hardware = new Hardware();
        hardware.setVendor("F7");
        hardware.setValue(500);
        diskEJB.addData(hardware);

    } catch (NamingException e) {
        e.printStackTrace();
    }
*/


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
