package com.codedecode.userinfo.controller;

import com.codedecode.userinfo.dto.UserDto;
import com.codedecode.userinfo.repo.UserRepo;
import com.codedecode.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto)
    {
        UserDto savedUser=userService.addUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }
    @GetMapping("/fetchUserById/{userId}")
    public ResponseEntity<UserDto> addUser(@PathVariable Integer userId)
    {
        return userService.getUserByUserId(userId);
    }
}
