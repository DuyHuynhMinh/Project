package com.ca.mysqlEJB;

public abstract class ORMObject {
    private Object id;

    public Object getId()
    {
        return id;
    }

    public void setId( Object id )
    {
        this.id = id;
    }

}
