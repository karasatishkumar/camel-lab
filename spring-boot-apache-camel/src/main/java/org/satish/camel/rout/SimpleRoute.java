package org.satish.camel.rout;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/i339952/Desktop/source?noop=true").to("file:/Users/i339952/Desktop/destination");
    }
}
