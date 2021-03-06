package com.example.demo.services;

import com.example.demo.entities.Seller;
import com.example.demo.entities.Storage;
import com.example.demo.entities.Thing;
import com.example.demo.repo.SellerRepository;
import com.example.demo.repo.StorageRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;
    private final StorageRepository storageRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository, StorageRepository storageRepository){
        this.sellerRepository = sellerRepository;
        this.storageRepository = storageRepository;
    }

    @Transactional
    public Seller findSellerByName(String firstName, String lastName){
        return sellerRepository.findSellerByName(firstName, lastName);
    }

    @Transactional
    public void addThingsToStorage(Seller seller, List<Thing> toStorage, List<Integer> thingQuantities){
        sellerRepository.save(seller);

        for(int i = 0; i < toStorage.size(); i++){
            Thing thingTemp = toStorage.get(i);
            int thingQTemp = thingQuantities.get(i);
            Storage existsStorageItem = storageRepository.findByThing(thingTemp);

            if(existsStorageItem == null){
                Storage storageItem = new Storage();
                storageItem.setThing(thingTemp);
                storageItem.setQuantity(thingQTemp);
                storageRepository.save(storageItem);
            }else {
                int thingQuantity = existsStorageItem.getQuantity();
                int newThingQuantity = thingQuantity + thingQTemp;
                existsStorageItem.setQuantity(newThingQuantity);
                storageRepository.save(existsStorageItem);
            }

        }
    }

    @Transactional
    public List<Seller> getSellers(){
        return sellerRepository.findAll();
    }

    @Transactional
    public Seller getSellerById(UUID id) throws NotFoundException {
        Optional<Seller> tempSeller = sellerRepository.findById(id);
        if (tempSeller.isPresent())
            return tempSeller.get();
        else
            throw new NotFoundException(String.format("Seller with id %s was not found", id));
    }
}
