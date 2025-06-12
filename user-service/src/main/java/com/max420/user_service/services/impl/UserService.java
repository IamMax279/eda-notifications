package com.max420.user_service.services.impl;

import com.max420.user_service.dto.UserDto;
import com.max420.user_service.models.User;
import com.max420.user_service.repository.UserRepository;
import com.max420.user_service.services.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService implements IUserService {
    private static UserRepository _userRepository;
    private static PasswordEncoder _passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        _userRepository = userRepository;
        _passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(UserDto userDto) throws IOException {
        if (userDto == null ||
                userDto.getEmail() == null ||
                userDto.getEmail().trim().isEmpty() ||
                userDto.getPassword() == null ||
                userDto.getPassword().trim().isEmpty() ||
                userDto.getName() == null ||
                userDto.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Missing field(s)");
        }

        String hashed = _passwordEncoder.encode(userDto.getPassword().trim());

        User user = mapToUser(userDto.getName().trim(), userDto.getEmail().trim(), hashed);
        _userRepository.save(user);
    }

    private User mapToUser(String name, String email, String password) {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
