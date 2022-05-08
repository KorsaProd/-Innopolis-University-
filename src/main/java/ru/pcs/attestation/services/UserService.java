package ru.pcs.attestation.services;

import ru.pcs.attestation.forms.UserForm;
import ru.pcs.attestation.models.User;

import java.util.List;

public interface UserService {
    User findUserByEmail(String userEmail);
    User getAuthenticatedUser();
    void updateUser(UserForm form, User user);
}
