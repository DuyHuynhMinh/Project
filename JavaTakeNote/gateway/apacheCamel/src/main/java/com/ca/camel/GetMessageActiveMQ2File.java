package com.ca.camel;


import com.ca.message.Message;
import com.ca.message.Source;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

import java.util.Collections;
import java.util.List;


public class GetMessageActiveMQ2File extends RouteBuilder {

    public static final String ROUTE_FORMAT = "vm:global/plugin/%s?failIfNoConsumers=true";

    public void configure() throws Exception {
        from("activemq:queue:Inventory").process(new ProcessMessage())
                //.filter().method( PollErrorHandler.class, "verifyStatus" )
                //.recipientList( method( GetMessageActiveMQ2File.class, "getRecipientList" ) );
                .to("file:d:\\Output\\");
                //.to("activemq:queue:Performent");

    }

    public List<String> getRecipientList(Message message ){

        Source ds = message.getMetadata().getSource();
        String route = String.format( ROUTE_FORMAT, ds.getName().toLowerCase() );

        return Collections.singletonList( route );
    }
}