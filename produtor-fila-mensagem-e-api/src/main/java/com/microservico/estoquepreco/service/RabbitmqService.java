package com.microservico.estoquepreco.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  public void enviaMensagem(String nomeFila, Object mensagem){
    try {
      String mensagemJson = this.objectMapper.writeValueAsString(mensagem);
      this.rabbitTemplate.convertAndSend(nomeFila, mensagemJson);
    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
