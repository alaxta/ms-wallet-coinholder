package pe.com.project4.ms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletHolder {
    private String id;
    private String names;
    private String paternalSurname;
    private String maternalSurname;
    private String documentNumber;
    private DocumentType documentType;
    private String phoneNumber;
    private String email;
}
