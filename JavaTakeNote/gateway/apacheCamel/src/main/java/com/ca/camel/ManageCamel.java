package com.ca.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ManageCamel {


    private ManageCamel() {};
    private static ManageCamel instance = null;
    private  RouteBuilder r;

    public static ManageCamel getInstance() {
        if(instance ==null) {
                instance = new ManageCamel();
        }
        return instance;
    }


    public void process() {
        CamelContext camelContext = new DefaultCamelContext();
        try {
            camelContext.addRoutes(r);
            camelContext.start();
            Thread.sleep(5000);
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ManageCamel getObject(RouteBuilder r) {
        this.r = r;
        return this;
    }
}
