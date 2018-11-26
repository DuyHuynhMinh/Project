package com.ca.hibernatemanage;

import org.hibernate.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;

public class HibernateManage {

    private static final HibernateManage instance = new HibernateManage();

    private static EntityManager em;

    public static synchronized HibernateManage getInstance() {
        try   {
            if( em == null )
            {
                em = InitialContext.doLookup( "java:/brokerPU" );
            }
        }
        catch( NamingException e )
        {

        }
        return instance;
    }

    public void addData(Object obj) {
        //em.persist(obj);
        ((Session)em.getDelegate()).saveOrUpdate(obj);
    }

    public Object getData(Class<?> c, int id) {
        //return em.find(c,id);
        return ((Session)em.getDelegate()).get(c,id);
    }

}
