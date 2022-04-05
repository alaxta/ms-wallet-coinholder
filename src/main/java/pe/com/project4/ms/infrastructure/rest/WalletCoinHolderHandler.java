package pe.com.project4.ms.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.project4.ms.infrastructure.event.WalletCoinAccountCreatedEvent;
import pe.com.project4.ms.infrastructure.producer.WalletCoinHolderKafkaProducer;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class WalletCoinHolderHandler {

    private final WalletCoinHolderKafkaProducer walletHolderKafkaProducer;

    public Mono<ServerResponse> postWalletHolder(ServerRequest serverRequest) {
        log.debug("Entro al postWalletHolder");
        return serverRequest.bodyToMono(WalletCoinAccountCreatedEvent.class)
                .map(walletAccountCreatedEvent -> {
                    walletHolderKafkaProducer.sendMessage(walletAccountCreatedEvent);
                    return walletAccountCreatedEvent;
                })
                .then(ServerResponse.noContent().build());
    }

}
