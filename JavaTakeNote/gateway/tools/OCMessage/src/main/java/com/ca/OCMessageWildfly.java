package com.ca;

import org.wildfly.naming.client.WildFlyInitialContext;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.NamingException;
import java.util.Properties;

public class OCMessageWildfly {

    private static QueueConnectionFactory  queueFactory = null;
    private static QueueConnection conn = null;
    private static QueueSession session = null;
    private static Queue queue = null;

    private static String user = "admin";
    private static String password ="admin";

    public static void main(String []arg) {
        System.out.println("Start");
        init();
        //SendMessage();
        receiveMessage();
        System.out.println("End");
    }
    public static void init() {
        Properties p = new Properties();
        p.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");
        p.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
        try {
            Context context = new WildFlyInitialContext(p);
            queueFactory = (QueueConnectionFactory)context.lookup("jms/RemoteConnectionFactory");
            conn = queueFactory.createQueueConnection(user,password);
            session = conn.createQueueSession( false, Session.AUTO_ACKNOWLEDGE );
            queue = (Queue)context.lookup( "jms/queue/InventoryUpdateQueue");
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    public static void SendMessage() {
        try {
            QueueSender sender = session.createSender( queue );
            conn.start();
            String message = "Hello Wildfly";
            TextMessage txtMessage = session.createTextMessage( message );
            sender.send(txtMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        System.out.println("Message is send successfully");

    }

    public static void receiveMessage() {
        try {
            QueueReceiver queueReceiver  = session.createReceiver(queue);
            conn.start();
            TextMessage message = (TextMessage) queueReceiver.receive();
            System.out.println("Received Message : " + message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}



