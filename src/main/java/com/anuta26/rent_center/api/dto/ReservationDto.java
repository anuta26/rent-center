package com.anuta26.rent_center.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private Long reservationId;
    private UserDto author;
    private EquipmentDto equipment;
}
