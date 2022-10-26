package com.anuta26.rent_center.api.controllers;

import com.anuta26.rent_center.api.dto.UserDto;
import com.anuta26.rent_center.api.exceptions.EntityStateException;
import com.anuta26.rent_center.api.exceptions.IncorrectRequestException;
import com.anuta26.rent_center.service.UserSPI;
import com.anuta26.rent_center.service.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserMapper userMapper;
    private final UserSPI userSPI;
    @GetMapping()
    public Collection<UserDto> getAll() {
        return userMapper.fromModels(userSPI.readAll());
    }

    @GetMapping("/{id}")
    public UserDto getOne(@PathVariable("id") Long id) {
        return userMapper.fromModel(userSPI.readById(id));
    }

    @PostMapping()
    public UserDto create(@RequestBody UserDto userDTO) throws EntityStateException {
        return userMapper.fromModel(userSPI.create(userMapper.toModel(userDTO)));
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable Long id, @RequestBody UserDto userDto) throws IncorrectRequestException, EntityStateException {
        if (!userDto.getUserId().equals(id))
            throw new IncorrectRequestException();
        return userMapper.fromModel(userSPI.update(id, userMapper.toModel(userDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userSPI.delete(id);
    }
}
