package org.simpletransformer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;

@SpringBootApplication
public class SimpletransformerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpletransformerApplication.class, args);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("transformer-context.xml");
		MessageChannel input = context.getBean("input", MessageChannel.class);
		PollableChannel output = context.getBean("output", PollableChannel.class);

		Map<String, String> ticketMap = new HashMap<String, String>();
		ticketMap.put("ticketId", "1001");
		ticketMap.put("description", "First ticket");
		System.out.println("Sent: " + ticketMap);
		
		input.send(MessageBuilder.withPayload(ticketMap).build());
		System.out.println("received " + output.receive().getPayload());


		context.close();
	}
}
