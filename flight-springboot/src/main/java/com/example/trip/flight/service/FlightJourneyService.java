package com.example.trip.flight.service;

import com.example.trip.flight.model.FlightJourney;
import com.example.trip.flight.repository.AirportRepository;
import com.example.trip.flight.repository.FlightJourneyRepository;
import com.example.trip.flight.repository.FlightRouteRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightJourneyService  {
  private final FlightJourneyRepository flightJourneyRepository;
  private final FlightRouteRepository flightRouteRepository;
  private final AirportRepository airportRepository;

  public FlightJourneyService(FlightJourneyRepository flightJourneyRepository, FlightRouteRepository flightRouteRepository, AirportRepository airportRepository) {
    this.flightJourneyRepository = flightJourneyRepository;
    this.flightRouteRepository = flightRouteRepository;
    this.airportRepository = airportRepository;
  }

  public Iterable<FlightJourney> generateCheapestJourney(String origin, String destination) {
    return null;
  }

  public FlightJourney findCheapestJourney(String origin, String destination) {
    return null;
  }

  public FlightJourney create(FlightJourney flightJourney) {
    return flightJourneyRepository.save(flightJourney);
  }

  public void deleteAll() {
    flightJourneyRepository.deleteAll();
  }

  public long count() {
    return flightJourneyRepository.count();
  }
}
