package org.satish.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.satish.camel.exception.CamelCustomException;
import org.satish.camel.processor.ReDeliveryCorrectionProcessor;
import org.satish.camel.processor.ReDeliveryProcessor;

public class ReDeliveryRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        onException(CamelCustomException.class).process(new Processor() {

            public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
        }).onRedelivery(new ReDeliveryCorrectionProcessor()).redeliveryPolicyRef("testRedeliveryPolicyProfile").log("Received body ").handled(true);

        from("file:/Users/i339952/Desktop/source?noop=true").process(new ReDeliveryProcessor()).to("file:/Users/i339952/Desktop/destination");
    }
}
