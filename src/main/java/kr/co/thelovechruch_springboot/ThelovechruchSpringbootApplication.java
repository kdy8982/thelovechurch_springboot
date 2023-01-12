package kr.co.thelovechruch_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ThelovechruchSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThelovechruchSpringbootApplication.class, args);
    }

}
