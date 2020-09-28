package com.example.demo.controllers;

import com.example.demo.entities.Seller;
import com.example.demo.entities.Thing;
import com.example.demo.entities.dto.ServeDTO;
import com.example.demo.services.SellerService;
import com.example.demo.services.ThingService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sell")
public class SellerController {
    private final SellerService sellerService;
    private final ThingService thingService;

    @Autowired
    public SellerController(SellerService sellerService, ThingService thingService) {
        this.sellerService = sellerService;
        this.thingService = thingService;
    }

    @PostMapping("sellThings")
    public ResponseEntity<Void> getThingsFromSeller(@RequestBody String serveJson){
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        ServeDTO serve = gson.fromJson(serveJson, ServeDTO.class);
        List<Thing> toStorage = serve.getThings();
        List<Integer> thingQuantities = serve.getThingQuantities();
        Seller jsonSeller = serve.getSeller();

        Seller seller = sellerService.findSellerByName(jsonSeller.getFirstName(), jsonSeller.getLastName());
        for(Thing th: toStorage){
            th.setAddedBy(seller);
            thingService.addThing(th);
        }
        sellerService.addThingsToStorage(seller, toStorage, thingQuantities);

        return ResponseEntity.ok().build();
    }
}
