package org.camel.examples.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessorDirectB implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getMessage().setBody("direct-b-id");
    }
}
