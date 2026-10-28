
package com.example.kafka_particiones.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "${app.kafka.topic}")
    public void recibirMensaje(String mensaje) {
        System.out.println("Mensaje recibido por Kafka: " + mensaje);
    }
}
