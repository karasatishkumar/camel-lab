package org.satish.camel;

import org.apache.camel.builder.RouteBuilder;

public class ActiveMQRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/i339952/Desktop/source?noop=true").split().tokenize("\n").to("jms:queue:satish");
    }
}
