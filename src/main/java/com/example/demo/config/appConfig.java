package com.example.demo.config;

import com.example.demo.entities.*;
import com.example.demo.repo.SellerRepository;
import com.example.demo.repo.ThingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class appConfig {
    @Bean
    public CommandLineRunner demo(final ThingRepository thingRepository, final SellerRepository sellerRepository) {
        return strings -> {
            List<Thing> orderedlist = new ArrayList<Thing>();
            Seller seller = new Seller("Dasha", "Orlova", orderedlist, SellerWish.GooglePromotion);
            sellerRepository.save(seller);

        };

    }
}
