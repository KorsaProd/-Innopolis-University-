package ru.pcs.attestation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.pcs.attestation.forms.TicketForm;
import ru.pcs.attestation.models.Ticket;
import ru.pcs.attestation.models.User;
import ru.pcs.attestation.services.TicketService;
import ru.pcs.attestation.services.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CompanyPageController {

    private final TicketService ticketService;
    private final UserService userService;


    @Autowired
    public CompanyPageController(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;

    }

    @GetMapping("/companyPage")
    public String getCompanyPage(Model model) {
        User user = userService.getAuthenticatedUser();
        List<Ticket> ticketsOnSale = ticketService.getAllTicketsByStatus("SALE");
        model.addAttribute("ticketsOnSale", ticketsOnSale);
        model.addAttribute("user", user);
        return "companyPage";
    }

    @PostMapping("/companyPage")
    public String addTicket(@Valid TicketForm form, BindingResult result, RedirectAttributes forRedirectModel) {
        if (result.hasErrors()) {
            forRedirectModel.addFlashAttribute("errors",
                    "Некорректные данные");
            return "redirect:/companyPage";
        }
        Authentication aUser = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = aUser.getName();
        User user = userService.findUserByEmail(userEmail);
        ticketService.addTicket(form, user);
        return "redirect:/companyPage";
    }

    @PostMapping("/companyPage/{ticket-id}/delete")
    public String deleteTicket(@PathVariable("ticket-id") Integer ticketId) {
        ticketService.deleteTicket(ticketId);
        return "redirect:/companyPage";
    }

    @GetMapping("/companyPage/{ticket-id}")
    public String getTicketPage(Model model, @PathVariable ("ticket-id") Integer ticketId) {
        Ticket ticket = ticketService.getTicket(ticketId);
        model.addAttribute(ticket);
        return "ticketPage";
    }

    @PostMapping("/companyPage/companyPage/{ticket-id}/update")
    public String updateTicket(@PathVariable ("ticket-id") Integer ticketId, TicketForm ticketForm) {
        ticketService.updateTicket(ticketId, ticketForm);
        return "redirect:/companyPage";
    }


}
