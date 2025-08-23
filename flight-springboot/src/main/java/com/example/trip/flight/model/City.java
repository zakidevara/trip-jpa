package com.example.trip.flight.model;

import lombok.Data;

@Data
public class City {
  private String name; // City name
  private String country; // Country where the city is located

  private Coordinate coordinate;
}
