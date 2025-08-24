package com.example.trip.flight.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class City {
  @Id
  private String code; // IATA city code
  @Column
  private String name; // City name
  @Column
  private String country; // Country where the city is located
  @Embedded
  private Coordinate coordinate;
  @ManyToMany
  private List<Airport> nearbyAirports; // List of nearby airports
}
