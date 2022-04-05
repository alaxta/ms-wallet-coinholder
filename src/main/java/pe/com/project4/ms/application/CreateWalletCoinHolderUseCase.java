package pe.com.project4.ms.application;

import pe.com.project4.ms.domain.WalletHolder;
import pe.com.project4.ms.infrastructure.event.WalletCoinAccountCreatedEvent;
import reactor.core.publisher.Mono;

public interface CreateWalletCoinHolderUseCase {
    Mono<WalletHolder> save(WalletCoinAccountCreatedEvent walletAccountCreatedEvent);
}
