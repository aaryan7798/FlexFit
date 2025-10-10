package com.flexfit.service;

import com.flexfit.model.SuperAdmin;
import com.flexfit.repository.SuperAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SuperAdminRepository superAdminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SuperAdmin admin = superAdminRepo.findByUsername(username);
        if (admin == null) throw new UsernameNotFoundException("User not found");
        return new User(
            admin.getUsername(),
            admin.getPassword(),
            Collections.singleton(new SimpleGrantedAuthority("ROLE_SUPERADMIN"))
        );
    }
}
