package org.satish.camel;

import org.apache.camel.builder.RouteBuilder;

public class EIPFilterRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/i339952/Desktop/source?noop=true").split().tokenize("\n").to("direct:test");

        //Message Filter is a type of Content Based routing.
        //If condition satisfied perform a task else discard it.
        from("direct:test").
                filter(body().contains("satish"))
                .to("jms:queue:other");
    }
}
