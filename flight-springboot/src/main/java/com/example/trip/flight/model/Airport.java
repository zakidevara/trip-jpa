package com.example.trip.flight.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Airport {
  @Id
  private String code; // IATA code
  @Column
  private String name; // Airport name
  @Column
  private String city; // City where the airport is located
  @Column
  private String country; // Country where the airport is located
  @Column
  private Coordinate coordinate;
}
