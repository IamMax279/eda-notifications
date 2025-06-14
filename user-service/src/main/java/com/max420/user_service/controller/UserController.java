package com.max420.user_service.controller;

import com.max420.user_service.dto.UserDto;
import com.max420.user_service.services.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService _userService;

    public UserController(UserService userService) {
        _userService = userService;
    }

    @PostMapping("/create-user")
    ResponseEntity<Map<String, String>> createUser(@RequestBody UserDto userDto) {
        try {
            _userService.createUser(userDto);

            return ResponseEntity.ok(Map.of("message", "User created successfully."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "message",
                    "Something went wrong: " + e.getMessage()
            ));
        }
    }
}
