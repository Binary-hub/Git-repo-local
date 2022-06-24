package org.simpletransformer.util;


import java.util.Map;
import org.simpletransformer.domain.Ticket;
import org.springframework.stereotype.Component;


@Component 
public class MapToObject {

	public Ticket map(Map<String,String> message) {
		Ticket ticket = new Ticket();
		ticket.setTicketId(message.get("ticketId"));
		ticket.setDescription(message.get("description"));

		return ticket;
	}

}
