package pizza.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pizza.User;
import pizza.data.UserRepo;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {

    private UserRepo userRepo;

    @Autowired
    public UserRepositoryUserDetailsService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepo.findByUsername(s);
        if (user!=null){
            return user;
        }
        throw new UsernameNotFoundException("User '" + s + "' not found");
    }
}
