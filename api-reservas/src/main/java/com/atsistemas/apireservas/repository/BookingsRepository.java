package com.atsistemas.apireservas.repository;

import com.atsistemas.apireservas.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepository extends JpaRepository<Booking, Integer> {
}
