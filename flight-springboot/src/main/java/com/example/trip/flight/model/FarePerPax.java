package com.example.trip.flight.model;

import lombok.Data;

@Data
public class FarePerPax {
  private Fare adult;
  private Fare child;
  private Fare infant;
}
