package com.max420.user_service.services;

import com.max420.user_service.dto.UserDto;

import java.io.IOException;

public interface IUserService {
    void createUser(UserDto userDto) throws Exception;
}
