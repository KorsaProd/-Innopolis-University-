package ru.pcs.attestation.forms;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import ru.pcs.attestation.models.User;

import javax.validation.constraints.NotEmpty;


@Data
public class UserForm {
    private Integer id;

    @NotEmpty
    @Length(max = 20)
    private String firstName;

    @NotEmpty
    @Length(max = 20)
    private String lastName;

    @NotEmpty
    private String email;

    private String hashPassword;
    private User.Role role;
}
