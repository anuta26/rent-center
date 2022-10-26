package com.anuta26.rent_center.service;

import com.anuta26.rent_center.api.exceptions.EntityStateException;
import com.anuta26.rent_center.api.exceptions.NoEntityFoundException;
import com.anuta26.rent_center.dao.EquipmentJpaRepository;
import com.anuta26.rent_center.model.Equipment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class EquipmentService implements EquipmentSPI{

    private final EquipmentJpaRepository equipmentJpaRepository;
    @Override
    public Collection<Equipment> readAll() {
        return equipmentJpaRepository.findAll();
    }

    @Override
    public Equipment readById(Long id) {
        return equipmentJpaRepository.findById(id)
                .orElseThrow( () ->
                    new NoEntityFoundException("Equipment with id " + id + " does not exist."));
    }

    @Override
    public Equipment create(Equipment equipment) throws EntityStateException {
        if (equipment.getEquipmentId() != null) {
            if (equipmentJpaRepository.existsById(equipment.getEquipmentId())){
                throw new EntityStateException("Equipment with id " + equipment.getEquipmentId() + " already exists.");
            }
        }
        return equipmentJpaRepository.save(equipment);
    }

    @Override
    public Equipment update(Long id, Equipment equipment) throws EntityStateException {
        if (id == null || !equipmentJpaRepository.existsById(id)){
            throw new NoEntityFoundException("Equipment with id" + id + " does not exist.");
        }
        Equipment equipmentFromDatabase = this.readById(id);
        equipmentFromDatabase.setName(equipment.getName());
        return equipmentJpaRepository.save(equipmentFromDatabase);
    }

    @Override
    public void delete(Long id) {
        if (equipmentJpaRepository.existsById(id))
            equipmentJpaRepository.deleteById(id);
        else {
            throw new NoEntityFoundException("Equipment with id" + id + " does not exist.");
        }
    }

}
