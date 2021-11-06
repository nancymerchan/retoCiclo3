package com.usa.reto3.repository;

import com.usa.reto3.repository.interfaces.ReservationInterface;
import com.usa.reto3.model.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nancy
 */
@Repository
public class ReservationRepository {

    @Autowired
    private ReservationInterface crud4;

    public List<Reservation> getAll() {
        return (List<Reservation>) crud4.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return crud4.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return crud4.save(reservation);
    }

    public void delete(Reservation reservation) {
        crud4.delete(reservation);
    }

}
