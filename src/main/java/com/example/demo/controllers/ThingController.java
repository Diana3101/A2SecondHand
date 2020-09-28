package com.example.demo.controllers;

import com.example.demo.entities.dto.ThingsDTO;
import com.example.demo.services.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("things")
public class ThingController {
    private final ThingService thingService;

    @Autowired
    public ThingController(ThingService thingService) {
        this.thingService = thingService;
    }

    @GetMapping("getAll")
    public @ResponseBody
    ThingsDTO getAllThings(){
        ThingsDTO thingsDTO = new ThingsDTO();
        thingsDTO.setThings(thingService.getAllThing());
        return thingsDTO;
    }
}
