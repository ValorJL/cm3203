package com.c2086696.cm3203.Repository;

import com.c2086696.cm3203.DAO.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //find the user by username
    Optional<User> findByUsername(String username);
}