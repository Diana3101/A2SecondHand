package com.example.demo.repo;

import com.example.demo.entities.NameofThing;
import com.example.demo.entities.Thing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ThingRepository extends JpaRepository<Thing, UUID> {
    @Query("SELECT th FROM Thing th WHERE th.name = :name")
    Thing findThingByName(@Param("name") NameofThing name);

    @Query("SELECT th FROM Thing th INNER JOIN Storage s ON th.id = s.thing WHERE s.quantity > 0")
    List<Thing> getThingsInStock();
}
