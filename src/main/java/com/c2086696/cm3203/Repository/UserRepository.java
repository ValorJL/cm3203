package com.c2086696.cm3203.Repository;

import com.c2086696.cm3203.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByUserName(String userName);
}