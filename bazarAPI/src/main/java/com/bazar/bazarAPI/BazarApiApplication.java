package com.bazar.bazarAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
BD: bazar
Servidor: localhost
Usuario: admin
Contraseña: admin
Puerto: 3306
JDBC URL: jdbc:mysql://localhost:3306/bazar?serverTimezone=UTC
 */
@SpringBootApplication
public class BazarApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BazarApiApplication.class, args);
    }

}
