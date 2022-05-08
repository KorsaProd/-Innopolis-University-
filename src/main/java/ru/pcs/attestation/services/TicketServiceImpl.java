package ru.pcs.attestation.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.attestation.exceptions.TicketNotFoundException;
import ru.pcs.attestation.forms.TicketForm;
import ru.pcs.attestation.models.Ticket;
import ru.pcs.attestation.models.User;
import ru.pcs.attestation.repositories.TicketRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public void addTicket(TicketForm form, User user) {
        Ticket ticket = Ticket.builder()
                .direction(form.getDirection())
                .flightNum(form.getFlightNum())
                .date(form.getDate())
                .status("SALE")
                .owner(user)
                .build();

        ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Integer ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    @Override
    public Ticket getTicket(Integer ticketId) {
        return ticketRepository.findById(ticketId).orElseThrow(TicketNotFoundException::new);
    }

    @Override
    public void updateTicket(Integer ticketId, TicketForm ticketForm) {
        Ticket ticket = ticketRepository.getById(ticketId);
        ticket.setDirection(ticketForm.getDirection());
        ticket.setFlightNum(ticketForm.getFlightNum());
        ticket.setDate(ticketForm.getDate());
        ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTicketsByStatusAndOwner(String status, User owner) {
        return ticketRepository.findAllByStatusAndOwner(status, owner);
    }

    @Override
    public void addTicketToRequestForUser(Ticket ticket, User user) {
        ticket.setOwner(user);
        ticket.setStatus("PROCESSING");
        ticketRepository.save(ticket);
    }


    @Override
    public void conformRequest(Ticket ticket) {
        ticket.setStatus("CONFORMED");
        ticketRepository.save(ticket);
    }

    @Override
    public void declineRequest(Ticket ticket) {
        ticket.setStatus("SALE");
        ticketRepository.save(ticket);
    }

    @Override
    public void setStatus(Ticket ticket, TicketForm form) {
        ticket.setStatus("PROCESSING" + " ReturnCause: " + form.getStatus());
        ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllRequestsToReturn() {
        return ticketRepository.findAllByStatusContains("ReturnCause: ");
    }

    @Override
    public List<Ticket> getAllTicketsByStatus(String status) {
        return ticketRepository.findAllByStatus(status);
    }

    @Override
    public List<Ticket> getAllRequestsToReturnByOwner(User owner) {
        return ticketRepository.findAllByStatusContainsAndOwner("ReturnCause: ", owner);
    }

    @Override
    public void declineRequestToReturn(Ticket ticket) {
        ticket.setStatus("REJECTED RETURN");
        ticketRepository.save(ticket);
    }
}
