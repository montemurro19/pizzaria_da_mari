package br.com.fiap.marys_pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.marys_pizza.repositories.ClienteRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    ClienteRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) repository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("usuário não encontrado"));
    }
    
}