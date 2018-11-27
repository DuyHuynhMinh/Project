package com.ca.camel;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.wildfly.naming.client.WildFlyInitialContext;

import javax.jms.ConnectionFactory;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingException;

public class MainCamel {
    public static void main(String []arg) {

        System.out.println("Start ");


        String hostTCP = "tcp://0.0.0.0:61616";
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(hostTCP);

        ManageCamel manageCamel = ManageCamel.getInstance();
        manageCamel.process(new SendFileWithProcessor(),connectionFactory);
        manageCamel.process(new GetMessageActiveMQ2File(),connectionFactory);

        System.out.println("End ");
    }
}
