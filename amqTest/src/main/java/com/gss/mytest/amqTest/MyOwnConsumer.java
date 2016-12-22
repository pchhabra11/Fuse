package com.gss.mytest.amqTest;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MyOwnConsumer {

	private static String url = "tcp://localhost:61618";
	private static String userName = "admin";
	private static String password = "admin";
	private static String queueName = "PulkitQueue"; // Queue Name

	public static void main(String[] args) throws JMSException {
		// Getting JMS connection from the server
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(userName,password,url);
		Connection connection = connectionFactory.createConnection();
		connection.start();

		// Creating session for seding messages
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// Getting the queue 'VALLYSOFTQ'
		Destination destination = session.createQueue(queueName);

		// MessageConsumer is used for receiving (consuming) messages
		MessageConsumer consumer = session.createConsumer(destination);

		// Here we receive the message.
		// By default this call is blocking, which means it will wait
		// for a message to arrive on the queue.
		Message message = consumer.receive();

		// There are many types of Message and TextMessage
		// is just one of them. Producer sent us a TextMessage
		// so we must cast to it to get access to its .getText()
		// method.
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			System.out.println("Receivedage '" + textMessage.getText() + "'");
		}
		connection.close();
	}
}
