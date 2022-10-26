package com.anuta26.rent_center.service.mappers;

import com.anuta26.rent_center.api.dto.UserDto;
import com.anuta26.rent_center.model.User;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto fromModel(User user);
    User toModel(UserDto userDto);
    Collection<UserDto> fromModels (Collection<User> users);
}
