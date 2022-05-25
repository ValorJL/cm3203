package com.c2086696.cm3203.Repository;

import com.c2086696.cm3203.DAO.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByName(String name);
    List<User> findByNameAndPassword(String name,String password);
}