package pizza.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import pizza.Bestellung;
import pizza.User;
import pizza.data.BestellungRepo;

import javax.validation.Valid;

@Slf4j
@Controller
@SessionAttributes("bestellung")
public class BestellungController {

    @Autowired
    BestellungRepo bestellungRepo;

    @GetMapping("/order-form")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping("save-form")
    public String processOrder(@Valid @ModelAttribute("bestellung")Bestellung bestellung,
                               Errors errors, SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user){
        if (errors.hasErrors()){
            return "orderForm";
        }
        bestellung.setUser(user);
        log.info(bestellung.toString());
        bestellungRepo.save(bestellung);
        sessionStatus.setComplete();
        return "redirect:/create";
    }
}
