package com.frexdel.youness.service;

import com.frexdel.youness.dao.UserRepository;
import com.frexdel.youness.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = userRepository.findAll();
        if (userList.size()>0){
            return userList;
        }else {
            return new ArrayList<User>();
        }
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
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
