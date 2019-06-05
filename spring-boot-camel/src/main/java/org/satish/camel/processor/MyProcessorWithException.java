package org.satish.camel.processor;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.satish.camel.exception.CamelCustomException;

public class MyProcessorWithException implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Exception Thrown");
        throw new CamelCustomException();
    }
}
