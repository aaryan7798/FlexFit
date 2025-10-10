package com.flexfit.service;

import com.flexfit.model.SuperAdmin;
import com.flexfit.repository.SuperAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SuperAdminService {
    @Autowired
    private SuperAdminRepository repository;

    public List<SuperAdmin> getAllAdmins() {
        return repository.findAll();
    }

    public SuperAdmin getByUsername(String username) {
        return repository.findByUsername(username);
    }

    public SuperAdmin saveSuperAdmin(SuperAdmin admin) {
        return repository.save(admin);
    }
}
