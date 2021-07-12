### Microserviço em Java Spring Boot com RabbitMQ

Este projeto é a criação de um microserviço reponsável por receber requisições e gerar mensagens
para os demais consumidores.

Teremos 1 produtor e 2 consumidores.
O produtor será em java com spring, 1 consumidor em java com spring e o outro em nodejs.

![Projeto](https://user-images.githubusercontent.com/51996690/120472712-9cdca900-c37c-11eb-967d-a4749f764c4e.png)

Até o momento foi implementado o consumidor de mensagens para a fila ESTOQUE. As mensagens são classes(objetos) serializados.
