package com.redhat.camel.blueprint.sample;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.log4j.Logger;

public class MyAggregationStrategy implements AggregationStrategy {
	
	private Logger logger = Logger.getLogger(this.getClass());

	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		logger.info("INTO AGGREGATE METHOD..........................................");
		// (Exchange oldExchange, Exchange newExchange)
		if (oldExchange == null) {
			logger.info("inside the oldexchnage=null condition");
			return newExchange;
		}
		Message newIn = newExchange.getIn();
		logger.info("after getting messages from new ex: message="+newIn);
		String oldBody = oldExchange.getIn().getBody(String.class);
		logger.info("after old body");
		String newBody = newIn.getBody(String.class);
		logger.info("after new body");
		newIn.setBody(oldBody + newBody);
		logger.info("after setting both bodies..");
		return newExchange;
	}

}