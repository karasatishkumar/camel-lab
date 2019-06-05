package org.satish.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.satish.camel.processor.MyProcessor;

public class SimpleRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/i339952/Desktop/source?noop=true").process(new MyProcessor()).to("file:/Users/i339952/Desktop/destination");
    }
}
