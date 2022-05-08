package ru.pcs.attestation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.pcs.attestation.forms.SignUpForm;
import ru.pcs.attestation.models.User;
import ru.pcs.attestation.repositories.UserRepository;

@Component
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void signUpUser(SignUpForm form) {
        User user = User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .role(form.getRole())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .build();

        userRepository.save(user);
    }
}
