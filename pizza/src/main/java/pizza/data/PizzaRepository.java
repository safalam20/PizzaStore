package pizza.data;

import org.springframework.data.repository.CrudRepository;
import pizza.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza,Long> {

}
