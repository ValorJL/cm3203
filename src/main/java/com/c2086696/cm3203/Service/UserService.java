package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.Entity.User;

import java.util.List;

public interface UserService {
    //add new user
    void saveUser(User user);

    //had this name exist?
    List<User> findByName(String name);

}
