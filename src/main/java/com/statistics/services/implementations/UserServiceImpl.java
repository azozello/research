package com.statistics.services.implementations;

import com.statistics.models.enteties.User;
import com.statistics.repositories.UserRepository;
import com.statistics.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        Iterable<User> allUsers = userRepository.findAll();
        for (User user : allUsers){
            if (user.getEmail().equals(email)) return user;
        }
        return null;
    }

    @Override
    public void insertUser(User user) {
        userRepository.save(user);
    }
}
