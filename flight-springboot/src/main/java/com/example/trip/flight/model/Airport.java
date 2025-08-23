package com.example.trip.flight.model;

import lombok.Data;

@Data
public class Airport {
  private String code; // IATA code
  private String name; // Airport name
  private String city; // City where the airport is located
  private String country; // Country where the airport is located

  private Coordinate coordinate;
}
