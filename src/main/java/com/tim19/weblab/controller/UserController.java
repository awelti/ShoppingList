package com.tim19.weblab.controller;

import com.tim19.weblab.dto.ErrorDto;
import com.tim19.weblab.dto.UserDto;
import com.tim19.weblab.error.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= "/users")
public class UserController {

    @GetMapping(value = "/{id}")
    public UserDto getByID(@PathVariable(value = "id") long id) {

        if (id == 1) {
            UserDto userDto = new UserDto();
            userDto.loginName = "meinLogin";
            userDto.userName = "Andi";
            return userDto;
        }

        if (id == 7) {
            throw new IllegalArgumentException("Id 7 is not allowed");
        }

        throw new UserNotFoundException(String.format("User with id %s not found"));
    }


}
