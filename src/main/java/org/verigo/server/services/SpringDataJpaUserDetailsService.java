package org.verigo.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.verigo.server.data.repositories.UserRepository;
import org.verigo.server.data.entities.User;

@Component
public class SpringDataJpaUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public SpringDataJpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = this.repository.findByLogin(login);
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
            AuthorityUtils.createAuthorityList(user.getRole()));
    }
}
