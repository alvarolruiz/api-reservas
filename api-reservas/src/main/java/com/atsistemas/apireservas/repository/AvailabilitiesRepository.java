package com.atsistemas.apireservas.repository;

import com.atsistemas.apireservas.models.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailabilitiesRepository extends JpaRepository<Availability, Integer> {
}
