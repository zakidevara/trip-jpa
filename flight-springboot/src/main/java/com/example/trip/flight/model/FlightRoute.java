package com.example.trip.flight.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class FlightRoute {
  @Id
  private String id; // e.g., "CGK.SIN.GA.ECONOMY.2025-12-31.08:00.2025-12-31.10:00"
  @Column
  private String airlineId; // e.g., "GA" for Garuda Indonesia
  @Column
  private String originAirport; // e.g., "CGK" for Soekarno-Hatta, "SUB" for Juanda
  @Column
  private String destinationAirport; // e.g., "SIN" for Singapore Changi Airport
  @Column
  private long departureTime; // epoch time in milliseconds
  @Column
  private long arrivalTime; // epoch time in milliseconds

  @ManyToMany
  @JoinColumn(name = "flight_segments_id")
  private List<FlightSegment> segments; // List of flight segments (for connecting flights)
}
