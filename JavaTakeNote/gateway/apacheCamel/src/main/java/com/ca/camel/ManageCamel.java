package com.ca.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;


public class ManageCamel {


    private ManageCamel() {}
    private static ManageCamel instance = null;

    public static ManageCamel getInstance() {
        if(instance ==null) {
                instance = new ManageCamel();
        }
        return instance;
    }

    public void process(RouteBuilder r, ConnectionFactory connectionFactory) {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addComponent("activemq", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        try {
            camelContext.addRoutes(r);
            camelContext.start();
            Thread.sleep(5000);
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
