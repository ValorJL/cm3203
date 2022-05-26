package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.DAO.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    //save the new user
    User saveUser(User user);
    //Find the user by username
    Optional<User> findByUsername(String username);

}
