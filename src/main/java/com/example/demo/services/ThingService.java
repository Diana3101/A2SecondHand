package com.example.demo.services;

import com.example.demo.entities.Thing;
import com.example.demo.repo.ThingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ThingService {
    private final ThingRepository thingRepository;

    @Autowired
    public ThingService(ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    @Transactional(readOnly = true)
    public List<Thing> getAllThing() {
        return thingRepository.getThingsInStock();
    }

    @Transactional
    public void addThing(Thing thing){
        if(thingRepository.findThingByName(thing.getName()) == null){
            thingRepository.save(thing);
        }
    }
}
