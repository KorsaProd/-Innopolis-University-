package ru.pcs.attestation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.attestation.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
