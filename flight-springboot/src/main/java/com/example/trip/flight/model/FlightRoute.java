package com.example.trip.flight.model;

import lombok.Data;

import java.util.List;

@Data
public class FlightRoute {
  private String originAirport; // e.g., "CGK" for Soekarno-Hatta, "SUB" for Juanda
  private String destinationAirport; // e.g., "SIN" for Singapore Changi Airport

  private long departureTime; // epoch time in milliseconds
  private long arrivalTime; // epoch time in milliseconds

  List<FlightSegment> segments; // List of flight segments (for connecting flights)
}
