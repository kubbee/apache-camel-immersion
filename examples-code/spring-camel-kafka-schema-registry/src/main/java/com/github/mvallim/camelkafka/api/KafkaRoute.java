package com.github.mvallim.camelkafka.api;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.mvallim.camelkafka.model.People;

@Component
class KafkaRoute extends RouteBuilder {

	@Override
	public void configure() {
		/*
		from("TopicTest").process(new Processor() {
			@Override
			public void process(final Exchange exchange) throws Exception {
				System.out.println("Message Body : " + exchange.getIn().getBody());
			}
		});

		from("timer://producer?period=5000")
				.process(exchange -> {
					exchange.getIn().setBody(new People("Familia"));
				})
				.to("TopicTest");

		 */
	}

}
