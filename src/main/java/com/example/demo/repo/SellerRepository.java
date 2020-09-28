package com.example.demo.repo;

import com.example.demo.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface SellerRepository extends JpaRepository<Seller, UUID> {
    @Query("SELECT s FROM Seller s WHERE s.firstName = :firstName and s.lastName = :lastName")
    Seller findSellerByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
