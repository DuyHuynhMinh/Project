package com.ca.mysql;

import javax.persistence.*;

@Entity
@Table(name="DiskDrive")
public class DiskDrive {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String vendor;

    @Column
    private double value;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
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
