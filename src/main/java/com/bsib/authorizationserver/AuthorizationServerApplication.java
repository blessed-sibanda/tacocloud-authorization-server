package com.bsib.authorizationserver;

import com.bsib.authorizationserver.users.User;
import com.bsib.authorizationserver.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }

    @Bean
    CommandLineRunner dataLoader(UserRepository repo,
                                 PasswordEncoder encoder) {
        return args -> {
            repo.save(
                    new User("blessed",
                            encoder.encode("password"),
                            "ROLE_ADMIN")
            );
            repo.save(
                    new User("chiedza",
                            encoder.encode("password"),
                            "ROLE_ADMIN")
            );
        };
    }

}
