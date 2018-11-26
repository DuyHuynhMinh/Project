package com.ca.activemq;


public class OCMessageWildfly {


    private ConnectionManager connectionManager = ConnectionManager.getInstance();

    public  void sendMessage() {
        String message = "Test ActiveMQ Wildfly";
        connectionManager.init();
        connectionManager.send(message);

    }

    public void receiveMessage() {
        connectionManager.init();
        connectionManager.receive();
    }
}
