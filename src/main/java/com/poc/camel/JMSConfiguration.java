package com.poc.camel;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.poc.camel.utility.JmsReceiver;
import com.poc.camel.utility.JmsSender;

@Configuration
public class JMSConfiguration {
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setDefaultDestination(new ActiveMQQueue("jms.queue"));
		jmsTemplate.setConnectionFactory(connectionFactory());
		return jmsTemplate;
	}

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
		return activeMQConnectionFactory;
	}

	@Bean
	public JmsSender jmsSender() {
		JmsSender jmsSender = new JmsSender();
		jmsSender.setJmsTemplate(jmsTemplate());
		return jmsSender;
	}

	@Bean
	public JmsReceiver jmsReceiver() {
		return new JmsReceiver();
	}

	@Bean
	public DefaultMessageListenerContainer messageListenerContainer() {
		DefaultMessageListenerContainer messageListenerContainer = new DefaultMessageListenerContainer();
		messageListenerContainer.setConnectionFactory(connectionFactory());
		messageListenerContainer.setDestinationName("jms.queue");
		messageListenerContainer.setMessageListener(jmsReceiver());
		return messageListenerContainer;
	}
}