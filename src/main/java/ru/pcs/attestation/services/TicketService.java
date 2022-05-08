package ru.pcs.attestation.services;

import ru.pcs.attestation.forms.TicketForm;
import ru.pcs.attestation.models.Ticket;
import ru.pcs.attestation.models.User;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    void addTicket(TicketForm form, User user);
    void deleteTicket(Integer ticketId);
    Ticket getTicket(Integer ticketId);
    void updateTicket(Integer ticketId, TicketForm ticketForm);
    void addTicketToRequestForUser(Ticket ticket, User user);
    List<Ticket> getAllTicketsByStatusAndOwner(String status, User owner);
    void conformRequest(Ticket ticket);
    void declineRequest(Ticket ticket);
    void setStatus(Ticket ticket, TicketForm form);
    List<Ticket> getAllRequestsToReturn();
    List<Ticket> getAllTicketsByStatus(String status);
    List<Ticket> getAllRequestsToReturnByOwner(User owner);
    void declineRequestToReturn(Ticket ticket);
}
