package com.anuta26.rent_center.service.mappers;

import com.anuta26.rent_center.api.dto.EquipmentDto;
import com.anuta26.rent_center.model.Equipment;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
    EquipmentDto fromModel (Equipment equipment);

    Equipment toModel (EquipmentDto equipmentDto);

    Collection<EquipmentDto> fromModels (Collection<Equipment> equipment);
}
