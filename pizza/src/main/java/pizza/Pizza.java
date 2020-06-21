package pizza;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
   // @NotBlank(message = "Dough is required")
    private Dough dough;

    @Enumerated(EnumType.STRING)
    //@NotBlank(message = "Base Sauce is required")
    private BaseSauce baseSauce;

    @Enumerated(EnumType.STRING)
    //@NotBlank(message = "Cheese is required")
    private Cheese cheese;

    //@NotBlank(message = "cant be null")
    private String instructions;

    @ManyToMany(targetEntity = Topping.class)
    //@Size(min = 3,message = "At least 3 toppings")
    private List<Topping> toppings=new ArrayList<>();

    public void addTopping(Topping t){
        toppings.add(t);
    }

    public static enum Dough{
        REGULAR,THICK,THIN
    }
    public static enum BaseSauce{
        BUFFALOBLUE,CREAMYGARLIC
    }
    public static enum Cheese{
        MOZZARRELA, FOURCHEESE
    }

}
