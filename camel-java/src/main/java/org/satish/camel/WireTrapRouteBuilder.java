package org.satish.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class WireTrapRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:C:/inputFolder").split().tokenize("\n").to("direct:test1");

        from("direct:test1")
                //Wire Tap:Suppose get some error so send seperate copies of the message to
                //DeadLetter queue and also to direct:test2
                .wireTap("jms:queue:other")
                .to("direct:test2");

        from("direct:test2")
                .process(new Processor() {
                    public void process(Exchange arg0) throws Exception {
                        //Some logic here
                    }
                });
    }
}
