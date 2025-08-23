package com.example.trip.flight.model;

import lombok.Data;

@Data
public class Country {
  private String code; // ISO country code
  private String name; // Country name

  private Coordinate coordinate;
}
