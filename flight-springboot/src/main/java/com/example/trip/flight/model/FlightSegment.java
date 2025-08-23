package com.example.trip.flight.model;

public class FlightSegment {
  private String airlineId; // e.g., "GA" for Garuda Indonesia
  private String flightNumber; // e.g., "GA-123"
  private String aircraftType; // e.g., "Boeing 737-800"

  private String originAirport; // e.g., "CGK" for Soekarno-Hatta, "SUB" for Juanda
  private String destinationAirport; // e.g., "SIN" for Singapore Changi Airport
  private long departureTime; // epoch time in milliseconds
  private long arrivalTime; // epoch time in milliseconds
  private SeatClass seatClass; // e.g., ECONOMY, BUSINESS, FIRST
}
