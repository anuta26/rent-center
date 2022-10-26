package com.anuta26.rent_center.api.controllers;

import com.anuta26.rent_center.api.dto.EquipmentDto;
import com.anuta26.rent_center.api.exceptions.EntityStateException;
import com.anuta26.rent_center.api.exceptions.IncorrectRequestException;
import com.anuta26.rent_center.api.exceptions.NoEntityFoundException;
import com.anuta26.rent_center.service.EquipmentSPI;
import com.anuta26.rent_center.service.mappers.EquipmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/equipment")
@AllArgsConstructor
public class EquipmentController {

    private final EquipmentMapper equipmentMapper;
    private final EquipmentSPI equipmentSPI;
    @GetMapping()
    public Collection<EquipmentDto> getAll() {
        return equipmentMapper.fromModels(equipmentSPI.readAll());
    }

    @GetMapping("/{id}")
    public EquipmentDto getOne(@PathVariable("id") Long id) {
        return equipmentMapper.fromModel(equipmentSPI.readById(id));
    }

    @PostMapping()
    public EquipmentDto create(@RequestBody EquipmentDto userDTO) throws EntityStateException {
        return equipmentMapper.fromModel(equipmentSPI.create(equipmentMapper.toModel(userDTO)));
    }

    @PutMapping("/{id}")
    public EquipmentDto update(@PathVariable Long id, @RequestBody EquipmentDto equipmentDto) throws IncorrectRequestException, EntityStateException {
        if (!equipmentDto.getEquipmentId().equals(id))
            throw new IncorrectRequestException();
        return equipmentMapper.fromModel(equipmentSPI.update(id, equipmentMapper.toModel(equipmentDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        equipmentSPI.delete(id);
    }
}
