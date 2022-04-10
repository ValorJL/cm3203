package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    //add new user
    void saveUser(User user);

    //had this name exist?
    Optional<User> findByName(String name);

    boolean verifyLogin(User user);
}
