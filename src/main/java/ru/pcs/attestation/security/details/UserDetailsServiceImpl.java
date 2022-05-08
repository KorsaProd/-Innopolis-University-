package ru.pcs.attestation.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.pcs.attestation.exceptions.UserNotFoundException;
import ru.pcs.attestation.models.User;
import ru.pcs.attestation.repositories.UserRepository;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UserNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        return new UserDetailsImpl(user);
    }
}
