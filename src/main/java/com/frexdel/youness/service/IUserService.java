package com.frexdel.youness.service;

import com.frexdel.youness.model.User;

import java.util.List;

public interface IUserService {

    public User addUser(User user);
    public List<User> getAllUser();
    public User getUserById(Long id);
    public User saveOrUpDateUser(User user);
    public void deleteUserById(User user);
    public User findUserByFirsNameOrLastName(String name);
}
