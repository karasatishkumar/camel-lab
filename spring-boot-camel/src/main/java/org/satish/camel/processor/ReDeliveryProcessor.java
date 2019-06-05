package org.satish.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.satish.camel.exception.CamelCustomException;



public class ReDeliveryProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String a = exchange.getIn().getBody(String.class);
        System.out.println("Body: " + a);
        if (a.trim().equalsIgnoreCase("test"))
            throw new CamelCustomException();
    }
}
