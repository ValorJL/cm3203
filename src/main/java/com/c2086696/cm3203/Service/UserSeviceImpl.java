package com.c2086696.cm3203.Service;

import com.c2086696.cm3203.DAO.User;
import com.c2086696.cm3203.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSeviceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserSeviceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    //save the new user
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
    //find the user by username
    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }
    //Verify user information
    @Override
    public boolean verifyLogin(User user) {
        List<User> userList = userRepository.findByNameAndPassword(user.getName(),user.getPassword());
        return  userList.size()>0;
    }

}
