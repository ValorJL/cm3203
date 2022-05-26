package com.c2086696.cm3203.Repository;

import com.c2086696.cm3203.DAO.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    //Find the user by username
    Optional<User> findByName(String name);
    //Find the user by username and password
    List<User> findByNameAndPassword(String name,String password);

}