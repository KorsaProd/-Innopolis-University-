package ru.pcs.attestation.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pcs.attestation.forms.SignUpForm;
import ru.pcs.attestation.services.SignUpService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/signUp")
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping
    private String getSignUpPage() {
        return "signUp";
    }

    @PostMapping
    private String signUpUser(SignUpForm form) {
        signUpService.signUpUser(form);
        return "redirect:/signIn";
    }
}
