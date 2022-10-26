package com.anuta26.rent_center.service;

import com.anuta26.rent_center.api.exceptions.EntityStateException;
import com.anuta26.rent_center.model.User;

import java.util.Collection;

public interface UserSPI {
    Collection<User> readAll();

    User readById(Long id);

    User create(User user) throws EntityStateException;

    User update(Long id, User user) throws EntityStateException;

    void delete(Long id);
}
