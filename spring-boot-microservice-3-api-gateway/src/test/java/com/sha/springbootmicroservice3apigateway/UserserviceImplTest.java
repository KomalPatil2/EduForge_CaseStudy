package com.sha.springbootmicroservice3apigateway;

import com.sha.exception.UsernameNotFoundException;
import com.sha.springbootmicroservice3apigateway.model.Role;
import com.sha.springbootmicroservice3apigateway.model.User;
import com.sha.springbootmicroservice3apigateway.repository.UserRepository;
import com.sha.springbootmicroservice3apigateway.service.UserServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.saveUser(user);

        assertNotNull(savedUser);
        assertEquals("testuser", savedUser.getUsername());
        assertEquals("encodedPassword", savedUser.getPassword());
        assertEquals(Role.USER, savedUser.getRole());
        assertNotNull(savedUser.getCreateTime());
        verify(passwordEncoder).encode("password");
        verify(userRepository).save(user);
    }

    @Test
    public void testFindByUsername() {

    	User user = new User();
        user.setUsername("testuser");
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.findByUsername("testuser");

        assertTrue(foundUser.isPresent());
        assertEquals("testuser", foundUser.get().getUsername());
        verify(userRepository).findByUsername("testuser");
    }

    @Test
    public void testFindByUsername_NotFound() {

    	when(userRepository.findByUsername("unknownuser")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> userService.findByUsername("unknownuser"));
        verify(userRepository).findByUsername("unknownuser");
    }

   @Test
   public void testChangeRole() {

        User user = new User();
        user.setUsername("testuser");
        user.setRole(Role.USER);
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));


        userService.changeRole(Role.ADMIN, "testuser");


        assertEquals(Role.ADMIN, user.getRole());
        verify(userRepository).findByUsername("testuser");
        verify(userRepository).save(user);
    }

    
}
