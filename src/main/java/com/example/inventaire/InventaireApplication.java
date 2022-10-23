package com.example.inventaire;

import com.example.inventaire.entity.Box;
import com.example.inventaire.repository.BoxRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventaireApplication  {


    public static void main(String[] args) {
        SpringApplication.run(InventaireApplication.class, args);
    }

}
