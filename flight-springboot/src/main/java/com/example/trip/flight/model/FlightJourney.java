package com.example.trip.flight.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FlightJourney {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id; // Unique identifier for the flight journey

  @ManyToMany
  private List<FlightRoute> departureRoutes; // List of departure routes (for one-way or multi-city)
  @ManyToMany
  private List<FlightRoute> returnRoutes; // List of return routes (for round-trip)

  @Column
  private SeatClass seatClass; // Seat class (e.g., Economy, Business)
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "adult.amount", column = @Column(name = "provider_adult_amount")),
      @AttributeOverride(name = "adult.currency", column = @Column(name = "provider_adult_currency")),
      @AttributeOverride(name = "child.amount", column = @Column(name = "provider_child_amount")),
      @AttributeOverride(name = "child.currency", column = @Column(name = "provider_child_currency")),
      @AttributeOverride(name = "infant.amount", column = @Column(name = "provider_infant_amount")),
      @AttributeOverride(name = "infant.currency", column = @Column(name = "provider_infant_currency"))
  })
  private FarePerPax providerFare; // Fare offered by the provider
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "adult.amount", column = @Column(name = "customer_adult_amount")),
      @AttributeOverride(name = "adult.currency", column = @Column(name = "customer_adult_currency")),
      @AttributeOverride(name = "child.amount", column = @Column(name = "customer_child_amount")),
      @AttributeOverride(name = "child.currency", column = @Column(name = "customer_child_currency")),
      @AttributeOverride(name = "infant.amount", column = @Column(name = "customer_infant_amount")),
      @AttributeOverride(name = "infant.currency", column = @Column(name = "customer_infant_currency"))
  })
  private FarePerPax customerFare; // Fare we offer to customers
}
