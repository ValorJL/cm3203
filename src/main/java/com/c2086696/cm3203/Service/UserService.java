package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.DAO.User;
import java.util.Optional;

public interface UserService {
    //save the new user
    void saveUser(User user);
    //find the user by username
    Optional<User> findByName(String name);
    //Verify user information
    boolean verifyLogin(User user);
}
