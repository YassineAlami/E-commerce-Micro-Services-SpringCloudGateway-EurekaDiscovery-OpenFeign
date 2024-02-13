package org.sid.invantoryservice;

import org.sid.invantoryservice.entities.Product;
import org.sid.invantoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InvantoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvantoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Product.class);
            productRepository.saveAll(
                    List.of(
                            Product.builder().name("Computer").price(1300.5).quantity(12).build(),
                            Product.builder().name("Print").price(400.5).quantity(14).build(),
                            Product.builder().name("SmartPhone").price(1600.0).quantity(21).build()
                    )
            );
        };
    }
}
