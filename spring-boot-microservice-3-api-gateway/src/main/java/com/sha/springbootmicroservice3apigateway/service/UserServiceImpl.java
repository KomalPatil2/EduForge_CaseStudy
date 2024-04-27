package com.sha.springbootmicroservice3apigateway.service;

import com.sha.exception.UsernameNotFoundException;
import com.sha.springbootmicroservice3apigateway.model.Role;
import com.sha.springbootmicroservice3apigateway.model.User;
import com.sha.springbootmicroservice3apigateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }

    
   

    public Optional<User> findByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user;
        } else {
            throw new UsernameNotFoundException("Username not found: " + username);
        }
    }
   
     
    @Transactional
    public void changeRole(Role newRole, String username) {
        userRepository.findByUsername(username).ifPresentOrElse(user -> {
            user.setRole(newRole);
            userRepository.save(user); // Update the user's role in the database
        }, () -> {
            throw new UsernameNotFoundException("Username not found: " + username);
        });
    }
    
   
}
