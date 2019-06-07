package org.satish.camel;

        import org.apache.camel.Exchange;
        import org.apache.camel.Processor;
        import org.apache.camel.builder.RouteBuilder;

public class RecipientListRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/i339952/Desktop/source?noop=true").split().tokenize("\n").to("direct:hub");

        //Recipient List- Dynamically set the recipients of the exchange
        //by creating the queue name at runtime
        from("direct:hub")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        String recipient = exchange.getIn().getBody().toString();
                        String recipientQueue = "jms:queue:" + recipient;
                        exchange.getIn().setHeader("queue", recipientQueue);
                    }
                }).recipientList(header("queue"));
    }
}
