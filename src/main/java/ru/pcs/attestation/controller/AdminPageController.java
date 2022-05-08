package ru.pcs.attestation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.pcs.attestation.models.Ticket;
import ru.pcs.attestation.models.User;
import ru.pcs.attestation.services.TicketService;
import ru.pcs.attestation.services.UserService;

import java.util.List;

@Controller
public class AdminPageController {

    private final TicketService ticketService;
    private final UserService userService;

    @Autowired
    public AdminPageController(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @GetMapping("/adminPage")
    public String getAdminPage(Model model) {
        User user = userService.getAuthenticatedUser();
        List<Ticket> requests = ticketService.getAllTicketsByStatus("PROCESSING");
        List<Ticket> requestsToReturn = ticketService.getAllRequestsToReturn();
        model.addAttribute("user", user);
        model.addAttribute("requests", requests);
        model.addAttribute("requestsToReturn", requestsToReturn);
        return "adminPage";
    }


    @PostMapping("/adminPage/{request-id}/Conform")
    public String conformRequest(@PathVariable("request-id") Integer requestId) {
        Ticket ticket = ticketService.getTicket(requestId);
        ticketService.conformRequest(ticket);
        return "redirect:/adminPage";
    }

    @PostMapping("/adminPage/{request-id}/Decline")
    public String declineRequest(@PathVariable("request-id") Integer requestId) {
        Ticket ticket = ticketService.getTicket(requestId);
        ticketService.declineRequest(ticket);
        return "redirect:/adminPage";
    }

    @PostMapping("/adminPage/{request-id}/ReturnDecline")
    public String declineRequestToReturn(@PathVariable("request-id") Integer requestId) {
        Ticket ticket = ticketService.getTicket(requestId);
        ticketService.declineRequestToReturn(ticket);
        return "redirect:/adminPage";
    }
}
