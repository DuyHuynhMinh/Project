package com.ca.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;


public class ManageCamel {


    private ManageCamel() {}
    private static ManageCamel instance = null;
    private  RouteBuilder r=null;
    private  CamelContext camelContext = new DefaultCamelContext();

    public static ManageCamel getInstance() {
        if(instance ==null) {
                instance = new ManageCamel();
        }
        return instance;
    }

    public void process() {
        try {
            camelContext.addRoutes(r);
            camelContext.start();
            Thread.sleep(5000);
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ManageCamel getObject(RouteBuilder r) {
        this.r = r;
        return this;
    }
    public ManageCamel getObject(RouteBuilder r, ConnectionFactory connectionFactory) {

        /*String hostVM = "vm:localhost";
        String hostTCP = "tcp://0.0.0.0:61616";
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(hostTCP);*/

        camelContext.addComponent("activemq", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        return getObject(r);
    }

}
