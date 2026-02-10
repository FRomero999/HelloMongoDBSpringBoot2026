package org.example.hellomongodbspringboot2026.security;

import org.example.hellomongodbspringboot2026.entities.User;
import org.example.hellomongodbspringboot2026.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
Servicio que necesario para autenticar usuarios que hay en la base de datos
Solo hay un metodo que implementar que carga los datos de un usuario
 */
@Service
public class MongoUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    // Inyección del repositorio de usuarios
    public MongoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u =  userRepository.findUserByEmail(username).orElseThrow( ()-> new UsernameNotFoundException("User not found"));
        return org.springframework.security.core.userdetails.User.withUsername(username).password("{noop}"+u.getPassword()).roles("ADMIN").build();
    }
}
