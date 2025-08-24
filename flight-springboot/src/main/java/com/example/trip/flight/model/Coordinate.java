package com.example.trip.flight.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Coordinate {
  private double latitude;
  private double longitude;
}
