package com.lance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class Application {

    @Test
    public void contextLoads(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String encode = passwordEncoder.encode("123");
        System.out.println(encode);

        boolean matches = passwordEncoder.matches("123", encode);
        System.out.println(matches);
    }
}
