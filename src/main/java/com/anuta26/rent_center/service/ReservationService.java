package com.anuta26.rent_center.service;

import com.anuta26.rent_center.api.exceptions.EntityStateException;
import com.anuta26.rent_center.api.exceptions.NoEntityFoundException;
import com.anuta26.rent_center.dao.ReservationJpaRepository;
import com.anuta26.rent_center.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ReservationService implements ReservationSPI{
    private final ReservationJpaRepository reservationJpaRepository;
    @Override
    public Collection<Reservation> readAll() {
        return reservationJpaRepository.findAll();
    }

    @Override
    public Reservation readById(Long id) {
        return reservationJpaRepository.findById(id)
                .orElseThrow( () ->
                        new NoEntityFoundException("Reservation with id " + id + " does not exist."));
    }

    @Override
    public Reservation create(Reservation reservation) throws EntityStateException {
        if (reservation.getReservationId() != null) {
            if (reservationJpaRepository.existsById(reservation.getReservationId())){
                throw new EntityStateException("Reservation with id " + reservation.getReservationId() + " already exists.");
            }
        }
        return reservationJpaRepository.save(reservation);
    }

    @Override
    public Reservation update(Long id, Reservation reservation) throws EntityStateException {
        if (id == null || !reservationJpaRepository.existsById(id)){
            throw new NoEntityFoundException("Reservation with id" + id + " does not exist.");
        }
        Reservation reservationFromDatabase = this.readById(id);
        //some changes
        return reservationJpaRepository.save(reservationFromDatabase);
    }

    @Override
    public void delete(Long id) {
        if (reservationJpaRepository.existsById(id))
            reservationJpaRepository.deleteById(id);
        else {
            throw new NoEntityFoundException("Reservation with id" + id + " does not exist.");
        }
    }
}
