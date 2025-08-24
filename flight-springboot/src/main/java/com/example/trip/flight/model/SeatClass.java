package com.example.trip.flight.model;

public enum SeatClass {
  ECONOMY("Economy"),
  BUSINESS("Business"),
  FIRST("First Class");

  private String label;
  SeatClass(String label) {
    this.label = label;
  }
}
