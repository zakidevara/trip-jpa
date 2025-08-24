package com.example.trip.flight.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightRoute {
  @Id
  private String id; // e.g., "CGK.SIN.GA.ECONOMY.2025-12-31.08:00.2025-12-31.10:00"
  @Column
  private String airlineId; // e.g., "GA" for Garuda Indonesia
  @Column
  private String originAirport; // e.g., "CGK" for Soekarno-Hatta, "SUB" for Juanda
  @Column
  private String destinationAirport; // e.g., "SIN" for Singapore Changi Airport
  @Column
  private SeatClass seatClass; // e.g., ECONOMY, BUSINESS, FIRST
  @Column
  private long departureTime; // epoch time in milliseconds
  @Column
  private long arrivalTime; // epoch time in milliseconds
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "adult.amount", column = @Column(name = "route_customer_adult_amount")),
      @AttributeOverride(name = "adult.currency", column = @Column(name = "route_customer_adult_currency")),
      @AttributeOverride(name = "child.amount", column = @Column(name = "route_customer_child_amount")),
      @AttributeOverride(name = "child.currency", column = @Column(name = "route_customer_child_currency")),
      @AttributeOverride(name = "infant.amount", column = @Column(name = "route_customer_infant_amount")),
      @AttributeOverride(name = "infant.currency", column = @Column(name = "route_customer_infant_currency"))
  })
  private FarePerPax providerFare; // Fare offered by the provider

  @ManyToMany
  private List<FlightSegment> segments; // List of flight segments (for connecting flights)

  public String getDepartureDate() {
    return getFormattedDate(departureTime);
  }

  public String getArrivalDate() {
    return getFormattedDate(arrivalTime);
  }

  public String getDepartureTime() {
    return getFormattedTime(departureTime);
  }

  public String getArrivalTime() {
    return getFormattedTime(arrivalTime);
  }

  public String getId() {
    if (id != null && !id.isEmpty()) {
      return id;
    }
    id = String.format("%s.%s.%s.%s.%s.%s.%s.%s", originAirport, destinationAirport, airlineId, seatClass,
        getDepartureDate(), getDepartureTime(), getArrivalDate(), getArrivalTime());
    return id;
  }

  private String getFormattedDate(long epochTime) {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date(epochTime));
  }

  private String getFormattedTime(long epochTime) {
    return new SimpleDateFormat("HH:mm").format(new Date(epochTime));
  }
}
