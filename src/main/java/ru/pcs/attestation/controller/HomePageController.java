package ru.pcs.attestation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.pcs.attestation.models.User;
import ru.pcs.attestation.services.UserService;


@Controller
public class HomePageController {

    private final UserService userService;

    @Autowired
    public HomePageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String getHomePage() {
        User user = userService.getAuthenticatedUser();
        if (user.getRole() == User.Role.CUSTOMER) {
            return "redirect:/customerPage";
        } else if (user.getRole() == User.Role.COMPANY) {
            return "redirect:/companyPage";
        }
        return "redirect:/adminPage";
    }
}
