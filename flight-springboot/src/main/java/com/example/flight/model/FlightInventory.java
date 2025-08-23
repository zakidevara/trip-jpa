package com.example.flight.model;

import lombok.Data;

@Data
public class FlightInventory {
  private Flight flight; // Flight details
  private SeatClass seatClass; // Seat class (e.g., Economy, Business)
  private FarePerPax providerFare; // Fare offered by the provider
  private FarePerPax customerFare; // Fare we offer to customers
}
