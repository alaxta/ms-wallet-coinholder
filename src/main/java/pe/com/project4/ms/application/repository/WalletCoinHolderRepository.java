package pe.com.project4.ms.application.repository;

import pe.com.project4.ms.domain.WalletHolder;
import reactor.core.publisher.Mono;

public interface WalletCoinHolderRepository {
    Mono<WalletHolder> save(WalletHolder walletHolder);
    Mono<WalletHolder> findByPhoneNumber(String phoneNumber);
    Mono<WalletHolder> findByDocumentNumber(String documentNumber);
}
