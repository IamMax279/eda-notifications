package com.max420.user_service.services.impl;

import com.max420.user_service.dto.UserDto;
import com.max420.user_service.models.User;
import com.max420.user_service.producers.UserCreatedProducer;
import com.max420.user_service.repository.UserRepository;
import com.max420.user_service.services.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final UserRepository _userRepository;
    private final PasswordEncoder _passwordEncoder;
    private final UserCreatedProducer _userCreatedProducer;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserCreatedProducer userCreatedProducer) {
        _userRepository = userRepository;
        _passwordEncoder = passwordEncoder;
        _userCreatedProducer = userCreatedProducer;
    }

    @Override
    public void createUser(UserDto userDto) throws Exception {
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

        String message = String.format("User created: %s <%s>", user.getEmail(), user.getName());
        _userCreatedProducer.sendUserCreatedMessage(message);
    }

    private User mapToUser(String name, String email, String password) {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
