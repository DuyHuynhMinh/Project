package com.ca.camel;

public enum StatusCode {
    SUCCESS("SUCCESS"),
    FAILURE("FAILURE"),
    PARTIAL("PARTIAL");

    String value;

    StatusCode(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
