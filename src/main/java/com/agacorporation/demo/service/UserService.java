package com.agacorporation.demo.service;

import com.agacorporation.demo.config.AuthoritiesConstants;
import com.agacorporation.demo.domain.Authority;
import com.agacorporation.demo.domain.User;
import com.agacorporation.demo.repository.AuthorityRepository;
import com.agacorporation.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Authority> authorities = new HashSet<>();
        authorityRepository.findById(AuthoritiesConstants.USER).ifPresent(authorities::add);
        user.setAuthorities(authorities);
        userRepository.save(user);
    }
    public boolean isUniqueLogin(String username) {
        return userRepository.findByLogin(username) == null;
    }

    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
