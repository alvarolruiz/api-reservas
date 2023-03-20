package com.atsistemas.apireservas.repository;

import com.atsistemas.apireservas.models.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AvailabilitiesRepository extends JpaRepository<Availability, Integer> {

    @Query (value = "SELECT a FROM Availability a WHERE a.date = :date")
    public Optional<Availability> findAvailabilityForDate (@Param("date")LocalDate date);
}
