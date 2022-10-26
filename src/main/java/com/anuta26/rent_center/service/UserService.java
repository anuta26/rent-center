package com.anuta26.rent_center.service;

import com.anuta26.rent_center.api.exceptions.EntityStateException;
import com.anuta26.rent_center.api.exceptions.NoEntityFoundException;
import com.anuta26.rent_center.dao.UserJpaRepository;
import com.anuta26.rent_center.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class UserService implements UserSPI {
    private final UserJpaRepository userJpaRepository;
    @Override
    public Collection<User> readAll() {
        return userJpaRepository.findAll();
    }

    @Override
    public User readById(Long id) {
        return userJpaRepository.findById(id)
                .orElseThrow( () ->
                        new NoEntityFoundException("User with id " + id + " does not exist."));
    }

    @Override
    public User create(User user) throws EntityStateException {
        if (user.getUserId() != null) {
            if (userJpaRepository.existsById(user.getUserId())){
                throw new EntityStateException("User with id " + user.getUserId() + " already exists.");
            }
        }
        return userJpaRepository.save(user);
    }

    @Override
    public User update(Long id, User user) throws EntityStateException {
        if (id == null || !userJpaRepository.existsById(id)){
            throw new NoEntityFoundException("User with id" + id + " does not exist.");
        }
        User userFromDatabase = this.readById(id);
        userFromDatabase.setUsername(user.getUsername());
        return userJpaRepository.save(userFromDatabase);
    }

    @Override
    public void delete(Long id) {
        if (userJpaRepository.existsById(id))
            userJpaRepository.deleteById(id);
        else {
            throw new NoEntityFoundException("User with id" + id + " does not exist.");
        }
    }
}
