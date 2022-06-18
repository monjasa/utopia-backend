package org.monjasa.utopia;

import org.monjasa.utopia.repository.base.impl.JpaClearableRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = JpaClearableRepositoryImpl.class)
public class UtopiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtopiaApplication.class, args);
    }
}
