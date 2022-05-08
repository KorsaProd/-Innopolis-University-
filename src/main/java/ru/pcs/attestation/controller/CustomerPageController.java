package ru.pcs.attestation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.pcs.attestation.forms.TicketForm;
import ru.pcs.attestation.models.Ticket;
import ru.pcs.attestation.models.User;
import ru.pcs.attestation.services.TicketService;
import ru.pcs.attestation.services.UserService;

import java.util.List;

@Controller
public class CustomerPageController {

    private final UserService userService;
    private final TicketService ticketService;

    @Autowired
    public CustomerPageController(UserService userService, TicketService ticketService) {
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @GetMapping("/customerPage")
    public String getCustomerPage(Model model) {
        User user = userService.getAuthenticatedUser();
        List<Ticket> ticketsOnSale = ticketService
                .getAllTicketsByStatus("SALE");
        List<Ticket> ticketsOnRequestByOwner = ticketService
                .getAllTicketsByStatusAndOwner("PROCESSING", user);
        List<Ticket> conformedTickets = ticketService
                .getAllTicketsByStatusAndOwner("CONFORMED", user);
        List<Ticket> rejectedRequestsToReturn = ticketService
                .getAllTicketsByStatusAndOwner("REJECTED RETURN", user);
        List<Ticket> requestsToReturn = ticketService.getAllRequestsToReturnByOwner(user);
        model.addAttribute("conformedTickets", conformedTickets);
        model.addAttribute("ticketsOnSale", ticketsOnSale);
        model.addAttribute("ticketsOnRequestByOwner", ticketsOnRequestByOwner);
        model.addAttribute("requestsToReturn", requestsToReturn);
        model.addAttribute("rejectedReturns", rejectedRequestsToReturn);
        model.addAttribute("user", user);
        return "customerPage";
    }

    @PostMapping("/customerPage/{ticket-id}/buy")
    public String addTicketToRequest(@PathVariable("ticket-id") Integer tickedId) {
        User user = userService.getAuthenticatedUser();
        Ticket ticket = ticketService.getTicket(tickedId);
        ticketService.addTicketToRequestForUser(ticket, user);
        return "redirect:/customerPage";
    }

    @GetMapping("/customerPage/{ticket-id}")
    public String getTicketPage(Model model, @PathVariable("ticket-id") Integer ticketId) {
        Ticket ticket = ticketService.getTicket(ticketId);
        model.addAttribute("ticket", ticket);
        return "ticketPageForCustomer";
    }

    @PostMapping("customerPage/customerPage/{ticket-id}/return")
    public String requestToReturnTicket(TicketForm form, @PathVariable("ticket-id") Integer ticketId) {
        Ticket ticket = ticketService.getTicket(ticketId);
        ticketService.setStatus(ticket, form);
        return "redirect:/ticketPageForCustomer";
    }

    @GetMapping("/ticketPageForCustomer")
    public String getTicketPageForCustomer() {
        return "redirect:/customerPage";
    }
}