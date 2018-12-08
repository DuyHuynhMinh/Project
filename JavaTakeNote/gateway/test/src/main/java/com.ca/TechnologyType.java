package com.ca;

public enum TechnologyType {

    ACI("ACI"),
    VIPTELA("VIPTELA"),
    OPENSTACK("OPENSTACK");

    private String value;

    TechnologyType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
