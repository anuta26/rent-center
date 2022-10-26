package com.anuta26.rent_center.service;

import com.anuta26.rent_center.api.exceptions.EntityStateException;
import com.anuta26.rent_center.model.Equipment;

import java.util.Collection;

public interface EquipmentSPI {

    Collection<Equipment> readAll();

    Equipment readById(Long id);

    Equipment create(Equipment equipment) throws EntityStateException;

    Equipment update(Long id, Equipment equipment) throws EntityStateException;

    void delete(Long id);
}
