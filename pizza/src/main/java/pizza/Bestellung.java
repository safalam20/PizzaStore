package pizza;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Bestellung {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @NotBlank(message = "Can't be empty!")
    private String firstName;

    @NotBlank(message = "Can't be empty!")
    private String lastName;
    
    @Min(value = 1,message = "Fake number")
    private int hausNummer;

    @NotBlank(message = "Can't be empty!")
    private String streetName;
    
    @NotBlank(message = "Can't be empty!")
    private String cityName;

    @Digits(integer = 5,fraction = 0,message = "Invalid Number")
    private String postCode;

    @ManyToMany(targetEntity = Pizza.class)
    private List<Pizza> pizzas=new ArrayList<>();

    public void addPizzaz(Pizza pizza){
        pizzas.add(pizza);
    }


}
