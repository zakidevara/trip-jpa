package com.example.trip.flight.service;

import com.example.trip.flight.model.Airport;
import com.example.trip.flight.repository.AirportRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
  private final AirportRepository airportRepository;

  public AirportService(AirportRepository airportRepository) {
    this.airportRepository = airportRepository;
  }

  public Airport upsert(Airport airport) {
    return airportRepository.save(airport);
  }

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
}
