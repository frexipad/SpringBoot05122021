package com.frexdel.youness.web;

import com.frexdel.youness.dao.UserRepository;

import com.frexdel.youness.exception.ApiRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class WebController {
    UserRepository userRepository;

    public WebController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//How To Handle and customized Exceptions spring_boot
    @GetMapping()
    public String apiHandlerException(){
        throw new ApiRequestException("Oops cannot get all students!!");
    }


}
