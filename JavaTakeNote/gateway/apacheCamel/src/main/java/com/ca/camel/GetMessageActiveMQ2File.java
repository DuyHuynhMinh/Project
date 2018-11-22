package com.ca.camel;

import org.apache.camel.builder.RouteBuilder;

public class GetMessageActiveMQ2File extends RouteBuilder {

    public void configure() throws Exception {
        from("activemq:queue:InventoryQueue").to("file:d:\\OutputData\\");
    }

}