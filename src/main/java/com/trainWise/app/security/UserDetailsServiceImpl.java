package com.trainWise.app.security;

import com.trainWise.app.model.User;
import com.trainWise.app.repository.SelfTrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final SelfTrainerRepository selfTrainerRepository;

    public UserDetailsServiceImpl(SelfTrainerRepository selfTrainerRepository) {
        this.selfTrainerRepository = selfTrainerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = selfTrainerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities("USER") // Adapte para roles se necessário
                .build();
    }
}
