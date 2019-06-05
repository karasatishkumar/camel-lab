package org.satish.camel;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

public class ActiveMQApp {
    public static void main(String[] args) {
        ActiveMQRouteBuilder routeBuilder = new ActiveMQRouteBuilder();
        CamelContext ctx = new DefaultCamelContext();

        //configure jms component
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        try {
            ctx.addRoutes(routeBuilder);
            ctx.start();
            Thread.sleep(5 * 60 * 1000);
            ctx.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
