package com.ca.mysqlEJB;

import javax.ejb.Remote;

@Remote
public interface HardwareRemote {
    void addData(Object obj);
    Object getData(Class<?> c, int id);
}
