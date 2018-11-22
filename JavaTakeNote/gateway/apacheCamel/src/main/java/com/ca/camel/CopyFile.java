package com.ca.camel;

import org.apache.camel.builder.RouteBuilder;

public class CopyFile extends RouteBuilder {

    public void configure() throws Exception {
        from("file:d:\\InputData\\?noop=true").to("file:d:\\OutputData\\");
    }

}
