package ansarbektassov.service;

import ansarbektassov.model.StadiumSector;
import ansarbektassov.model.Ticket;

import java.math.BigDecimal;
import java.util.*;

public class TicketService {

    private final Map<String, Ticket> tickets;

    public TicketService() {
        this.tickets = new HashMap<>();
    }

    public String save(Ticket ticket) {
        this.tickets.put(ticket.getId(),ticket);
        return ticket.getId();
    }

    public Collection<Ticket> findAll() {
        return tickets.values();
    }

    public static void main(String[] args) {
        Ticket emptyTicket = new Ticket();
        Ticket fullTicket = new Ticket("3454A","1234567890",303,
                System.currentTimeMillis()/1000L,true, StadiumSector.B,
                20.2,new BigDecimal(150));
        Ticket limitedTicket = new Ticket("1234567890",305,System.currentTimeMillis()/1000L);

        TicketService ticketService = new TicketService();
        ticketService.save(emptyTicket);
        ticketService.save(fullTicket);
        ticketService.save(limitedTicket);

        System.out.println(ticketService.findAll());

    }
}
