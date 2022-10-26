package com.anuta26.rent_center.service.mappers;

import com.anuta26.rent_center.api.dto.ReservationDto;
import com.anuta26.rent_center.model.Reservation;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationDto fromModel (Reservation reservation);
    Reservation toModel (ReservationDto reservationDto);
    Collection<ReservationDto> fromModels (Collection<Reservation> reservations);
}
