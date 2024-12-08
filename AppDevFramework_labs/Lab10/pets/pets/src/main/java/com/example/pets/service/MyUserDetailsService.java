package com.example.pets.service;

import com.example.pets.entity.Users;
import com.example.pets.repository.myUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final myUserRepository userRepository;

    public MyUserDetailsService(myUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from the database
        Users user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // Convert to Spring Security User
        User.UserBuilder builder = User.withUsername(user.getEmail());
        builder.password(user.getPassword());
        builder.roles(user.getRole());
        builder.disabled(user.isLocked());

        return builder.build();
    }
}
