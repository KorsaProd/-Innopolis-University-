package ru.pcs.attestation.forms;

import lombok.Data;
import ru.pcs.attestation.models.User;

import javax.validation.constraints.NotEmpty;

@Data
public class TicketForm {
    @NotEmpty
    private String direction;
    @NotEmpty
    private String flightNum;
    @NotEmpty
    private String date;

    private String status;
    private User owner;
}
