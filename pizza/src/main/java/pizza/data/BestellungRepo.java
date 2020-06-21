package pizza.data;

import org.springframework.data.repository.CrudRepository;
import pizza.Bestellung;

public interface BestellungRepo extends CrudRepository<Bestellung,Long> {

}
