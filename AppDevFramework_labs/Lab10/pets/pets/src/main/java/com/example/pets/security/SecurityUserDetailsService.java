package com.example.pets.security;

import com.example.pets.entity.Users;
import com.example.pets.repository.myUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {
    private myUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = myUserRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        System.out.println("User found: " + user.getEmail());
        System.out.println("Roles: " + user.getRole());
        return new User(user.getEmail(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))
        );

    }
}
