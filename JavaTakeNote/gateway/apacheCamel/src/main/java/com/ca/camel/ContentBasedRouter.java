package com.ca.camel;


import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRouter extends RouteBuilder {
    public void configure() throws Exception {
        from("activemq:queue:InventoryQueueUpdate")
                .choice().when(header("CamelFileName").endsWith(".json"))
                .to("file:d:\\OutputDataJson\\")
                .when(header("CamelFileName").endsWith(".pdf"))
                .to("file:d:\\OutputDataPDF\\")
                .otherwise()
                .to("file:d:\\OutPutUnknowFormat\\");

    }
}
