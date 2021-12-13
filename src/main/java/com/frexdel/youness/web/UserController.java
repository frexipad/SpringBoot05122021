package com.frexdel.youness.web;

import com.frexdel.youness.dao.UserRepository;
import com.frexdel.youness.model.ResponseHandler;
import com.frexdel.youness.model.User;
import com.frexdel.youness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    // Add
    @PostMapping(value = "add")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        try {
            if (user.getEmail().length()<=0)return ResponseHandler.generateResponse("Email is required !!", HttpStatus.BAD_REQUEST, null);
            User savedUser = userService.addUser(user);
            return ResponseHandler.generateResponse("User saved successfully",HttpStatus.OK,savedUser);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // Get
    @GetMapping(value = "/users")
    public ResponseEntity<Object> Get() {
        try {
            List<User> result = userService.getAllUser();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    // Get By ID
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Object> Get(@PathVariable Long id) {
        try {
            Optional<User> userById = userService.getUserById(id);
            if (userById.isPresent()){
                return ResponseHandler.generateResponse("request successfuly ",HttpStatus.OK,userById);
            }else {
                return new ResponseEntity<Object>("User not found",HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // Update
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<Object> Update(@PathVariable int id, @RequestBody User params) {
        try {
            User userByID = userRepository.findById(Long.valueOf(id)).orElse(null);
            if (!(userByID ==null))return ResponseHandler.generateResponse("User dont Exist!!",HttpStatus.MULTI_STATUS,null);
            userRepository.save(userByID);
            return ResponseHandler.generateResponse("Updated", HttpStatus.OK, userByID);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // Delete
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Object> Delete(@PathVariable int id) {
        try {
            User userByID = userRepository.findById(Long.valueOf(id)).orElse(null);
            if (!(userByID ==null))return ResponseHandler.generateResponse("User dont Exist!!",HttpStatus.MULTI_STATUS,null);
            userRepository.delete(userByID);
            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, userByID);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    }
