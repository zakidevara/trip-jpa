package com.example.trip.flight.repository;

import com.example.trip.flight.model.FlightRoute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRouteRepository extends CrudRepository<FlightRoute, String> {
}
