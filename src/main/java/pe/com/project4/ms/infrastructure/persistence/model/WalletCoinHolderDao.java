package pe.com.project4.ms.infrastructure.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.project4.ms.domain.DocumentType;
import pe.com.project4.ms.domain.WalletHolder;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("walletCBHolder")
public class WalletCoinHolderDao {
    @Id
    private String id;
    private String names;
    private String paternalSurname;
    private String maternalSurname;
    private String documentNumber;
    private DocumentType documentType;
    @Indexed(unique = true)
    private String phoneNumber;
    private String email;

    public WalletCoinHolderDao(WalletHolder walletHolder) {
        id = walletHolder.getId();
        names = walletHolder.getNames();
        paternalSurname = walletHolder.getPaternalSurname();
        maternalSurname = walletHolder.getMaternalSurname();
        documentNumber = walletHolder.getDocumentNumber();
        documentType = walletHolder.getDocumentType();
        phoneNumber = walletHolder.getPhoneNumber();
        email = walletHolder.getEmail();
    }

    public WalletHolder toWalletHolder() {
        WalletHolder walletHolder = new WalletHolder();
        walletHolder.setId(id);
        walletHolder.setNames(names);
        walletHolder.setPaternalSurname(paternalSurname);
        walletHolder.setMaternalSurname(maternalSurname);
        walletHolder.setDocumentNumber(documentNumber);
        walletHolder.setDocumentType(documentType);
        walletHolder.setPhoneNumber(phoneNumber);
        walletHolder.setEmail(email);
        return walletHolder;
    }
}
