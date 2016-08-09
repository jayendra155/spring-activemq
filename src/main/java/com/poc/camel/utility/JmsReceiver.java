package com.poc.camel.utility;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class JmsReceiver implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		//long time=System.nanoTime();
		TextMessage message=(TextMessage) msg;
		try {
			System.out.println("Recieved message : " + message.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
