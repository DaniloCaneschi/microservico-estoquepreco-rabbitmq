package com.microsservico.consumidorestoque.consumer;

import org.springframework.amqp.rabbit.listener.ConditionalRejectingErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;

public class CustomErrorStrategy extends ConditionalRejectingErrorHandler.DefaultExceptionStrategy {
  @Override
  public boolean isFatal(Throwable t) {
    System.out.println(new String(((ListenerExecutionFailedException) t).getFailedMessage().getBody()));

    return t.getCause() instanceof IllegalArgumentException;
  }
}
