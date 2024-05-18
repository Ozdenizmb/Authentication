package com.auth.user.mapper;

import com.auth.user.dto.UserDto;
import com.auth.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto> {



}
