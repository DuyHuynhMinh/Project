package com.ca.mysqlEJB;

import org.hibernate.Session;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class DiskDriveEJB  implements DiskDriveEJBRemote {

    @PersistenceContext(unitName="primary")
    private  EntityManager em;

    @Override
    public void addData(ORMObject obj) {
        //em.persist(obj);
        ((Session)em.getDelegate()).saveOrUpdate(obj);
    }

    @Override
    public Object getData(Class<?> c, int id) {
         //return em.find(c,id);
        return ((Session)em.getDelegate()).get(c,id);
    }

}
