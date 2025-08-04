package com.codedecode.userinfo.mapper;

import com.codedecode.userinfo.dto.UserDto;
import com.codedecode.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper Instance= Mappers.getMapper(UserMapper.class);
    User mapUserDtoToUser(UserDto userDto);
    UserDto mapUserToUserDto(User user);
}
