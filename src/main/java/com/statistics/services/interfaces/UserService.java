package com.statistics.services.interfaces;

import com.statistics.models.enteties.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUserById(Integer id);

    Iterable<User> getAllUsers();

    void insertUser(User user);

    User getUserByEmail(String email);

}
