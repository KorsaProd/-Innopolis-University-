package ru.pcs.attestation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.attestation.models.Ticket;
import ru.pcs.attestation.models.User;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findAllByStatusAndOwner(String status, User owner);
    List<Ticket> findAllByStatusContains(String containsInStatus);
    List<Ticket> findAllByStatus(String status);
    List<Ticket> findAllByStatusContainsAndOwner(String statusContains, User owner);
}
