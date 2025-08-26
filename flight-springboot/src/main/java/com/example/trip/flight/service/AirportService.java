package com.example.trip.flight.service;

import com.example.trip.flight.logger.LogAction;
import com.example.trip.flight.model.Airport;
import com.example.trip.flight.model.Coordinate;
import com.example.trip.flight.repository.AirportRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
  private final AirportRepository airportRepository;

  public AirportService(AirportRepository airportRepository) {
    this.airportRepository = airportRepository;
  }

  @LogAction(
      value = "upsert-airport",
      inputCountExpression = "1",
      outputCountExpression = "1"
  )
  public Airport upsert(Airport airport) {
    return airportRepository.save(airport);
  }

  @LogAction(
      value = "find-all-airports",
      inputCountExpression = "0",
      outputCountExpression = "#result != null ? T(java.util.stream.StreamSupport).stream(#result.spliterator(), false).count() : 0"
  )
  public Iterable<Airport> findAll() {
    return airportRepository.findAll();
  }

  public Airport findById(String id) {
    return airportRepository.findById(id).orElse(null);
  }

  public void deleteById(String id) {
    airportRepository.deleteById(id);
  }

  public boolean existsById(String id) {
    return airportRepository.existsById(id);
  }

  public long count() {
    return airportRepository.count();
  }

  public void deleteAll() {
    airportRepository.deleteAll();
  }

  public void populateAirports() {
    if (count() == 0) {
      upsert(new Airport("JFK", "John F. Kennedy International Airport", "New York", "USA", new Coordinate(0, 0)));
      upsert(new Airport("LAX", "Los Angeles International Airport", "Los Angeles", "USA", new Coordinate(0, 0)));
      upsert(new Airport("ORD", "O'Hare International Airport", "Chicago", "USA", new Coordinate(0, 0)));
      upsert(new Airport("ATL", "Hartsfield-Jackson Atlanta International Airport", "Atlanta", "USA", new Coordinate(0, 0)));
      upsert(new Airport("DFW", "Dallas/Fort Worth International Airport", "Dallas/Fort Worth", "USA", new Coordinate(0, 0)));
      upsert(new Airport("DEN", "Denver International Airport", "Denver", "USA", new Coordinate(0, 0)));
      upsert(new Airport("SFO", "San Francisco International Airport", "San Francisco", "USA", new Coordinate(0, 0)));
      upsert(new Airport("SEA", "Seattle-Tacoma International Airport", "Seattle", "USA", new Coordinate(0, 0)));
      upsert(new Airport("MIA", "Miami International Airport", "Miami", "USA", new Coordinate(0, 0)));
      upsert(new Airport("BOS", "Logan International Airport", "Boston", "USA", new Coordinate(0, 0)));
    }
  }
}
