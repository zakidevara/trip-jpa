package com.example.flight.model;

import lombok.Data;

@Data
public class Flight {
  private String originAirport; // e.g., "CGK" for Soekarno-Hatta, "SUB" for Juanda
  private String destinationAirport; // e.g., "SIN" for Singapore Changi Airport
  private String airlineId; // e.g., "GA" for Garuda Indonesia
  private String flightNumber; // e.g., "GA-123"

  private long departureTime; // epoch time in milliseconds
  private long arrivalTime; // epoch time in milliseconds
  private String aircraftType; // e.g., "Boeing 737-800"
}
