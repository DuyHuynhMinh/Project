package com.ca.activemq;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConnectionManager {

    private static final ConnectionManager instance = new ConnectionManager();


    private static QueueConnectionFactory queueFactory = null;
    private static QueueConnection conn = null;
    private static QueueSession session = null;
    private static Queue queue = null;


    public static synchronized ConnectionManager getInstance() {
        try   {
            if( queueFactory == null )
            {
                queueFactory = InitialContext.doLookup( "java:/ConnectionFactory" );
            }
        }
        catch( NamingException e )
        {
            e.printStackTrace();
        }
        return instance;
    }

    public void init() {
        try {
            conn = queueFactory.createQueueConnection();
            session = conn.createQueueSession( false, Session.AUTO_ACKNOWLEDGE );
            queue = InitialContext.doLookup( "jms/queue/InventoryUpdateQueue");
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    public void send(String message) {
        try {
            QueueSender sender = session.createSender( queue );
            conn.start();
            TextMessage txtMessage = session.createTextMessage( message );
            sender.send(txtMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    public void receive() {
        try {
            QueueReceiver queueReceiver  = session.createReceiver(queue);
            conn.start();
            TextMessage message = (TextMessage) queueReceiver.receive();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
