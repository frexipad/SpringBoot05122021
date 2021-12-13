package com.frexdel.youness.service;

import com.frexdel.youness.dao.UserRepository;
import com.frexdel.youness.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User saveOrUpDateUser(User user) {
        return null;
    }

    @Override
    public void deleteUserById(User user) {

    }

    @Override
    public User findUserByFirsNameOrLastName(String name) {
        return null;
    }
}
