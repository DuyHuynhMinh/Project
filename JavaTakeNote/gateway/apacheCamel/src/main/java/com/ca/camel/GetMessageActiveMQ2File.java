package com.ca.camel;


import com.ca.message.Message;
import com.ca.message.Source;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

import java.util.Collections;
import java.util.List;


public class GetMessageActiveMQ2File extends RouteBuilder {



    public void configure() throws Exception {
        from("activemq:queue:InventoryQueueUpdate")
                .process(new ProcessMessage())
                .filter().method( PollErrorHandler.class, "verifyStatus" )
                //.recipientList( method( GetMessageActiveMQ2File.class, "getRecipientList" ) );
                //.to("file:d:\\Output\\");
                .to("activemq:queue:Performent");

    }


}