package com.example.demo;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class FtpToJMSRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		// load file orders from data/inbox into the JMS queue
		from("file:data/inbox?noop=true")
			.to("jms:incomingOrders")
			.process((Exchange exchange) -> {
				System.out.println("WOOOOOOORRKKKKKKKKKKINGGGGGGGGGG--------------------");
			});
		
		// content based routing
		from("jms:incomingOrder")
		.choice()
			.when(header("CamelFileName").endsWith(".xml"))
				.to("jms:xmlOrders")
			.when(header("CamelFileName").endsWith(".csv"))
				.to("jms:csvOrders");
		
		// test that the route is working
		from("jms:xmlOrders")
			.process((Exchange exchange) -> {
				System.out.println("Received XML Order: " +
						exchange.getIn().getHeader("CamelFileName"));
			});
		
		from("jms:csvOrders")
			.process((Exchange exchange) -> {
				System.out.println("Received CSV Order: " +
						exchange.getIn().getHeader("CamelFileName"));	
			});
	}
}
