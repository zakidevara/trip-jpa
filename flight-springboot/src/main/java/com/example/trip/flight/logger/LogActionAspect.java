package com.example.trip.flight.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogActionAspect {
  private static final Logger LOGGER = LoggerFactory.getLogger(LogActionAspect.class);
  private final ExpressionParser parser = new SpelExpressionParser();

  public LogActionAspect() {
  }

  @Around("@annotation(logAction)")
  public Object logMethod(ProceedingJoinPoint joinPoint, LogAction logAction) throws Throwable {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    String[] parameterNames = signature.getParameterNames();
    Object[] args = joinPoint.getArgs();

    StandardEvaluationContext context = new StandardEvaluationContext();
    for (int i = 0; i < parameterNames.length; i++) {
      context.setVariable(parameterNames[i], args[i]);
    }

    long startTime = System.currentTimeMillis();
    Object result;

    try {
      MDC.put("action_name", logAction.value());

      // Evaluate input expression
      if (!logAction.inputCountExpression().isEmpty() && logAction.inputCountExpression().startsWith("#")) {
        Integer inputCount = parser.parseExpression(logAction.inputCountExpression()).getValue(context, Integer.class);
        MDC.put("input_count", String.valueOf(inputCount));
      } else {
        MDC.put("input_count", logAction.inputCountExpression());
      }

      // Log specific parameters from the 'logParameters' array
      for (String paramToLog : logAction.logParameters()) {
        MDC.put(paramToLog, String.valueOf(context.lookupVariable(paramToLog)));
      }

      result = joinPoint.proceed();

      // Evaluate output expression
      if (!logAction.outputCountExpression().isEmpty() && logAction.outputCountExpression().startsWith("#")) {
        context.setVariable("result", result);
        Integer outputCount = parser.parseExpression(logAction.outputCountExpression()).getValue(context, Integer.class);
        MDC.put("output_count", String.valueOf(outputCount));
      } else {
        MDC.put("output_count", logAction.outputCountExpression());
      }

      MDC.put("status", "success");

    } catch (Throwable e) {
      MDC.put("status", "failure");
      throw e;
    } finally {
      long duration = System.currentTimeMillis() - startTime;
      MDC.put("latency_ms", String.valueOf(duration));
      LOGGER.info("Action '{}' completed.", logAction.value());
      MDC.clear();
    }
    return result;
  }
}
