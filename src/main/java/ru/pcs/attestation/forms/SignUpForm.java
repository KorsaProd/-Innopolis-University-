package ru.pcs.attestation.forms;

import lombok.Data;
import ru.pcs.attestation.models.User;

import javax.validation.constraints.NotEmpty;

@Data
public class SignUpForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private User.Role role;
}

