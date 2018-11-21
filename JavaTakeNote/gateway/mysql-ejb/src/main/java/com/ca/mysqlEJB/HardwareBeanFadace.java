package com.ca.mysqlEJB;

import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class HardwareBeanFadace implements HardwareRemote {
    @PersistenceContext(unitName="brokerPU")
    private EntityManager em;

    public void addData(Object obj) {
        //em.persist(obj);
        ((Session)em.getDelegate()).saveOrUpdate(obj);
    }

    public Object getData(Class<?> c, int id) {
        //return em.find(c,id);
        return ((Session)em.getDelegate()).get(c,id);
    }
}
