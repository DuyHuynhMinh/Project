package com.ca.camel;

import org.apache.camel.builder.RouteBuilder;

public class Multicast extends RouteBuilder {
    public void configure() throws Exception {
        from("activemq:queue:InventoryQueueUpdate")
                .multicast()
                .to("activemq:queue:PER","activemq:queue:INV");
    }
}
