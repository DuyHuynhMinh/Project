package com.ca.mysqlEJB;

import com.ca.mysql.DiskDrive;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class DiskDriveEJB  implements DiskDriveEJBRemote {

    @PersistenceContext(unitName="primary")
    private  EntityManager em;

    @Override
    public void addData(Object obj) {
        //em.persist(obj);
        ((Session)em.getDelegate()).saveOrUpdate(obj);
    }
}
