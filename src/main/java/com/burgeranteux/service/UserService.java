package com.burgeranteux.service;

import com.burgeranteux.model.User;
import com.burgeranteux.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
//    BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(final Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId_user()).orElse(null);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setUser(user.getUser());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setAddress(user.getAddress());
            existingUser.setPhone(user.getPhone());
        }
        assert existingUser != null;
        return userRepository.save(existingUser);
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }

    public User getUserByUsername(final String username) {
        return userRepository.findByUser(username);
    }
}
