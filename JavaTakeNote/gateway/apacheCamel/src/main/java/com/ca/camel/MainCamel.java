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


        /*String hostTCP = "tcp://0.0.0.0:61616";
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(hostTCP);*/



        Properties p = new Properties();
        p.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");
        p.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
        p.put(Context.SECURITY_PRINCIPAL,"data");
        p.put(Context.SECURITY_CREDENTIALS,"data");

        try {
            Context context = new WildFlyInitialContext(p);
            ConnectionFactory connectionFactory =(ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");

            ManageCamel manageCamel = ManageCamel.getInstance();
            //manageCamel.process(new SendFileWithProcessor(),connectionFactory);
           // manageCamel.process(new GetMessageActiveMQ2File(),connectionFactory);
        } catch (NamingException e) {
            e.printStackTrace();
        }



        System.out.println("End ");
    }
}
