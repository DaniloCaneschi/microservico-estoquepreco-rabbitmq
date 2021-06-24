package com.microservico.estoquepreco.controller;

import com.microservico.estoquepreco.constantes.RabbitmqConstantes;
import com.microservico.estoquepreco.dto.PrecoDto;
import com.microservico.estoquepreco.service.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "preco")
public class PrecoController {

  @Autowired
  private RabbitmqService rabbitmqService;

  @PutMapping
  private ResponseEntity alteraPreco(@RequestBody PrecoDto precoDto){
    this.rabbitmqService.enviaMensagem(RabbitmqConstantes.FILA_PRECO, precoDto);
    return new ResponseEntity(HttpStatus.OK);
  }
}
