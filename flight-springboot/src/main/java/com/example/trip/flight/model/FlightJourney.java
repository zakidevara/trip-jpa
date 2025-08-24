package com.example.trip.flight.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class FlightJourney {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id; // Unique identifier for the flight journey

  @ManyToMany
  @JoinColumn(name = "departure_routes_id")
  private List<FlightRoute> departureRoutes; // List of departure routes (for one-way or multi-city)
  @ManyToMany
  @JoinColumn(name = "return_routes_id")
  private List<FlightRoute> returnRoutes; // List of return routes (for round-trip)

  @Column
  private SeatClass seatClass; // Seat class (e.g., Economy, Business)
  @Column
  private FarePerPax providerFare; // Fare offered by the provider
  @Column
  private FarePerPax customerFare; // Fare we offer to customers
}
