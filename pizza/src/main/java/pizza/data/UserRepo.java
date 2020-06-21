package pizza.data;

import org.springframework.data.repository.CrudRepository;
import pizza.User;

public interface UserRepo extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
