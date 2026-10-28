
package com.example.kafka_particiones.controller;

import com.example.kafka_particiones.service.KafkaProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaProducerService producerService;

    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/api/kafka/send")
    public String enviarMensaje(@RequestParam String message) {
        producerService.enviarMensaje(message);
        return "Mensaje enviado a Kafka: " + message;
    }

    @GetMapping("/api/kafka/send-with-key")
    public String enviarMensajeConClave(
            @RequestParam String key,
            @RequestParam String message) {
        producerService.enviarMensajeConClave(key, message);
        return "Mensaje enviado a Kafka con clave '" + key + "': " + message;
    }
}
