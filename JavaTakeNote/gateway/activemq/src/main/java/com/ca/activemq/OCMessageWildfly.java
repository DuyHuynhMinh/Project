package com.ca.activemq;


import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class OCMessageWildfly {


    private ConnectionManager connectionManager = ConnectionManager.getInstance();

    public  void sendMessage() {

        String path = "d:\\Input\\";
        File file = new File(path);
        File []files = file.listFiles();

        connectionManager.init();

        for(File f : files ) {
            URI uri = f.toURI();
            try {
                String message  = IOUtils.toString(uri,"UTF-8");
                connectionManager.send(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void receiveMessage() {
        connectionManager.receive();
    }
}
