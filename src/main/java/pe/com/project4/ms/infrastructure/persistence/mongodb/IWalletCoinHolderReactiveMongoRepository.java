package pe.com.project4.ms.infrastructure.persistence.mongodb;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import pe.com.project4.ms.infrastructure.persistence.model.WalletCoinHolderDao;
import reactor.core.publisher.Mono;

public interface IWalletCoinHolderReactiveMongoRepository extends ReactiveMongoRepository<WalletCoinHolderDao, String> {
    Mono<WalletCoinHolderDao> findByPhoneNumber(String phoneNumber);

    Mono<WalletCoinHolderDao> findByDocumentNumber(String documentNumber);
}
