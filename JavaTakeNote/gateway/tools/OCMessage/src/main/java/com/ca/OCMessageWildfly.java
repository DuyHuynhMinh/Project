package com.ca;

import org.apache.commons.io.IOUtils;
import org.wildfly.naming.client.WildFlyInitialContext;


import javax.jms.*;
import javax.naming.Context;
import javax.naming.NamingException;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

public class OCMessageWildfly {

    private static QueueConnectionFactory  queueFactory = null;
    private static QueueConnection conn = null;
    private static QueueSession session = null;
    private static Queue queue = null;

    private static String directory="d:\\InputData\\";

    private static String user = "app";
    private static String password ="app";

    public static void main(String []arg) {
        System.out.println("Start");
        init();
        sendMessage();
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
    public static void sendMessage() {
        try {
            QueueSender sender = session.createSender( queue );
            conn.start();
            File files =new File(directory);
            File []arrFiles = files.listFiles();
            for(File file : arrFiles) {
                URI uri = file.toURI();
                String message = IOUtils.toString(uri,"UTF-8");
                TextMessage txtMessage = session.createTextMessage( message );
                sender.send(txtMessage);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (IOException e) {
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



