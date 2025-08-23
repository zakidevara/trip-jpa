package com.example.flight.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Fare {
  private BigDecimal amount;
  private String currency;
}
