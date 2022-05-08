package ru.pcs.attestation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.pcs.attestation.forms.UserForm;
import ru.pcs.attestation.models.User;
import ru.pcs.attestation.services.UserService;

import javax.validation.Valid;

@Controller
public class UserPageController {

    private final UserService userService;

    @Autowired
    public UserPageController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/userPage")
    public String getUserProfilePage(Model model) {
        User user = userService.getAuthenticatedUser();
        model.addAttribute("user", user);
        return "userPage";
    }

    @PostMapping("/userPage/update")
    public String updateUser(@Valid UserForm form, BindingResult result, RedirectAttributes forRedirectModel) {
        if (result.hasErrors()) {
            forRedirectModel.addFlashAttribute("errors",
                    "Некорректные данные");
            return "redirect:/userPage";
        }
        User user = userService.getAuthenticatedUser();
        userService.updateUser(form, user);
        return "redirect:/userPage";
    }
}
