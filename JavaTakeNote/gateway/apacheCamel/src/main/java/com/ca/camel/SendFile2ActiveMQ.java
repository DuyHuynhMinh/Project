package com.ca.camel;

import org.apache.camel.builder.RouteBuilder;

public class SendFile2ActiveMQ extends RouteBuilder {

    public void configure() throws Exception {
        from("file:d:\\InputData\\?noop=true").to("activemq:queue:InventoryQueue");
    }

}
