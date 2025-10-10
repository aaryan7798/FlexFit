package com.flexfit.service;

import com.flexfit.model.GymOwner;
import com.flexfit.repository.GymOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GymOwnerService {
    @Autowired
    private GymOwnerRepository repository;

    public List<GymOwner> getAllOwners() {
        return repository.findAll();
    }

    public Optional<GymOwner> getOwnerById(Long id) {
        return repository.findById(id);
    }

    public GymOwner registerGymOwner(GymOwner owner) {
        owner.setSubscriptionStatus("pending");
        return repository.save(owner);
    }
}
