package com.trackingsys.stocktrackingsystem.service;

import com.trackingsys.stocktrackingsystem.dto.UserDto;
import com.trackingsys.stocktrackingsystem.dto.converter.UserDtoConverter;
import com.trackingsys.stocktrackingsystem.entity.Product;
import com.trackingsys.stocktrackingsystem.entity.User;
import com.trackingsys.stocktrackingsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public UserDto addUser(User user) {
        return userDtoConverter.convertToDto(userRepository.save(user));
    }

    public List<UserDto> getAllUsers() {
        return userDtoConverter.convertToDto(userRepository.findAll());
    }

    public UserDto getUserById(String userId) {
        return userDtoConverter.convertToDto(userRepository.findById(userId).orElse(null));
    }

    public User deleteUserById(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        userRepository.deleteById(userId);
        return user;
    }

    public UserDto updateUserById(User user, String userId) {
        User updateUser = userRepository.findById(userId).orElse(null);
            updateUser.setMail(user.getMail());
            updateUser.setPassword(user.getPassword());
        return userDtoConverter.convertToDto(userRepository.save(updateUser));
    }
}
