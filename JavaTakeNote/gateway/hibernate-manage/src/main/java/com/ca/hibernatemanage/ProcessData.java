package com.ca.hibernatemanage;

import com.ca.mysqlEJB.HardwareEntity;

public class ProcessData {

    public void write() {

        HibernateManage hibernateManage = HibernateManage.getInstance();
        HardwareEntity hardwareEntity = new HardwareEntity();
        hardwareEntity.setVendor("Cisco");
        hardwareEntity.setValue(150);
        hibernateManage.addData(hardwareEntity);

    }

    public void read () {

    }

}
