package com.frexdel.youness.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class EnvirenementConfigTest {

    private String message;

    public void printMessageProfil(){
        System.out.println(message);
    }


}
