package com.example.trip.flight.repository;

import com.example.trip.flight.model.FlightJourney;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightJourneyRepository extends CrudRepository<FlightJourney, Long> {
}
