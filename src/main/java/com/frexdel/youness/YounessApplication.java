package com.frexdel.youness;

import com.frexdel.youness.dao.UserRepository;
import com.frexdel.youness.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class YounessApplication {

	public static void main(String[] args) {
		SpringApplication.run(YounessApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository) {
		return args -> {
			System.out.println("Starting...........................");
			userRepository.save(new User(null, "fname", "lname", 85));

		};

	}
}
