package ru.pcs.attestation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorsController {
    @GetMapping("/error/404")
    public String getPage404() {
        return "/errors/error_404";
    }

    @GetMapping("/error/403")
    public String getPage403() {
        return "/errors/error_403";
    }
}
