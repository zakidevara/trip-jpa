package com.example.trip.flight;

import com.example.trip.flight.service.AirportService;
import com.example.trip.flight.service.FlightJourneyService;
import com.example.trip.flight.service.FlightRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightJpaApplication implements CommandLineRunner {
  @Autowired
  private FlightJourneyService flightJourneyService;
  @Autowired
  private AirportService airportService;
  @Autowired
  private FlightRouteService flightRouteService;

  public static void main(String[] args) {
    SpringApplication.run(FlightJpaApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    generateData();
  }

  private void generateData() {
    flightRouteService.generateAllRoutes();
    flightJourneyService.generateCheapestJourneyOneWay("JFK", "LAX");
  }
}
