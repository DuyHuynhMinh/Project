package com.ca.camel;


import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRouter extends RouteBuilder {
    public void configure() throws Exception {
        from("activemq:queue:InventoryQueue")
                .choice().when(header("CamelFileName").endsWith(".json"))
                .to("file:d:\\OutputDataJson\\")
                .when(header("CamelFileName").endsWith(".xml"))
                .to("file:d:\\OutputDataXml\\")
                .otherwise()
                .to("file:d:\\UnknowFormat\\");

    }
}
