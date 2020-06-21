package pizza;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@Entity
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;

    @Enumerated(EnumType.STRING)
    private final Type type;

    private final String name;

    private final int calories;


    public static enum Type{
        VEGGIE,MEAT,CHEESE
    }
}
