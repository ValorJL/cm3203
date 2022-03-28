package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.Entity.User;
import com.c2086696.cm3203.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSeviceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByUserName(name);
    }
}
