package demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Bean
    CommandLineRunner preload(BookRepository bookRepository, UserRepository userRepository) {

        return evt -> {
            User user = userRepository.save(new User("gturnquist"));

            bookRepository.save(new Book("Learning Spring Boot", user));
            bookRepository.save(new Book("Spring in Action - 4th Edition", user));
        };
    }
}
