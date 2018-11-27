package com.ca.camel;

import com.ca.message.Message;
import com.ca.message.Status;
import org.apache.camel.Body;

public class PollErrorHandler {
    public boolean verifyStatus( @Body Message message ){
        Status status = message.getMetadata().getStatus();

        if(status.getCode().equals(StatusCode.FAILURE.getValue())) {
            return false;
        }
        return true;
    }
}
