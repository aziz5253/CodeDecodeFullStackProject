package com.codedecode.userinfo.service;

import com.codedecode.userinfo.dto.UserDto;
import com.codedecode.userinfo.entity.User;
import com.codedecode.userinfo.mapper.UserMapper;
import com.codedecode.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserDto addUser(UserDto userDto) {
        User savedUser=userRepo.save(UserMapper.Instance.mapUserDtoToUser(userDto));
        return UserMapper.Instance.mapUserToUserDto(savedUser);
    }

    public ResponseEntity<UserDto> getUserByUserId(Integer userId) {
        Optional<User> retrievedUser=userRepo.findById(userId);
        if(retrievedUser.isPresent()) {
            UserDto userDet= UserMapper.Instance.mapUserToUserDto(retrievedUser.get());
            return new ResponseEntity<>(userDet, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
