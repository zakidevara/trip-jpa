package com.example.trip.flight.service;

import com.example.trip.flight.model.Fare;
import com.example.trip.flight.model.FarePerPax;
import com.example.trip.flight.model.FlightRoute;
import com.example.trip.flight.model.FlightSegment;
import com.example.trip.flight.model.SeatClass;
import com.example.trip.flight.repository.FlightRouteRepository;
import com.example.trip.flight.repository.FlightSegmentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightRouteService {
  private final FlightRouteRepository flightRouteRepository;
  private final FlightSegmentRepository flightSegmentRepository;

  public FlightRouteService(FlightRouteRepository flightRouteRepository, FlightSegmentRepository flightSegmentRepository) {
    this.flightRouteRepository = flightRouteRepository;
    this.flightSegmentRepository = flightSegmentRepository;
  }

  public void populateAllRoutes() {
    // Implementation to generate all possible flight routes
    flightRouteRepository.saveAll(List.of(
        generateRoute("JFK", "LAX", "AA", "100", "Boeing 737", 1701424800000L, 1701435600000L, SeatClass.ECONOMY,
            FarePerPax.builder()
                .adult(Fare.builder().amount(new BigDecimal("300.00")).currency("USD").build())
                .child(Fare.builder().amount(new BigDecimal("200.00")).currency("USD").build())
                .infant(Fare.builder().amount(new BigDecimal("50.00")).currency("USD").build())
                .build()
        ),
        generateRoute("JFK", "LAX", "AA", "101", "Boeing 737", 1701439200000L, 1701450000000L, SeatClass.ECONOMY,
            FarePerPax.builder()
                .adult(Fare.builder().amount(new BigDecimal("320.00")).currency("USD").build())
                .child(Fare.builder().amount(new BigDecimal("220.00")).currency("USD").build())
                .infant(Fare.builder().amount(new BigDecimal("60.00")).currency("USD").build())
                .build()
        ),
        generateRoute("LAX", "JFK", "AA", "200", "Boeing 737", 1701446400000L, 1701457200000L, SeatClass.ECONOMY,
            FarePerPax.builder()
                .adult(Fare.builder().amount(new BigDecimal("350.00")).currency("USD").build())
                .child(Fare.builder().amount(new BigDecimal("250.00")).currency("USD").build())
                .infant(Fare.builder().amount(new BigDecimal("70.00")).currency("USD").build())
                .build()
        ),
        generateRoute("LAX", "JFK", "AA", "201", "Boeing 737", 1701453600000L, 1701464400000L, SeatClass.ECONOMY,
            FarePerPax.builder()
                .adult(Fare.builder().amount(new BigDecimal("370.00")).currency("USD").build())
                .child(Fare.builder().amount(new BigDecimal("270.00")).currency("USD").build())
                .infant(Fare.builder().amount(new BigDecimal("80.00")).currency("USD").build())
                .build()
        ),
        generateRoute("JFK", "LAX", "DL", "200", "Airbus A320", 1701428400000L, 1701439200000L, SeatClass.BUSINESS,
            FarePerPax.builder()
                .adult(Fare.builder().amount(new BigDecimal("800.00")).currency("USD").build())
                .child(Fare.builder().amount(new BigDecimal("600.00")).currency("USD").build())
                .infant(Fare.builder().amount(new BigDecimal("100.00")).currency("USD").build())
                .build()
        ),
        generateRoute("LAX", "JFK", "UA", "300", "Boeing 777", 1701442800000L, 1701453600000L, SeatClass.FIRST,
            FarePerPax.builder()
                .adult(Fare.builder().amount(new BigDecimal("1500.00")).currency("USD").build())
                .child(Fare.builder().amount(new BigDecimal("1200.00")).currency("USD").build())
                .infant(Fare.builder().amount(new BigDecimal("200.00")).currency("USD").build())
                .build()
        )
    ));
  }

  private FlightRoute generateRoute(String origin, String destination, String airlineId, String flightNumber, String aircraftType, long departureTime, long arrivalTime, SeatClass seatClass, FarePerPax farePerPax) {
    FlightRoute route = FlightRoute.builder()
        .id(String.format("%s.%s.%s.%s.%s.%s.%s.%s", origin, destination, airlineId, seatClass,
            new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(departureTime)),
            new java.text.SimpleDateFormat("HH:mm").format(new java.util.Date(departureTime)),
            new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(arrivalTime)),
            new java.text.SimpleDateFormat("HH:mm").format(new java.util.Date(arrivalTime))
        ))
        .originAirport(origin)
        .destinationAirport(destination)
        .airlineId(airlineId)
        .departureTime(departureTime)
        .arrivalTime(arrivalTime)
        .seatClass(seatClass)
        .providerFare(farePerPax)
        .segments(
            generateSegments(origin, destination, airlineId, flightNumber, aircraftType, departureTime, arrivalTime, seatClass, Math.random() < 0.5 ? 1 : 2)
        )
        .build();
    return flightRouteRepository.save(route);
  }

  private List<FlightSegment> generateSegments(String origin, String destination, String airlineId, String flightNumber, String aircraftType, long departureTime, long arrivalTime, SeatClass seatClass, int numberOfSegments) {
    List<FlightSegment> segments = new ArrayList<>();
    for (int i = 0; i < numberOfSegments; i++) {
      String segmentOrigin = (i == 0) ? origin : "INT" + i; // Intermediate airport code
      String segmentDestination = (i == numberOfSegments - 1) ? destination : "INT" + (i + 1);
      long segmentDepartureTime = departureTime + (i * 3600000L); // Each segment departs an hour after the previous
      long segmentArrivalTime = (i == numberOfSegments - 1) ? arrivalTime : segmentDepartureTime + 3600000L; // Each segment lasts one hour
      FlightSegment segment = FlightSegment.builder()
          .originAirport(segmentOrigin)
          .destinationAirport(segmentDestination)
          .airlineId(airlineId)
          .flightNumber(flightNumber + "-" + (i + 1))
          .aircraftType(aircraftType)
          .departureTime(segmentDepartureTime)
          .arrivalTime(segmentArrivalTime)
          .seatClass(seatClass)
          .id(String.format("%s.%s.%s-%s.%s.%s.%s.%s.%s", segmentOrigin, segmentDestination, airlineId, flightNumber + "-" + (i + 1), seatClass,
              new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(segmentDepartureTime)),
              new java.text.SimpleDateFormat("HH:mm").format(new java.util.Date(segmentDepartureTime)),
              new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(segmentArrivalTime)),
              new java.text.SimpleDateFormat("HH:mm").format(new java.util.Date(segmentArrivalTime))
          ))
          .build();
      flightSegmentRepository.save(segment);
      segments.add(segment);
    }
    return segments;
  }
}
