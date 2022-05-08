package ru.pcs.attestation.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class User {

    public enum Role {
        CUSTOMER, ADMIN, COMPANY
    }

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String email;

    private String hashPassword;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "owner")
    private List<Ticket> tickets;
}
