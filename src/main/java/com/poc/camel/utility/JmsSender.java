package com.poc.camel.utility;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JmsSender {
	private JmsTemplate jmsTemplate;

	public void sendMessage(final String msg) {
		jmsTemplate.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage(msg);
			}
		});
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	} 
}
