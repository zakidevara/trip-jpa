package com.example.trip.flight.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightSegment {
  /**
   * Unique identifier for the flight segment,
   * e.g., "CGK.SIN.GA-123.ECONOMY.2025-12-31.08:00.2025-12-31.10:00"
   */
  @Id
  private String id;
  @Column
  private String airlineId; // e.g., "GA" for Garuda Indonesia
  @Column
  private String flightNumber; // e.g., "GA-123"
  @Column
  private String aircraftType; // e.g., "Boeing 737-800"
  @Column
  private String originAirport; // e.g., "CGK" for Soekarno-Hatta, "SUB" for Juanda
  @Column
  private String destinationAirport; // e.g., "SIN" for Singapore Changi Airport
  @Column
  private long departureTime; // epoch time in milliseconds
  @Column
  private long arrivalTime; // epoch time in milliseconds
  @Column
  private SeatClass seatClass; // e.g., ECONOMY, BUSINESS, FIRST
}
