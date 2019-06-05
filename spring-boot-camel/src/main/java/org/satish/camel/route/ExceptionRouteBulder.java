package org.satish.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.satish.camel.exception.CamelCustomException;
import org.satish.camel.processor.MyProcessorWithException;

public class ExceptionRouteBulder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/i339952/Desktop/source?noop=true").doTry().process(new MyProcessorWithException()).to("file:/Users/i339952/Desktop/destination").doCatch(CamelCustomException.class).process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
        }).log("Received Body");
    }

    /**
     * Exception Handling if more number of routes are available
     * @throws Exception
     */
    /*@Override
    public void configure() throws Exception {

        onException(CamelCustomException.class).process(new Processor() {

            public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
        }).log("Received body ").handled(true);

        from("file:/Users/i339952/Desktop/source1?noop=true").process(new MyProcessorWithException()).to("file:/Users/i339952/Desktop/destination");

        from("file:/Users/i339952/Desktop/source2?noop=true").process(new MyProcessorWithException()).to("file:/Users/i339952/Desktop/destination");
    }*/
}
