package com.frexdel.youness.service;

import com.frexdel.youness.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public User addUser(User user);
    public List<User> getAllUser();
    public Optional<User> getUserById(Long id);
    public User saveOrUpDateUser(User user);
    public void deleteUserById(User user);
    public User findUserByFirsNameOrLastName(String name);
}
