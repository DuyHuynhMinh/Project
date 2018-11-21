package com.ca.mysqlEJB;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Hardware")
public class HardwareEntity  implements Serializable {

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
