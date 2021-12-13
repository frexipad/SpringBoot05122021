package com.frexdel.youness.web;

import com.frexdel.youness.dao.UserRepository;
import com.frexdel.youness.model.ResponseHandler;
import com.frexdel.youness.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Add
    @PostMapping(value = "add")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        try {

            if (userRepository.existsById(user.getId())) {
                return ResponseHandler.generateResponse("User Already Exist", HttpStatus.MULTI_STATUS, null);

            }
            User userResult = userRepository.save(user);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, userResult);

        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // Get
    @GetMapping(value = "/users")
    public ResponseEntity<Object> Get() {
        try {
            List<User> result = userRepository.findAll();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    // Get By ID
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Object> Get(@PathVariable int id) {
        try {
            User result = userRepository.findById(Long.valueOf(id)).orElse(null);
            if (result==null)return ResponseHandler.generateResponse("User dont Exist!!",HttpStatus.MULTI_STATUS,null);
            result = userRepository.getById(Long.valueOf(id));
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
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
