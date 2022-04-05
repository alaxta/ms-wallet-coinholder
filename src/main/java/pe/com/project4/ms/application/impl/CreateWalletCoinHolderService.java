package pe.com.project4.ms.application.impl;

import lombok.RequiredArgsConstructor;
import pe.com.project4.ms.application.CreateWalletCoinHolderUseCase;
import pe.com.project4.ms.application.repository.WalletCoinHolderRepository;
import pe.com.project4.ms.domain.WalletHolder;
import pe.com.project4.ms.infrastructure.event.WalletCoinAccountCreatedEvent;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateWalletCoinHolderService implements CreateWalletCoinHolderUseCase {

    private final WalletCoinHolderRepository walletHolderRepository;

    @Override
    public Mono<WalletHolder> save(WalletCoinAccountCreatedEvent walletAccountCreatedEvent) {
        return walletHolderRepository.save(walletAccountCreatedEvent.toWalletHolder());
    }

}
