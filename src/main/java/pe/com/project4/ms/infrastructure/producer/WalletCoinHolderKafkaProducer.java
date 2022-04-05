package pe.com.project4.ms.infrastructure.producer;

import lombok.extern.slf4j.Slf4j;
import pe.com.project4.ms.infrastructure.event.WalletCoinAccountCreatedEvent;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WalletCoinHolderKafkaProducer {

    private final KafkaTemplate<String, WalletCoinAccountCreatedEvent> kafkaTemplate;
    private final String topic;

    public WalletCoinHolderKafkaProducer(KafkaTemplate<String, WalletCoinAccountCreatedEvent> kafkaTemplate,
                                         @Value("${spring.kafka.consumer.topic.name}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendMessage(WalletCoinAccountCreatedEvent walletAccountCreatedEvent) {
        log.debug("Producing message {}", walletAccountCreatedEvent.toString());
        kafkaTemplate.send(topic, walletAccountCreatedEvent);
    }

}
