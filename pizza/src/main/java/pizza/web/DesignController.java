package pizza.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pizza.Bestellung;
import pizza.Pizza;
import pizza.Topping;
import pizza.data.PizzaRepository;
import pizza.data.ToppingRepo;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@SessionAttributes("bestellung")
public class DesignController {
    @Autowired
    PizzaRepository pizzaRepo;
    @Autowired
    ToppingRepo toppingRepo;

    @ModelAttribute(name = "design")
    public Pizza design() {
        return new Pizza();
    }
    @ModelAttribute(name = "bestellung")
    public Bestellung bestellung(){
        return new Bestellung();
    }



    @GetMapping("/create")
    public String showDesignForm(Model model){
        List<Topping> toppingVeggie=new ArrayList<>();
        List<Topping> toppingMeat=new ArrayList<>();
        List<Topping> toppingCheese=new ArrayList<>();
        toppingRepo.findAll().forEach(t->{
            if(t.getType().equals(Topping.Type.VEGGIE)) toppingVeggie.add(t);
            else if(t.getType().equals(Topping.Type.MEAT)) toppingMeat.add(t);
            else if(t.getType().equals(Topping.Type.CHEESE)) toppingCheese.add(t);
        });
        model.addAttribute("veggie",toppingVeggie);
        model.addAttribute("meat",toppingMeat);
        model.addAttribute("cheese",toppingCheese);


        return "design";
    }

    @PostMapping("/save-design")
    public String processPizza(@Valid @ModelAttribute("design") Pizza design, Errors errors,
                               @ModelAttribute("bestellung") Bestellung bestellung){
        if (errors.hasErrors()){
            log.info(errors.toString());
            return "design";
        }
        log.info("Form pizza"+design);
        pizzaRepo.save(design);
        bestellung.addPizzaz(design);
        //log.info(bestellung.toString());
        return "redirect:/order-form";
    }

}
