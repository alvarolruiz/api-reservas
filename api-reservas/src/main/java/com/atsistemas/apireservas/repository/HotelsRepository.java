package com.atsistemas.apireservas.repository;

import com.atsistemas.apireservas.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelsRepository extends JpaRepository<Hotel, Integer> {
}
