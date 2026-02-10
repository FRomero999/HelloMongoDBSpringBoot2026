package org.example.hellomongodbspringboot2026.security;

import org.example.hellomongodbspringboot2026.entities.UserDB;
import org.example.hellomongodbspringboot2026.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class AppUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserDB> currentUser = userRepository.findUserDBByEmail(username);

        if (currentUser.isEmpty()) {
            throw new UsernameNotFoundException("Username not found : " + username);
        }

        UserDetails user = User.withUsername(username)
                .password("{noop}"+currentUser.get().getPassword())
                .roles("ADMIN")
                .build();

        return user;
    }
}
