package com.ca.mysqlEJB;

import com.ca.mysql.DiskDrive;
import javax.ejb.Remote;

@Remote
public interface DiskDriveEJBRemote {
    void addData(Object obj);
}
