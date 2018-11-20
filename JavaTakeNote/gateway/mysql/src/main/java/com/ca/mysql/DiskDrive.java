package com.ca.mysql;

import com.ca.mysqlEJB.ORMObject;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="DiskDrive")
public class DiskDrive extends ORMObject implements Serializable  {


    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String vendor;

    @Column
    private double value;

    public void setIdDiskDrive(int id) {
        this.id = id;
    }
    public int getIdDiskDrive() {
        return id;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public double getValue() {
        return value;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendor() {
        return vendor;
    }
}
