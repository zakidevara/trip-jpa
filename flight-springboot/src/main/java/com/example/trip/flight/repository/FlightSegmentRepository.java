package com.example.trip.flight.repository;

import com.example.trip.flight.model.FlightSegment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSegmentRepository extends CrudRepository<FlightSegment, String> {
}
