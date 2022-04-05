package pe.com.project4.ms.infrastructure.persistence.mongodb;

import lombok.RequiredArgsConstructor;
import pe.com.project4.ms.application.repository.WalletCoinHolderRepository;
import pe.com.project4.ms.domain.WalletHolder;
import pe.com.project4.ms.infrastructure.persistence.model.WalletCoinHolderDao;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class WalletCoinHolderReactiveMongoRepository implements WalletCoinHolderRepository {

    private final IWalletCoinHolderReactiveMongoRepository walletHolderReactiveMongoRepository;

    @Override
    public Mono<WalletHolder> save(WalletHolder walletHolder) {
        return walletHolderReactiveMongoRepository.save(new WalletCoinHolderDao(walletHolder))
                .map(WalletCoinHolderDao::toWalletHolder);
    }

    @Override
    public Mono<WalletHolder> findByPhoneNumber(String phoneNumber) {
        return walletHolderReactiveMongoRepository.findByPhoneNumber(phoneNumber)
                .map(WalletCoinHolderDao::toWalletHolder);
    }

    @Override
    public Mono<WalletHolder> findByDocumentNumber(String documentNumber) {
        return walletHolderReactiveMongoRepository.findByDocumentNumber(documentNumber)
                .map(WalletCoinHolderDao::toWalletHolder);
    }
}
