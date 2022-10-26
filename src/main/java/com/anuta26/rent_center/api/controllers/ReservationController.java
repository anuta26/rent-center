package com.anuta26.rent_center.api.controllers;

import com.anuta26.rent_center.api.dto.ReservationDto;
import com.anuta26.rent_center.api.exceptions.EntityStateException;
import com.anuta26.rent_center.api.exceptions.IncorrectRequestException;
import com.anuta26.rent_center.service.ReservationSPI;
import com.anuta26.rent_center.service.mappers.ReservationMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationMapper reservationMapper;
    private final ReservationSPI reservationSPI;
    @GetMapping()
    public Collection<ReservationDto> getAll() {
        return reservationMapper.fromModels(reservationSPI.readAll());
    }

    @GetMapping("/{id}")
    public ReservationDto getOne(@PathVariable("id") Long id) {
        return reservationMapper.fromModel(reservationSPI.readById(id));
    }

    @PostMapping()
    public ReservationDto create(@RequestBody ReservationDto userDTO) throws EntityStateException {
        return reservationMapper.fromModel(reservationSPI.create(reservationMapper.toModel(userDTO)));
    }

    @PutMapping("/{id}")
    public ReservationDto update(@PathVariable Long id, @RequestBody ReservationDto reservationDto) throws IncorrectRequestException, EntityStateException {
        if (!reservationDto.getReservationId().equals(id))
            throw new IncorrectRequestException();
        return reservationMapper.fromModel(reservationSPI.update(id, reservationMapper.toModel(reservationDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        reservationSPI.delete(id);
    }
}
