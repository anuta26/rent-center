package com.anuta26.rent_center.service;

import com.anuta26.rent_center.api.exceptions.EntityStateException;
import com.anuta26.rent_center.model.Reservation;

import java.util.Collection;

public interface ReservationSPI {
    Collection<Reservation> readAll();

    Reservation readById(Long id);

    Reservation create(Reservation reservation) throws EntityStateException;

    Reservation update(Long id, Reservation reservation) throws EntityStateException;

    void delete(Long id);
}
