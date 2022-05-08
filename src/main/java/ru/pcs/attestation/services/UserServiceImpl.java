package ru.pcs.attestation.services;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.pcs.attestation.exceptions.UserNotFoundException;
import ru.pcs.attestation.forms.UserForm;
import ru.pcs.attestation.models.User;
import ru.pcs.attestation.repositories.UserRepository;


@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication aUser = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = aUser.getName();
        User user = userRepository.findByEmail(userEmail).orElseThrow(UserNotFoundException::new);
        return user;
    }

    @Override
    public void updateUser(UserForm form, User user) {
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        userRepository.save(user);
    }

}
