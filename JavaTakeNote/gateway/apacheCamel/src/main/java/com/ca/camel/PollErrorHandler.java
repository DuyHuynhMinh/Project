package com.ca.camel;

import com.ca.message.Message;
import com.ca.message.Status;
import org.apache.camel.Body;
import org.apache.camel.cdi.ContextName;

//@ContextName(GetMessageActiveMQ2File.CAMEL_PLUGIN_CONTEXT)
public class PollErrorHandler {
    public boolean verifyStatus( @Body Message message )
    {
        Status status = message.getMetadata().getStatus();

        System.out.println("Check status : " + status.getCode() );

        return true;
    }
}
