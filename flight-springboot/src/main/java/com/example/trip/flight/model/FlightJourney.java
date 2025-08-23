package com.example.trip.flight.model;

import lombok.Data;

import java.util.List;

@Data
public class FlightJourney {
  private List<FlightRoute> departureRoutes; // List of departure routes (for one-way or multi-city)
  private List<FlightRoute> returnRoutes; // List of return routes (for round-trip)

  private SeatClass seatClass; // Seat class (e.g., Economy, Business)
  private FarePerPax providerFare; // Fare offered by the provider
  private FarePerPax customerFare; // Fare we offer to customers
}
