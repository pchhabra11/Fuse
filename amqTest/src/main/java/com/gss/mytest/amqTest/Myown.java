package com.gss.mytest.amqTest;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Myown {

	private static String url = "tcp://localhost:61618";
	private static String userName = "admin";
	private static String password = "admin";
	private static String queueName = "PulkitQueue"; //Queue Name
	
	public static void main(String[] args) throws JMSException {
		// Getting JMS connection from the server and starting it
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(userName,password,url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		// JMS messages are sent and received using a Session. We will
		// create here a non-transactional session object. If you want
		// to use transactions you should set the first parameter to 'true'
		Session session = connection.createSession(false,
		Session.AUTO_ACKNOWLEDGE);
		// Destination represents here our queue 'VALLYSOFTQ' on the
		// JMS server. You don't have to do anything special on the
		// server to create it, it will be created automatically.
		Destination destination = session.createQueue(queueName);
		// MessageProducer is used for sending messages (as opposed
		// to MessageConsumer which is used for receiving them)
		MessageProducer producer = session.createProducer(destination);
		// We will send a small text message saying 'Hello' in Japanese
		TextMessage message = session.createTextMessage("1294yeohrewjhr");
	
		//message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
		System.out.println(message.getJMSDeliveryMode()+"DeliveryMode.....");
		// Here we are sending the message!
		producer.send(message,1,1,100000000);
		System.out.println("Sentage '" + message.getText() + "'"+".........!!!!!!!"+message.getJMSDeliveryMode());

		connection.close();
		}
	
}
