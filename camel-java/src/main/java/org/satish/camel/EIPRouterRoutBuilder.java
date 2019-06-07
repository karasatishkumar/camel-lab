package org.satish.camel;

import org.apache.camel.builder.RouteBuilder;

public class EIPRouterRoutBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/i339952/Desktop/source?noop=true").split().tokenize("\n").to("direct:router");

        //Content Based routing- Route the message based on the token it contains.
        from("direct:router").
                choice().
                when(body().contains("satish"))
                .to("jms:queue:satish").
                when(body().contains("suchi"))
                .to("jms:queue:suchi")
                .when(body().contains("myra"))
                .to("jms:queue:myra").
                otherwise().
                to("jms:queue:other");
    }
}
