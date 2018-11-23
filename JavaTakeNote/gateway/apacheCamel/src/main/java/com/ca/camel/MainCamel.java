package com.ca.camel;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.ConnectionFactory;

public class MainCamel {
    public static void main(String []arg) {

        System.out.println("Start ");


        String hostTCP = "tcp://0.0.0.0:61616";
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(hostTCP);
        ManageCamel manageCamel = ManageCamel.getInstance();
       manageCamel.getObject(new SendFileWithProcessor(),connectionFactory).process();
       manageCamel.getObject(new GetMessageActiveMQ2File(),connectionFactory).process();

        System.out.println("End ");
    }
}
