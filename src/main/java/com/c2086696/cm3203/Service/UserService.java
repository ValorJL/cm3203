package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    //add new user
    User saveUser(User user);

    //had this name exist?
    Optional<User> findByUsername(String username);

}
