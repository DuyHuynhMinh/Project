package com.ca.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SendFileWithProcessor extends RouteBuilder {

    public void configure() throws Exception {
        from("file:d:\\InputData\\?noop=true").process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                System.out.println("Sending file : " + exchange.getIn().getHeader("CamelFileName"));
            }
        })
                .to("activemq:queue:Inventory");
    }

}

