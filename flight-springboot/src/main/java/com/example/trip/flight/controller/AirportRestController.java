package com.example.trip.flight.controller;

import com.example.trip.flight.model.Airport;
import com.example.trip.flight.service.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping
public class AirportRestController {
  private final AirportService airportService;

  public AirportRestController(AirportService airportService) {
    this.airportService = airportService;
  }

  @GetMapping("/airports")
  public ResponseEntity<List<Airport>> getAllAirports() {
    return ResponseEntity.ok(
        StreamSupport.stream(airportService.findAll().spliterator(), false)
            .toList()
    );
  }
}
