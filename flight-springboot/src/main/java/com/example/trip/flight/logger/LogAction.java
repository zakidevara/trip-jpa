package com.example.trip.flight.logger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAction {
  String value() default "unnamed-action";
  String[] logParameters() default {};
  String inputCountExpression() default "";
  String outputCountExpression() default "";
}
