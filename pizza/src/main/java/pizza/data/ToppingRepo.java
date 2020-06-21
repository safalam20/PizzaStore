package pizza.data;

import org.springframework.data.repository.CrudRepository;
import pizza.Topping;

public interface ToppingRepo extends CrudRepository<Topping, Long> {

}
