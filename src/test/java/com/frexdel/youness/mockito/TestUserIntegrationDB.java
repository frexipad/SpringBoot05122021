package com.frexdel.youness.mockito;

import com.frexdel.youness.dao.UserRepository;
import com.frexdel.youness.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
public class TestUserIntegrationDB {
    @Autowired
    UserRepository userRepository;

    @AfterEach
    void cleanUp() {
        userRepository.deleteAll();
    }

    @Test
    @Sql(statements = "insert into user (ID,FIRST_NAME,LAST_NAME,AGE) values(null,'ff','ll',100)")
    public void findProductByID(){
        User u1= userRepository.findByFirstName("ff");
        Assertions.assertEquals("ff",u1.getFirstName());
    }
}
