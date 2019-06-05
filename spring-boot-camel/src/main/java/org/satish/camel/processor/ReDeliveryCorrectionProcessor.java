package org.satish.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ReDeliveryCorrectionProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody("test1");
    }
}
