package org.satish.camel;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/i339952/Desktop/source?noop=true").to("file:/Users/i339952/Desktop/destination");
    }
}
