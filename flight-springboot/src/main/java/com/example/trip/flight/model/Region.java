package com.example.trip.flight.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Region {
  @Id
  private String code; // Region code
  @Column
  private String name; // Region name, e.g., "Europe", "Asia"
  @OneToMany
  @JoinColumn(name = "region_code")
  private List<Country> countries;
}
