package pe.com.project4.ms.infrastructure.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.project4.ms.application.CreateWalletCoinHolderUseCase;
import pe.com.project4.ms.infrastructure.event.WalletCoinAccountCreatedEvent;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class WalletCoinHolderKafkaConsumer {

    private final CreateWalletCoinHolderUseCase createWalletCoinHolderUseCase;

    @KafkaListener(topics = {"WALLETBC-ACCOUNT-CREATED"}, groupId = "BCWALLET")
    public void consume(WalletCoinAccountCreatedEvent walletAccountCreated) {
        log.info("==> Consuming Message {}", walletAccountCreated);
        createWalletCoinHolderUseCase.save(walletAccountCreated).subscribe(c -> log.info(c.toString()));
    }

}
