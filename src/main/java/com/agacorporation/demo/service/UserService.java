package com.agacorporation.demo.service;

import com.agacorporation.demo.component.commands.UserFilter;
import com.agacorporation.demo.domain.Authority;
import com.agacorporation.demo.domain.User;
import com.agacorporation.demo.exceptions.UserNotFoundException;
import com.agacorporation.demo.repository.AuthorityRepository;
import com.agacorporation.demo.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

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
      /*  Set<Authority> authorities = new HashSet<>();
        authorityRepository.findById(AuthoritiesConstants.USER).ifPresent(authorities::add);

        user.setAuthorities(authorities);
*/
        Authority userRole = authorityRepository.findAuthorityByName("ROLE_USER");
        List roles = Arrays.asList(userRole);
        user.setAuthorities(new HashSet<>(roles));
       userRepository.save(user);
    }

    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(()->new UserNotFoundException(id));
        return user;
    }
    public boolean isUniqueLogin(String username) {
        return userRepository.findByLogin(username) == null;
    }

    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }
    public Page<User> getAllUsers(UserFilter search, Pageable pageable) {

        Page page;
        if(search.isEmpty()){
            page = userRepository.findAll(pageable);
        }else{


            page = userRepository.findAllUsersUsingFilter(search.getPhraseLIKE(), pageable);
        }

        return page;
    }
    public void deleteUser(Long id) {
        if(userRepository.existsById(id) == true){
            userRepository.deleteById(id);
        }else{
            throw new UserNotFoundException(id);
        }



    }
}
