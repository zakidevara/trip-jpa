package com.example.trip.flight.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Country {
  @Id
  private String code; // ISO country code
  @Column
  private String name; // Country name
  @Embedded
  private Coordinate coordinate;
  @OneToMany
  @JoinColumn(name = "country_code")
  private List<City> cities;
}
