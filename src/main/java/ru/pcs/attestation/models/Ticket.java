package ru.pcs.attestation.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String direction;

    private String flightNum;
    private String date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

}
