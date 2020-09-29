package com.example.demo.controllers;

import com.example.demo.entities.Thing;
import com.example.demo.entities.dto.ThingsDTO;
import com.example.demo.services.ThingService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("things")
public class ThingController {
    private final ThingService thingService;

    @Autowired
    public ThingController(ThingService thingService) {
        this.thingService = thingService;
    }

    @GetMapping
    public ResponseEntity<List<Thing>> show() {
        return ResponseEntity.ok(thingService.getThings());
    }

    @GetMapping("{id}")
    public ResponseEntity<Thing> showById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(thingService.getThingById(id));
    }

}
