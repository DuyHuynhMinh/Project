package com.ca.camel;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import com.ca.message.*;

import java.io.IOException;

public class ProcessMessage implements Processor {

    public void process(Exchange exchange) throws Exception {

        String message  = exchange.getIn().getBody(String.class);
        Message messageObj = convertToJson(message);
        exchange.getIn().setBody(messageObj);

    }

    public Message convertToJson(String message) {
        Message messageObj = null;
        try {
            messageObj = new ObjectMapper().readValue(message,Message.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messageObj;
    }
}
