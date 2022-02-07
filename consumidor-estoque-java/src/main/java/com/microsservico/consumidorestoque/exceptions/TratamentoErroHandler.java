package com.microsservico.consumidorestoque.exceptions;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.util.ErrorHandler;

public class TratamentoErroHandler implements ErrorHandler {

  @Override
  public void handleError(Throwable t) {
    String nomeDaFila = ((ListenerExecutionFailedException) t).getFailedMessage().getMessageProperties().getConsumerQueue();
    System.out.println(nomeDaFila);

    String mensagem = new String(((ListenerExecutionFailedException) t).getFailedMessage().getBody());
    System.out.println(mensagem);

    System.out.println(t.getCause().getMessage());

    // Logar no ElasticSearch
    //Logar no Cloud Watch(AWS)
    //....

    throw new AmqpRejectAndDontRequeueException("Não deve retornar a fila");
  }
}
